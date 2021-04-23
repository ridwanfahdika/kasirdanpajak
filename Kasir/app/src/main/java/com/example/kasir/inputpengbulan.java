package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class inputpengbulan extends AppCompatActivity {
    private static final String TAG ="Kasir";
    DatabaseReference databaseReference;

    EditText bulan, tahun, pengbulanan;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputpengbulan);

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomenuinput = new Intent(inputpengbulan.this, menuinputdata.class);
                startActivity(gomenuinput);
                finish();
            }
        });

        Button btnhome = findViewById(R.id.btnhome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomainactivity = new Intent(inputpengbulan.this, MainActivity.class);
                startActivity(gomainactivity);
                finish();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("penghasilanbulanan");

        bulan = findViewById(R.id.etbulan);
        tahun = findViewById(R.id.ettahun);
        pengbulanan = findViewById(R.id.etpengbulanan);
        simpan = findViewById(R.id.btnsimpanbulan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanbulanan();
            }

            private void simpanbulanan() {
                final ProgressDialog progressDialog = new
                        ProgressDialog(inputpengbulan.this);
                progressDialog.setTitle("Uploading...");
                progressDialog.show();

                requestinputbulanan request = new requestinputbulanan(
                        bulan.getText().toString().trim(),
                        tahun.getText().toString().trim(),
                        pengbulanan.getText().toString().trim());
                databaseReference.push().setValue(request);
                progressDialog.dismiss();
                Toast.makeText(inputpengbulan.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(inputpengbulan.this, inputpengbulan.class));
                finish();
                finish();
            }
        });
    }

}