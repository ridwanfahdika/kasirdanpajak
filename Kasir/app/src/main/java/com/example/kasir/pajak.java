package com.example.kasir;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class pajak extends AppCompatActivity {

    public EditText inputan1;
    public Button tombol;
    public TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pajak);

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomenutransaksi = new Intent(pajak.this, menutransaksi.class);
                startActivity(gomenutransaksi);
                finish();
            }
        });

        Button btnhome = findViewById(R.id.btnhome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomainactivity = new Intent(pajak.this, MainActivity.class);
                startActivity(gomainactivity);
                finish();
            }
        });

        inputan1 = (EditText) findViewById(R.id.input1);
        tombol = (Button) findViewById(R.id.btn1);
        hasil = (TextView) findViewById(R.id.txthasil);


        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuas();
            }
        });
    }

    private void SetUpView(){

    }

    private void hitungLuas(){
        int angka1 = Integer.parseInt(inputan1.getText().toString());
        double yaitu = angka1 * 0.005;
        hasil.setText("Pajak yang harus dibayarkan sebesar " +yaitu);
    }



}