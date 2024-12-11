package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button);

        // Verifica se há um valor de contador passado na Intent
        Bundle extras = getIntent().getExtras();
        int contador = 2; // Valor inicial do botão é 2
        if (extras != null) {
            contador = extras.getInt("contador", 2); // Atualiza o contador se houver um valor passado
        }

        // Define o texto do botão com o valor do contador
        button.setText(String.valueOf(contador));

        // Evento de clique do botão
        int finalContador = contador;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma Intent para voltar para a Activity 1
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("contador", finalContador + 1); // Incrementa o valor do contador
                startActivity(intent); // Inicia a Activity 1 novamente
                finish(); // Finaliza a Activity 2 para garantir o retorno limpo
            }
        });
    }
}
