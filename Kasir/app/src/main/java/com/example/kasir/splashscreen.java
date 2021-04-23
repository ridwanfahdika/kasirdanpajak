package com.example.kasir;

        import android.content.Intent;
        import android.os.Handler;
        import android.os.Bundle;

        import androidx.appcompat.app.AppCompatActivity;

        public class splashscreen extends AppCompatActivity {
    private int waktu_loading=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent home=new Intent(splashscreen.this, MainActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}