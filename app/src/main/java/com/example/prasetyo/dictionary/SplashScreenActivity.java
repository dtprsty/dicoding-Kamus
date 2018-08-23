package com.example.prasetyo.dictionary;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;


import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    @BindView(R.id.lv_loading)
    LinearLayout lv_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ButterKnife.bind(this);
        //membuat sebuah proses yang ter delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //mendefenisikan Intent activity
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                //finish berguna untuk mengakhiri activity
                //disini saya menggunakan finish,supaya ketika menekan tombol back
                //tidak kembali pada activity SplashScreen nya
                finish();
            }
            //disini maksud 3000 nya itu adalah lama screen ini terdelay 3 detik,dalam satuan mili second
        }, 10000);
    }

}
