package com.cisternas.pplabv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterUsuario extends RecyclerView.Adapter<ViewHolderUsuario>{
    List<Usuario> usuariosAdapter;
    MainActivity activity;

    public AdapterUsuario(List<Usuario> usuariosMain, MainActivity ac) {
        this.usuariosAdapter = usuariosMain;
        this.activity=ac;
    }

    @NonNull
    @Override
    public ViewHolderUsuario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new ViewHolderUsuario(v, this.activity);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUsuario holder, int position) {
        Usuario u = this.usuariosAdapter.get(position);
        holder.tvNombre.setText(u.getNombre());
        if(u.getTipo() == ETipo.Administrador)
        {
            holder.tvTipo.setText(R.string.text_tipoAd);
        }
        else if(u.getTipo() == ETipo.Usuario)
        {
            holder.tvTipo.setText(R.string.text_tipoUs);
        }
    }

    @Override
    public int getItemCount() {
        return usuariosAdapter.size();
    }
}
