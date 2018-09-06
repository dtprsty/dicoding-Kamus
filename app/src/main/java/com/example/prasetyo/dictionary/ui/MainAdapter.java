package com.example.prasetyo.dictionary.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prasetyo.dictionary.R;
import com.example.prasetyo.dictionary.model.Kamus;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private ArrayList<Kamus> mData = new ArrayList<>();
    private Context context;
    private LayoutInflater mInflater;

    public MainAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kamus_row, parent, false);
        return new MainHolder(view);
    }

    public void addItem(ArrayList<Kamus
            > mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        holder.textKata.setText(mData.get(position).getKata());
        holder.textArti.setText(mData.get(position).getArti());
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MainHolder extends RecyclerView.ViewHolder {
        private TextView textKata;
        private TextView textArti;

        public MainHolder(View itemView) {
            super(itemView);
            textKata = (TextView) itemView.findViewById(R.id.txKata);
            textArti = (TextView) itemView.findViewById(R.id.txArti);
        }
    }
}
