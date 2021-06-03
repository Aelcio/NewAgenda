package com.example.newagenda;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdpter extends ArrayAdapter {
    private Context context;
    private ArrayList<Contato> lista;

    public MyAdpter(Context context, int resource, ArrayList<Contato> list) {
        super(context, resource, (List) list);
        this.context = context;
        this.lista = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View  view = inflater.inflate(R.layout.contato, null);

        TextView tvNome      = (TextView)view.findViewById(R.id.tvNome);
        TextView tvEndereco  = (TextView)view.findViewById(R.id.tvEndereco);
        TextView tvTelefone1 = (TextView)view.findViewById(R.id.tvTelefone1);
        TextView tvTelefone2 = (TextView)view.findViewById(R.id.tvTelefone2);

        Contato c1 = lista.get(position);

        tvNome.setText(c1.getNome());
        tvEndereco.setText(c1.getEndereco());
        tvTelefone1.setText(c1.getTelefone1());
        tvTelefone2.setText(c1.getTelefone2());
        return view;
    }
}
