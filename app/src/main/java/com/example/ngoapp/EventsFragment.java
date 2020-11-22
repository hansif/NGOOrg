package com.example.ngoapp;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    RecyclerView recycle;

    EventAdapter eventAdapter;

    EditText search;

    Event temp;

    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        recycle = view.findViewById(R.id.events_recycle);

        final ArrayList <Event> events = new ArrayList<>();

        search = view.findViewById(R.id.events_search);

        context = getContext();

        temp = new Event("ABC Event", "Sanghamitra", "This is an event for collecting donations", 25);
        events.add(temp);
        temp = new Event("DEF Event", "NRDC", "This is an event for collecting donations", 50);
        events.add(temp);
        temp = new Event("GHI Event", "Nova", "This is an event for collecting donations", 35);
        events.add(temp);
        temp = new Event("JKL Event", "Smile", "This is an event for collecting donations", 215);
        events.add(temp);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList <Event> filter_events = new ArrayList<>();

                for (int i = 0; i < events.size(); i++)
                    if (events.get(i).getName().toLowerCase().contains(search.getText().toString().toLowerCase()))
                        filter_events.add(events.get(i));

                recycle.setLayoutManager(new LinearLayoutManager(context));
                eventAdapter = new EventAdapter(context, filter_events);
                recycle.setAdapter(eventAdapter);
            }
        });

        recycle.setLayoutManager(new LinearLayoutManager(context));
        eventAdapter = new EventAdapter(context, events);
        recycle.setAdapter(eventAdapter);

        return view;
    }
}
