package com.example.kasir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class daftarbarangAdapter extends ArrayAdapter<requestdaftarbarang> {
    public daftarbarangAdapter (Context context, int layout, ArrayList<requestdaftarbarang> daftarbarangArrayList){
        super(context, R.layout.list_daftarbarang, daftarbarangArrayList);
    }

    @Override
    public View getView (int position, View view, ViewGroup parent){
        View row = view;
        if (row==null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_daftarbarang, parent, false);
            requestdaftarbarang currentRequest=getItem(position);
            TextView namaNamabarang = (TextView) row.findViewById(R.id.text_namabarang);
            namaNamabarang.setText(currentRequest.getNamabarang());

            TextView namaHargabarang = (TextView) row.findViewById(R.id.text_hargabarang);
            namaHargabarang.setText(currentRequest.getHargabarang());
        }
        return row;
    }
}
