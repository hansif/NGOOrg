package com.example.ngoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NGOListAdapter extends RecyclerView.Adapter <NGOListAdapter.ViewHolder> {

    Context context;

    public ArrayList <String> names;
    public ArrayList <String> description;
    public ArrayList <Integer> images;

    public NGOListAdapter(Context context, ArrayList <String> names, ArrayList <String> description, ArrayList <Integer> images) {
        this.context = context;
        this.names = names;
        this.description = description;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ngo_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_name.setText(names.get(position));
        holder.text_description.setText(description.get(position));
        holder.image_icon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_name;
        TextView text_description;
        ImageView image_icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.ngo_item_label_name);
            text_description = itemView.findViewById(R.id.ngo_item_label_description);
            image_icon = itemView.findViewById(R.id.ngo_item_image_icon);
        }
    }
}