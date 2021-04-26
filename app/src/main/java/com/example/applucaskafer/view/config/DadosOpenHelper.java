package com.example.applucaskafer.view.config;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DadosOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NM_BANCO = "banco";

    private Context context;

    public DadosOpenHelper (Context context) {
        super(context, NM_BANCO, null, VERSION);
        this.context = context;

    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        try {

            StringBuffer sqlUsuarios = new StringBuffer();
            sqlUsuarios.append(" CREATE TABLE IF NOT EXISTS ");
            sqlUsuarios.append(Tabelas.TB_USUARIOS);
            sqlUsuarios.append("(");
            sqlUsuarios.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sqlUsuarios.append("login VARCHAR(30) NOT NULL, ");
            sqlUsuarios.append("senha VARCHAR(100) NOT NULL ");
            sqlUsuarios.append(")");
            db.execSQL(sqlUsuarios.toString());

            StringBuilder sqlUserAdmin = new StringBuilder();
            sqlUserAdmin.append("INSERT INTO ");
            sqlUserAdmin.append(Tabelas.TB_USUARIOS);
            sqlUserAdmin.append("(login, senha) VALUES('admin', '" + Globais.md5 ("admin123") + "')");
            db.execSQL(sqlUserAdmin.toString());

        } catch (Exception ex) {
            Globais.exibirMensagens(ex.getMessage(), context);
        }
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

        try {

        } catch (Exception ex) {

        }

    }
}
