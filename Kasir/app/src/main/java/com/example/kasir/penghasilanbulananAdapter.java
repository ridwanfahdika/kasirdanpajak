package com.example.kasir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class penghasilanbulananAdapter extends ArrayAdapter<requestdaftarbulanan> {
    public penghasilanbulananAdapter (Context context, int layout, ArrayList<requestdaftarbulanan> daftarbulananArrayList){
        super(context, R.layout.list_penghasilanbulanan, daftarbulananArrayList);
    }

    @Override
    public View getView (int position, View view, ViewGroup parent){
        View row = view;
        if (row==null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_penghasilanbulanan, parent, false);
            requestdaftarbulanan currentRequest=getItem(position);
            TextView bulan = (TextView) row.findViewById(R.id.text_bulan);
            bulan.setText(currentRequest.getbulan());

            TextView tahun = (TextView) row.findViewById(R.id.text_tahun);
            tahun.setText(currentRequest.gettahun());

            TextView pengbulanan = (TextView) row.findViewById(R.id.text_pengbulanan);
            pengbulanan.setText(currentRequest.getpengbulanan());
        }
        return row;
    }
}
