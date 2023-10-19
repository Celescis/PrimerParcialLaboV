package com.cisternas.pplabv;

import java.io.Serializable;

enum ETipo {
    Administrador,
    Usuario
}

public class Usuario implements Serializable {

    private String nombre;
    private String password;
    private ETipo tipo;

    public Usuario() {
    }

    public Usuario(String nombre, String password, ETipo tipo) {
        super();
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(ETipo tipo) {
        this.tipo = tipo;
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public ETipo getTipo() {
        return tipo;
    }
}
