package com.example.applucaskafer.view.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applucaskafer.R;

public class MenuActivity extends AppCompatActivity {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button btMenuUsuarios;

        this.context = context;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btMenuUsuarios = findViewById(R.id.button_lista_usuario_Menu);

        btMenuUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela = new Intent(context, ListasusuariosActivity.class);
                startActivity(tela);
            }
        });
    }
}


