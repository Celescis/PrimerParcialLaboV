package com.cisternas.pplabv;

public class ModelUsuario {
    private String nombre;
    private String password;
    private ETipo tipo;

    public ModelUsuario() {
    }

    public ModelUsuario(String nombre, String password, ETipo tipo) {
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
