package com.hazal.hazalscats;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

class CatsViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView name;

    CatsViewHolder(View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.cat_image);
        name = itemView.findViewById(R.id.cat_name);
    }

    void bind(Cat cat) {

        Picasso.with(image.getContext())
                .load(cat.getUrl())
                .into(image);

        name.setText(cat.getName());
    }
}
