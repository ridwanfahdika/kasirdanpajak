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

public class inputbarang extends AppCompatActivity {

    private static final String TAG ="Kasir";
    DatabaseReference databaseReference;

    EditText namabarang, hargabarang;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputbarang);

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomenuinput = new Intent(inputbarang.this, menuinputdata.class);
                startActivity(gomenuinput);
                finish();
            }
        });

        Button btnhome = findViewById(R.id.btnhome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomainactivity = new Intent(inputbarang.this, MainActivity.class);
                startActivity(gomainactivity);
                finish();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("stok");

        namabarang = findViewById(R.id.et_namabarang);
        hargabarang = findViewById(R.id.et_hargabarang);
        submit = findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitstok();
            }

            private void submitstok() {
                final ProgressDialog progressDialog = new
                        ProgressDialog(inputbarang.this);
                progressDialog.setTitle("Uploading...");
                progressDialog.show();

                Request request = new Request(
                        namabarang.getText().toString().trim(),
                        hargabarang.getText().toString().trim());
                databaseReference.push().setValue(request);
                progressDialog.dismiss();
                Toast.makeText(inputbarang.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(inputbarang.this, inputbarang.class));
                finish();
                finish();
            }
        });
    }
}