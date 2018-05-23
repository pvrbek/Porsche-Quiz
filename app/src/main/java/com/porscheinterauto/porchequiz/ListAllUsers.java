package com.porscheinterauto.porchequiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListAllUsers extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<String> users;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.user_list,container,false);
        recyclerView = v.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        users = new ArrayList<>();
        for (int i=0;i<5;i++){
            users.add("Proba: "+i);
        }
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);
        return v;
    }
}
