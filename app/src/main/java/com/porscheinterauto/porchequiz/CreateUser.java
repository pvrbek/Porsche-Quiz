package com.porscheinterauto.porchequiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("ValidFragment")
class CreateUser extends Fragment {
    EditText firstName;
    EditText lastName;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home2,container,false);
        firstName = v.findViewById(R.id.editText);
        lastName = v.findViewById(R.id.editText2);
        button = v.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return v;
    }
}
