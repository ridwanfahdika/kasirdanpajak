package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnexit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnexit = findViewById(R.id.btnexit);

        Button btntransaksi = findViewById(R.id.btntransaksi);
        btntransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomenutransaksi = new Intent(MainActivity.this, menutransaksi.class);
                startActivity(gomenutransaksi);
                finish();
            }
        });

        Button btninput = findViewById(R.id.btninput);
        btninput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomenuinput = new Intent(MainActivity.this, menuinputdata.class);
                startActivity(gomenuinput);
                finish();
            }
        });

        Button btnabout = findViewById(R.id.btnabout);
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goabout = new Intent(MainActivity.this, about.class);
                startActivity(goabout);
                finish();
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });
    }
}