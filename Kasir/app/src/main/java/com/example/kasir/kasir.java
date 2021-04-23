package com.example.kasir;

        import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

public class kasir extends AppCompatActivity {

    EditText etNamaBarang, etHargaBarang, etTotalHarga, etJmlUang;
    TextView tvNamaBarang, tvHargaBarang, tvTotalHarga, tvUangBayar,
            tvTotal, tvKembalian, tvKeterangan;
    Button btnProses, btnHapus, btnSimpan;
    private static final String TAG ="Kasir";
    DatabaseReference databaseReference;

    String namaBarang, hargaBarang, totalHarga, uangBayar;
    double hrgBarang, uangByr, total, kembalian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasir);

        databaseReference = FirebaseDatabase.getInstance().getReference("transaksi");

        etNamaBarang = findViewById(R.id.etNamaBarang);
        etHargaBarang = findViewById(R.id.etHargaBarang);
        etTotalHarga = findViewById(R.id.etTotalHarga);
        btnSimpan = findViewById(R.id.btnSimpan);
 
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submittransaksi();
            }

            private void submittransaksi() {
                final ProgressDialog progressDialog = new
                        ProgressDialog(kasir.this);
                progressDialog.setTitle("Uploading...");
                progressDialog.show();

                requestinputtransaksi request = new requestinputtransaksi(
                        etNamaBarang.getText().toString().trim(),
                        etHargaBarang.getText().toString().trim(),
                        etTotalHarga.getText().toString().trim());
                databaseReference.push().setValue(request);
                progressDialog.dismiss();
                Toast.makeText(kasir.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(kasir.this, kasir.class));
                finish();
                finish();
            }
        });

        //EditText
        etNamaBarang = findViewById(R.id.etNamaBarang);
        etHargaBarang = findViewById(R.id.etHargaBarang);
        etTotalHarga = findViewById(R.id.etTotalHarga);
        etJmlUang = findViewById(R.id.etJmlUang);

        //TextView
        tvNamaBarang = findViewById(R.id.tvNamaBarang);
        tvHargaBarang = findViewById(R.id.tvHargaBarang);
        tvTotalHarga = findViewById(R.id.tvTotalHarga);
        tvUangBayar = findViewById(R.id.tvUangBayar);
        tvTotal = findViewById(R.id.tvTotal);
        tvKembalian = findViewById(R.id.tvKembalian);
        tvKeterangan = findViewById(R.id.tvKeterangan);

        //Button
        btnProses = findViewById(R.id.btnProses);
        btnHapus = findViewById(R.id.btnHapus);
        btnSimpan = findViewById(R.id.btnSimpan);

        //Proses
        btnProses.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                namaBarang = etNamaBarang.getText().toString().trim();
                hargaBarang = etHargaBarang.getText().toString().trim();
                totalHarga = etTotalHarga.getText().toString().trim();
                uangBayar = etJmlUang.getText().toString().trim();

                hrgBarang = Double.parseDouble(totalHarga);
                uangByr = Double.parseDouble(uangBayar);
                total = (hrgBarang);

                tvNamaBarang.setText("Nama Barang : " + namaBarang);
                tvHargaBarang.setText("Harga Barang : " + hargaBarang);
                tvTotalHarga.setText("Total Harga : " + totalHarga);
                tvUangBayar.setText("Uang bayar : " + uangBayar);

                kembalian = (uangByr - total);
                if (uangByr < total) {
                    tvKeterangan.setText("Keterangan : Uang bayar kurang Rp. " + (-kembalian));
                    tvKembalian.setText("Uang Kembalian : Rp. 0");
                } else {
                    tvKeterangan.setText("Keterangan : Silahkan tunggu kembaliannya :)");
                    tvKembalian.setText("Uang Kembalian : Rp. " + kembalian);
                }

            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNamaBarang.setText("");
                tvHargaBarang.setText("");
                tvTotalHarga.setText("");
                tvUangBayar.setText("");
                tvKembalian.setText("");
                tvKeterangan.setText("");
                tvTotal.setText("");

                Toast.makeText(getApplicationContext(), "Data sudah dihapus", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomenutransaksi = new Intent(kasir.this, menutransaksi.class);
                startActivity(gomenutransaksi);
                finish();
            }
        });

        Button btnhome = findViewById(R.id.btnhome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomainactivity = new Intent(kasir.this, MainActivity.class);
                startActivity(gomainactivity);
                finish();
            }
        });

    }
}