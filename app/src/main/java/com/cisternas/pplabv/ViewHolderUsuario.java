package com.cisternas.pplabv;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderUsuario extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView tvNombre;
    TextView tvTipo;
    ImageButton btnImage;
    MainActivity activity;

    public ViewHolderUsuario(@NonNull View itemView, MainActivity ac) {
        super(itemView);
        this.tvTipo = this.itemView.findViewById(R.id.tvTipo);
        this.tvNombre = this.itemView.findViewById(R.id.tvNombre);
        this.btnImage = this.itemView.findViewById(R.id.ibFoto);

        //CLICK EN ELEMENTO DE LA VISTA
        //itemView.setOnClickListener(this);
        //CLICK EN EL BOTON EL ELEMENTO
        this.btnImage.setOnClickListener(this);
        this.activity = ac;
    }

    @Override
    public void onClick(View view) {
        //DEL VIEWHOLDER VOY A PASAR A MI OTRA ACTIVITY CON LA INFO DEL OBJETO TOCADO
        Intent i = new Intent(view.getContext(), EditarActivity.class);

        if (super.getAdapterPosition() != RecyclerView.NO_POSITION) {

            //LE PASO EL OBJETO
            i.putExtra("objeto", activity.usuarios.get(super.getAdapterPosition()));
            i.putExtra("posicion", super.getAdapterPosition());

            view.getContext().startActivity(i);
        }
    }
}
