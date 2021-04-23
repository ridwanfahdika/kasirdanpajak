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

public class inputpenghari extends AppCompatActivity {
    private static final String TAG ="Kasir";
    DatabaseReference databaseReference;

    EditText hari, tanggal, pengharian;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputpenghari);

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomenuinput = new Intent(inputpenghari.this, menuinputdata.class);
                startActivity(gomenuinput);
                finish();
            }
        });

        Button btnhome = findViewById(R.id.btnhome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomainactivity = new Intent(inputpenghari.this, MainActivity.class);
                startActivity(gomainactivity);
                finish();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("penghasilanharian");

        hari = findViewById(R.id.ethari);
        tanggal = findViewById(R.id.ettanggal);
        pengharian = findViewById(R.id.etpengharian);
        simpan = findViewById(R.id.btnsimpanhari);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanharian();
            }

            private void simpanharian() {
                final ProgressDialog progressDialog = new
                        ProgressDialog(inputpenghari.this);
                progressDialog.setTitle("Uploading...");
                progressDialog.show();

                requestinputharian request = new requestinputharian(
                        hari.getText().toString().trim(),
                        tanggal.getText().toString().trim(),
                        pengharian.getText().toString().trim());
                databaseReference.push().setValue(request);
                progressDialog.dismiss();
                Toast.makeText(inputpenghari.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(inputpenghari.this, inputpenghari.class));
                finish();
                finish();
            }
        });
    }

}