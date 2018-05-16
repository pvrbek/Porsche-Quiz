package com.porscheinterauto.porchequiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListAllUsers extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.user_list,container,false);
        recyclerView = v.findViewById(R.id.recycler_view);
        return v;
    }
}
