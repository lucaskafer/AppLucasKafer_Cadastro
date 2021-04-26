package com.example.applucaskafer.view.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.applucaskafer.view.config.DadosOpenHelper;
import com.example.applucaskafer.view.config.Globais;
import com.example.applucaskafer.view.config.Tabelas;
import com.example.applucaskafer.view.model.Usuario;
import java.util.ArrayList;

public class UsuarioController {

    private Context context;
    private SQLiteDatabase conexao;

    public UsuarioController (Context context) {
       DadosOpenHelper banco = new DadosOpenHelper(context);
       this.conexao = banco.getWritableDatabase();
        this.context = context;

    }
    // metodos ( buscar, listar, alterar, incluir, excluir)

    public Usuario login (String usuario, String senha) {
        try {
            senha = Globais.md5(senha);

            Usuario objeto = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ");
            sql.append(Tabelas.TB_USUARIOS);
            sql.append(" WHERE login = '" + usuario + "' ");
            sql.append(" AND senha = '" + senha + "' ");

            Cursor resultado = conexao.rawQuery(sql.toString(), null);
            if (resultado.getCount() > 0) {
                resultado.moveToFirst();
                objeto = new Usuario();
                objeto.setId(resultado.getInt(resultado.getColumnIndexOrThrow("id")));
                objeto.setLogin(resultado.getString(resultado.getColumnIndexOrThrow("login")));
                objeto.setSenha(resultado.getString(resultado.getColumnIndexOrThrow("senha")));
            }

            return objeto;

        } catch (Exception ex) {
            Globais.exibirMensagens(ex.getMessage(), context);
            return null;
        }
    }

    public ArrayList<Usuario> lista () {

        ArrayList<Usuario> listagem = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ");
            sql.append(Tabelas.TB_USUARIOS);

            Cursor resultado = conexao.rawQuery(sql.toString(), null);
            if (resultado.moveToFirst()) {
                Usuario objeto;
                do {
                    objeto = new Usuario();
                    objeto.setId(resultado.getColumnIndexOrThrow("id"));
                    objeto.setId(resultado.getColumnIndexOrThrow("login"));
                    listagem.add(objeto);

                } while (resultado.moveToFirst());

            }
            return listagem;

        } catch (Exception ex) {
            Globais.exibirMensagens(ex.getMessage(), context);
            return listagem;
        }
    }
}
