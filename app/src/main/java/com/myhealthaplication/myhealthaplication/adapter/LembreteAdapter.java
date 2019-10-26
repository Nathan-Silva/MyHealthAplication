package com.myhealthaplication.myhealthaplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myhealthaplication.myhealthaplication.R;
import com.myhealthaplication.myhealthaplication.entidades.Lembretes;

import java.util.ArrayList;

public class LembreteAdapter extends BaseAdapter {

    Context context;
    ArrayList<Lembretes> lembretes;
    LayoutInflater inflater;

    public LembreteAdapter(Context context, ArrayList<Lembretes> lembretes) {
        this.context = context;
        this.lembretes = lembretes;
    }

    @Override
    public int getCount() {
        return this.lembretes.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lembretes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.lembretes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.lembrete_item, parent, false);

        TextView titulo = convertView.findViewById(R.id.txtTituloLista);
        TextView conteudo = convertView.findViewById(R.id.txtConteudoLista);
        TextView data = convertView.findViewById(R.id.txtData);
        TextView hora = convertView.findViewById(R.id.txtHora);

        Lembretes lembrete = this.lembretes.get(position);
        titulo.setText(lembrete.getTitulo());
        conteudo.setText(lembrete.getConteudo());
        data.setText(lembrete.getData());
        hora.setText(lembrete.getHora());

        return convertView;
    }

}