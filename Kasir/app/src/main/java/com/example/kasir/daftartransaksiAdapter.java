package com.example.kasir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class daftartransaksiAdapter extends ArrayAdapter<requestdaftartransaksi> {
    public daftartransaksiAdapter (Context context, int layout, ArrayList<requestdaftartransaksi> daftartransaksiArrayList){
        super(context, R.layout.list_daftartransaksi, daftartransaksiArrayList);
    }

    @Override
    public View getView (int position, View view, ViewGroup parent){
        View row = view;
        if (row==null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_daftartransaksi, parent, false);
            requestdaftartransaksi currentRequest=getItem(position);
            TextView namatrnamabarang = (TextView) row.findViewById(R.id.text_trnamabarang);
            namatrnamabarang.setText(currentRequest.gettrnamabarang());

            TextView namatrhargabarang = (TextView) row.findViewById(R.id.text_trhargabarang);
            namatrhargabarang.setText(currentRequest.gettrhargabarang());

            TextView namatrtotalharga = (TextView) row.findViewById(R.id.text_trtotalharga);
            namatrtotalharga.setText(currentRequest.gettrtotalharga());
        }
        return row;
    }
}
