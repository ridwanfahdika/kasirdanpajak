package com.example.kasir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class daftartransaksi extends AppCompatActivity {
    private DatabaseReference dbr;
    private ListView lv;
    ArrayList<requestdaftartransaksi> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    daftartransaksiAdapter daftartransaksi_adapter = null;
    requestdaftartransaksi request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftartransaksi);

        dbr= FirebaseDatabase.getInstance().getReference("transaksi");
        lv= (ListView) findViewById(R.id.listview);
        daftartransaksi_adapter = new daftartransaksiAdapter(this,R.layout.list_daftartransaksi,arrayList);
        lv.setAdapter(arrayAdapter);
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    request =ds.getValue(requestdaftartransaksi.class);
                    arrayList.add(request);
                }
                lv.setAdapter(daftartransaksi_adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomenutransaksi = new Intent(daftartransaksi.this, menutransaksi.class);
                startActivity(gomenutransaksi);
                finish();
            }
        });

        Button btnhome = findViewById(R.id.btnhome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomainactivity = new Intent(daftartransaksi.this, MainActivity.class);
                startActivity(gomainactivity);
                finish();
            }
        });

    }
}