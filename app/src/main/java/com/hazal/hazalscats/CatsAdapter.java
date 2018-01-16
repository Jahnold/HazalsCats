package com.hazal.hazalscats;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CatsAdapter extends RecyclerView.Adapter<CatsViewHolder> {

    private List<Cat> cats = new ArrayList<>();

    @Override
    public CatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_cat, parent, false);

        return new CatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CatsViewHolder holder, int position) {

        Cat cat = cats.get(position);
        holder.bind(cat);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public void setCats(List<Cat> cats) {

        if (cats == null) return;

        this.cats.clear();
        this.cats.addAll(cats);
        notifyDataSetChanged();
    }
}
