package com.example.applucaskafer.view.model;

public class Usuario {
    private int id;
    private String login;
    private String senha;

    public String getId () {
        return String.valueOf(id);
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getLogin () {
        return login;
    }

    public void setLogin (String login) {
        this.login = login;
    }

    public String getSenha () {
        return senha;
    }

    public void setSenha (String senha) {
        this.senha = senha;
    }

    public void setId (String id) {
    }
}
