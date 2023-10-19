package com.cisternas.pplabv;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;


import android.os.Bundle;
import android.view.MenuItem;

public class EditarActivity extends AppCompatActivity {
    ActionBar actionBar;
    public static Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        //INICIO MI TOOLBAR CON EL BOTON BACK
        this.actionBar = super.getSupportActionBar();
        this.actionBar.setDisplayHomeAsUpEnabled(true);

        //AGARRO LOS EXTRA QUE PASO DEL MAIN ACTIVITY
        bundle = super.getIntent().getExtras();
        //CAMBIO EL TITULO DEL TOOLBAR
        actionBar.setTitle(R.string.titulo);

        //MODELO
        ModelUsuario model = new ModelUsuario();

        //VIEW
        ViewUsuario view = new ViewUsuario(this, model);

        //CONTROLLER
        ControllerUsuario controller = new ControllerUsuario(view, model);

        //LE PASO A MI VIEW EL CONTROLADOR
        view.setController(controller);

        //AHORA LE PIDO A LA VIEW QUE MUESTRE LOS DATOS RECIBIDOS
        view.mostrarModelo();
    }

    //SOBRESCRIBO EL METODO PARA DESTRUIR LA ACTIVITY AL TOCAR EL BOTON HOME
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}