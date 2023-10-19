package com.cisternas.pplabv;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class ViewUsuario {
    EditText edNombre;
    RadioButton rbAdmin;
    RadioButton rbUser;
    EditText edPass;
    EditText edPassDos;
    Button btnGuardar;
    Activity ac;
    ModelUsuario model;
    ControllerUsuario controller;

    public ViewUsuario(Activity ac, ModelUsuario model) {
        this.ac = ac;
        this.model = model;
    }

    public void setController(ControllerUsuario controller) {
        this.controller = controller;
        this.btnGuardar = ac.findViewById(R.id.btnGuardar);
        this.btnGuardar.setOnClickListener(controller);
        this.cargarElementos();
    }

    public void cargarElementos() {
        if (this.edNombre == null) {
            this.edNombre = this.ac.findViewById(R.id.edNombre);
        }

        if (this.rbAdmin == null) {
            this.rbAdmin = this.ac.findViewById(R.id.rbAdmin);
        }
        if (this.rbUser == null) {
            this.rbUser = this.ac.findViewById(R.id.rbUsuario);
        }

        if (this.edPass == null) {
            this.edPass = this.ac.findViewById(R.id.edPass);
        }
        if (this.edPassDos == null) {
            this.edPassDos = this.ac.findViewById(R.id.edPassDos);
        }

    }

    public void llenarModelo() {
        this.model.setNombre(this.edNombre.getText().toString());
        this.model.setPassword(this.edPass.getText().toString());

        if (this.rbAdmin.isChecked()) {
            this.model.setTipo(ETipo.Administrador);
        } else if (this.rbUser.isChecked()) {
            this.model.setTipo(ETipo.Usuario);
        }
    }

    public void mostrarModelo() {
        this.edNombre.setText(this.model.getNombre());
        this.edPass.setText(this.model.getPassword());
        this.edPassDos.setText(this.model.getPassword());

        if (this.model.getTipo() == ETipo.Administrador) {
            this.rbAdmin.setChecked(true);
            this.rbUser.setChecked(false);
        } else if (this.model.getTipo() == ETipo.Usuario) {
            this.rbAdmin.setChecked(false);
            this.rbUser.setChecked(true);
        }
    }
}
