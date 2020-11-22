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

public class EventAdapter extends RecyclerView.Adapter <EventAdapter.ViewHolder> {

    Context context;

    public ArrayList <Event> events;

    public EventAdapter(Context context, ArrayList <Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_name.setText(events.get(position).getName());
        holder.text_description.setText(events.get(position).getDescription());
        holder.text_organizer.setText(events.get(position).getOrganizer());
        holder.text_participants.setText(String.valueOf(events.get(position).getParticipants()));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_name;
        TextView text_organizer;
        TextView text_participants;
        TextView text_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text_name = itemView.findViewById(R.id.event_item_event_name);
            text_description = itemView.findViewById(R.id.event_item_text_description);
            text_participants = itemView.findViewById(R.id.event_item_text_participants);
            text_organizer = itemView.findViewById(R.id.event_item_text_organizer);
        }
    }
}
