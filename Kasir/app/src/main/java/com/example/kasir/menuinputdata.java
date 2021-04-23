package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuinputdata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuinputdata);

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomainactivity = new Intent(menuinputdata.this, MainActivity.class);
                startActivity(gomainactivity);
                finish();
            }
        });

        Button btninputbarang = findViewById(R.id.btninputbarang);
        btninputbarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goinputbarang = new Intent(menuinputdata.this, inputbarang.class);
                startActivity(goinputbarang);
                finish();
            }
        });

        Button btninputpengharian = findViewById(R.id.btninputpengharian);
        btninputpengharian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goinputpengharian = new Intent(menuinputdata.this, inputpenghari.class);
                startActivity(goinputpengharian);
                finish();
            }
        });

        Button btninputpengbulanan = findViewById(R.id.btninputpengbulanan);
        btninputpengbulanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goinputpengbulanan = new Intent(menuinputdata.this, inputpengbulan.class);
                startActivity(goinputpengbulanan);
                finish();
            }
        });
    }
}