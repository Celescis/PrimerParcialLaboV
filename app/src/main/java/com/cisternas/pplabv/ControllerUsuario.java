package com.cisternas.pplabv;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class ControllerUsuario implements View.OnClickListener {
    private ModelUsuario model;
    private ViewUsuario view;
    private Bundle bundle;

    public ControllerUsuario(ViewUsuario view, ModelUsuario model) {
        this.view = view;
        this.model = model;
        this.cargarDatosRecuperados();
    }

    @Override
    public void onClick(View v) {
        if (validarDatos()) {
            this.view.llenarModelo();
            MainActivity.objetoEstatico.setNombre(model.getNombre());
            MainActivity.objetoEstatico.setPassword(model.getPassword());
            MainActivity.objetoEstatico.setTipo(model.getTipo());
            MainActivity.accion = 1;
            Toast.makeText(this.view.ac, "Editado con exito!", Toast.LENGTH_SHORT).show();
            view.ac.finish();
        }
    }

    private void cargarDatosRecuperados() {
        this.bundle = view.ac.getIntent().getExtras();
        Serializable oSerializado = bundle.getSerializable("objeto");
        Usuario o = (Usuario) oSerializado;

        if (o != null) {
            //LE PASO MI PRODUCTO RECIBIDO
            this.model.setNombre(o.getNombre());
            this.model.setTipo(o.getTipo());
            this.model.setPassword(o.getPassword());
        }
    }

    public boolean validarDatos() {
        boolean continuar = true;

        if (this.view.edNombre.getText().toString().length() < 3) {
            Toast.makeText(this.view.ac, "El nombre de usuario debe tener mas de 3 caracteres", Toast.LENGTH_LONG).show();
            continuar = false;
        }

        if (!this.view.edPass.getText().toString().equals(this.view.edPassDos.getText().toString())) {
            Toast.makeText(this.view.ac, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
            continuar = false;
        }

        if (this.view.edPass.getText().toString().isEmpty() && this.view.edPassDos.getText().toString().isEmpty()) {
            Toast.makeText(this.view.ac, "Debe colocar la contraseña", Toast.LENGTH_LONG).show();
            continuar = false;
        }
        return continuar;
    }
}
