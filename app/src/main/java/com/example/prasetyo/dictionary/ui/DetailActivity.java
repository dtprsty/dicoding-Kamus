package com.example.prasetyo.dictionary.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.prasetyo.dictionary.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_KATA = "extra_kata";
    public static String EXTRA_ARTI = "extra_arti";

    @BindView(R.id.txKata)
    TextView txKata;
    @BindView(R.id.txArti)
    TextView txArti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();
    }

    private void init() {

        ButterKnife.bind(this);

        txKata.setText(getIntent().getStringExtra(EXTRA_KATA));
        txArti.setText(getIntent().getStringExtra(EXTRA_ARTI));

    }
}
