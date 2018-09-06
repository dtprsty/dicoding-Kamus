package com.example.prasetyo.dictionary.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.prasetyo.dictionary.R;
import com.example.prasetyo.dictionary.database.KamusHelper;
import com.example.prasetyo.dictionary.model.Kamus;
import com.example.prasetyo.dictionary.util.RecyclerItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listKata)
    RecyclerView recyclerView;

    @BindView(R.id.txKeyword)
    EditText txKeyword;

    private MainAdapter adapter;
    private KamusHelper helper;
    private LinearLayoutManager layoutManager;

    private ArrayList<Kamus> mkamus = new ArrayList<Kamus>();

    private boolean isEnglish = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ButterKnife.bind(this);
        helper = new KamusHelper(this);// untuk mengisi data dari JSON ke dalam adapter
        adapter = new MainAdapter(this);
        initRecyclerView();
        txKeyword.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                // you can call or do what you want with your EditText here

                // yourEditText...
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mkamus.clear();
                if (isEnglish) {
                    mkamus = helper.getDataByInggris(s.toString());
                } else {
                    mkamus = helper.getDataByIndonesia(s.toString());
                }
                adapter.addItem(mkamus);
                adapter.notifyDataSetChanged();
            }
        });

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        Kamus k = mkamus.get(position);

                        Intent i = new Intent(MainActivity.this, DetailActivity.class);
                        i.putExtra(DetailActivity.EXTRA_KATA, k.getKata());
                        i.putExtra(DetailActivity.EXTRA_ARTI, k.getArti());
                        startActivity(i);
                    }
                })
        );
    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(adapter);

        helper.open();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.eng_indo:
                isEnglish = true;
                break;

            case R.id.indo_eng:
                isEnglish = false;
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
