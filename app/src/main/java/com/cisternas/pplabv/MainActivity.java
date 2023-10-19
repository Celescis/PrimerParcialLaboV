package com.cisternas.pplabv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int accion = 0;
    public static Usuario objetoEstatico = new Usuario();
    public List<Usuario> usuarios;
    AdapterUsuario adapterUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("CelesCis1", "pass1", ETipo.Administrador));
        usuarios.add(new Usuario("CelesCis2", "pass2", ETipo.Administrador));
        usuarios.add(new Usuario("CelesCis3", "pass3", ETipo.Usuario));
        usuarios.add(new Usuario("CelesCis4", "pass4", ETipo.Administrador));
        usuarios.add(new Usuario("CelesCis5", "pass5", ETipo.Usuario));
        usuarios.add(new Usuario("CelesCis6", "pass6", ETipo.Usuario));
        usuarios.add(new Usuario("CelesCis7", "pass7", ETipo.Administrador));
        usuarios.add(new Usuario("CelesCis8", "pass8", ETipo.Usuario));
        usuarios.add(new Usuario("CelesCis9", "pass9", ETipo.Usuario));
        usuarios.add(new Usuario("CelesCis10", "pass10", ETipo.Administrador));


        //GENERO EL RECYCLE VIEW PARA PASARLE ID DEL RECYCLE VIEW DE LAYOUT
        RecyclerView recyclerView = findViewById(R.id.rvUsuario);

        //GENERO EL ADAPTER PARA PASARLE LA LISTA
        this.adapterUsuario = new AdapterUsuario(this.usuarios, this);
        //LE PASO EL ADAPTER AL RECYCLERVIEW
        recyclerView.setAdapter(this.adapterUsuario);

        //GENERO EL LINEARLAYOUT MANAGER PARA CONTROLAR COMO SE VA A VER
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //LE PASO ESE LINEARLAYOUTMANAGER AL RECYCLERVIEW
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onRestart() {
        if (MainActivity.accion != 0) {
            if (MainActivity.accion == 1) {
                int i = EditarActivity.bundle.getInt("posicion");
                this.usuarios.get(i).setNombre(objetoEstatico.getNombre());
                this.usuarios.get(i).setPassword(objetoEstatico.getPassword());
                this.usuarios.get(i).setTipo(objetoEstatico.getTipo());
                MainActivity.accion=0;
                this.adapterUsuario.notifyItemChanged(i);
            }
        }

        super.onRestart();
    }
}