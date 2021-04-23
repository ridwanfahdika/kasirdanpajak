package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menutransaksi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menutransaksi);

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomainactivity = new Intent(menutransaksi.this, MainActivity.class);
                startActivity(gomainactivity);
                finish();
            }
        });

        Button btnkasir = findViewById(R.id.btnkasir);
        btnkasir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gokasir = new Intent(menutransaksi.this, kasir.class);
                startActivity(gokasir);
                finish();
            }
        });

        Button btndaftartransaksi = findViewById(R.id.btndaftartransaksi);
        btndaftartransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent godaftartransaksi = new Intent(menutransaksi.this, daftartransaksi.class);
                startActivity(godaftartransaksi);
                finish();
            }
        });

        Button btndaftarbarang = findViewById(R.id.btndaftarbarang);
        btndaftarbarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent godaftarbarang = new Intent(menutransaksi.this, daftarbarang.class);
                startActivity(godaftarbarang);
                finish();
            }
        });

        Button btnpengharian = findViewById(R.id.btnpengharian);
        btnpengharian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gopengharian = new Intent(menutransaksi.this, pengharian.class);
                startActivity(gopengharian);
                finish();
            }
        });

        Button btnpengbulanan = findViewById(R.id.btnpengbulanan);
        btnpengbulanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gopengbulanan = new Intent(menutransaksi.this, pengbulanan.class);
                startActivity(gopengbulanan);
                finish();
            }
        });

        Button btnpajak = findViewById(R.id.btnpajak);
        btnpajak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gopajak = new Intent(menutransaksi.this, pajak.class);
                startActivity(gopajak);
                finish();
            }
        });
    }
}