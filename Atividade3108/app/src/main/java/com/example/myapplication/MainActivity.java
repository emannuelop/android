package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        // Verifica se há um valor de contador passado na Intent
        Bundle extras = getIntent().getExtras();
        int contador = 1; // Valor inicial do botão é 1
        if (extras != null) {
            contador = extras.getInt("contador", 1); // Atualiza o contador se houver um valor passado
        }

        // Define o texto do botão com o valor do contador
        button.setText(String.valueOf(contador));

        // Evento de clique do botão
        int finalContador = contador;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma Intent para abrir a Activity 2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("contador", finalContador + 1); // Incrementa o valor do contador
                startActivity(intent); // Inicia a Activity 2
                finish(); // Finaliza a Activity 1 para garantir que seja recriada ao voltar
            }
        });
    }
}
