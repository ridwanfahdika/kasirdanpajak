package com.example.kasir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class penghasilanharianAdapter extends ArrayAdapter<requestdaftarharian> {
    public penghasilanharianAdapter (Context context, int layout, ArrayList<requestdaftarharian> daftarharianArrayList){
        super(context, R.layout.list_penghasilanharian, daftarharianArrayList);
    }

    @Override
    public View getView (int position, View view, ViewGroup parent){
        View row = view;
        if (row==null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_penghasilanharian, parent, false);
            requestdaftarharian currentRequest=getItem(position);
            TextView hari = (TextView) row.findViewById(R.id.text_hari);
            hari.setText(currentRequest.gethari());

            TextView tanggal = (TextView) row.findViewById(R.id.text_tanggal);
            tanggal.setText(currentRequest.gettanggal());

            TextView pengharian = (TextView) row.findViewById(R.id.text_pengharian);
            pengharian.setText(currentRequest.getpengharian());
        }
        return row;
    }
}
