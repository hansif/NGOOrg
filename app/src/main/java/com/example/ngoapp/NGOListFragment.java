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

public class NGOListFragment extends Fragment {

    RecyclerView recycle;

    Context context;

    EditText search;

    NGOListAdapter ngoListAdapter;

    ArrayList <String> names;
    ArrayList <String> description;
    ArrayList <Integer> images;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ngo_list, container, false);

        recycle = view.findViewById(R.id.list_recycle);

        search = view.findViewById(R.id.ngo_list_search);

        context = getContext();

        String[] arr_names = {"SANGHAMITRA","SMILE","NRDC","CARE","HELP","NOVA"};
        String[] arr_desc = {"This is Description","This is Description","This is Description","This is Description","This is Description","This is Description"};

        int[] arr_images = {R.drawable.sanghamitra,R.drawable.smile,R.drawable.nrdc,R.drawable.care,R.drawable.help,R.drawable.nova};

        names = new ArrayList<>();
        description = new ArrayList<>();
        images = new ArrayList<>();

        for (int i = 0; i < arr_names.length; i++) {
            names.add(arr_names[i]);
            description.add(arr_desc[i]);
            images.add(arr_images[i]);
        }

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList <String> filter_names = new ArrayList<>();
                ArrayList <String> filter_desc = new ArrayList<>();
                ArrayList <Integer> filter_images = new ArrayList<>();

                for (int i = 0; i < names.size(); i++)
                    if (names.get(i).toLowerCase().contains(search.getText().toString().toLowerCase())) {
                        filter_names.add(names.get(i));
                        filter_desc.add(description.get(i));
                        filter_images.add(images.get(i));
                    }

                recycle.setLayoutManager(new LinearLayoutManager(context));
                ngoListAdapter = new NGOListAdapter(context, filter_names, filter_desc, filter_images);
                recycle.setAdapter(ngoListAdapter);
            }
        });

        recycle.setLayoutManager(new LinearLayoutManager(context));
        ngoListAdapter = new NGOListAdapter(context, names, description, images);
        recycle.setAdapter(ngoListAdapter);

        return view;
    }
}
