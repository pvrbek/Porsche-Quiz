package com.porscheinterauto.porchequiz;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<UserEntity> users;

    public UserAdapter(List<UserEntity> users) {
        this.users = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.firstName.setText("First Name: " + users.get(holder.getAdapterPosition()).getFirstName());
        holder.lastName.setText("Last Name: " + users.get(holder.getAdapterPosition()).getLastName());
        holder.idUser.setText("ID: " + String.valueOf(users.get(holder.getAdapterPosition()).getId()));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstName;
        public TextView lastName;
        public TextView idUser;

        public ViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);
            idUser = itemView.findViewById(R.id.id_user);
        }
    }
}
