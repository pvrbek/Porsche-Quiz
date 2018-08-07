package com.porscheinterauto.porchequiz;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
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
    Button button2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.home2, container, false);
        firstName = v.findViewById(R.id.editText);
        lastName = v.findViewById(R.id.editText2);
        button = v.findViewById(R.id.button1);
        button2 = v.findViewById(R.id.button2);

        final AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "production")//TODO: OVO NIJE DOBRA PRAKSA DA SE PONOVO PRISTUPA TU
                .allowMainThreadQueries() //TODO: NAPRAVITI OVO DA SE NE VRTI NA GLAVNOJ DRETVI
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.userDao().insertAll(new UserEntity(firstName.getText().toString(), lastName.getText().toString()));
                ListAllUsers listFragment = new ListAllUsers();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home2, listFragment, "newListFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //db.userDao().deleteUsers(new UserEntity(firstName.getText().toString(), lastName.getText().toString()));
                db.userDao().deleteUser(firstName.getText().toString(),lastName.getText().toString());
                ListAllUsers listFragment = new ListAllUsers();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home2, listFragment, "newListFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return v;
    }
}
