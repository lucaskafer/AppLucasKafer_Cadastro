package com.example.applucaskafer.view.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.applucaskafer.R;
import com.example.applucaskafer.view.config.DadosOpenHelper;
import com.example.applucaskafer.view.config.Globais;
import com.example.applucaskafer.view.config.Tabelas;
import com.example.applucaskafer.view.controller.UsuarioController;
import com.example.applucaskafer.view.model.Usuario;

import java.util.ArrayList;

public class ListasusuariosActivity extends AppCompatActivity {

    ListView listaUsuarios;
    private Context context;
    private SQLiteDatabase conexao;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listasusuarios);
        DadosOpenHelper banco = new DadosOpenHelper(context);
        listaUsuarios = findViewById(R.id.ListaUsuarios);

        this.conexao = banco.getWritableDatabase();
        this.context = context;

        atualizarLista();

    }

    public void atualizarLista()
    {
        try {

            UsuarioController controller = new UsuarioController(context);
            ArrayList<Usuario> lista = controller.lista();

            if (lista!= null)
            {
                ArrayAdapter<Usuario>adapter=new ArrayAdapter<Usuario>(context, android.R.layout.simple_list_item_1,lista);
                listaUsuarios.setAdapter(adapter);
            }

        }catch (Exception ex)
        {
            Globais.exibirMensagens(ex.getMessage(), context);
        }
    }

}
