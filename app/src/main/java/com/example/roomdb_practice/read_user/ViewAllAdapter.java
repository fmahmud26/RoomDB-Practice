package com.example.roomdb_practice.read_user;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdb_practice.R;
import com.example.roomdb_practice.databinding.ItemUserBinding;
import com.example.roomdb_practice.model.User;

import java.util.List;

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {

    private Context context;
    private List<User> users;

    public ViewAllAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.nameTv.setText(users.get(position).getFirstName() + " " + users.get(position).getLastName());
        holder.binding.numberTv.setText(users.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemUserBinding binding;

        public ViewHolder(@NonNull ItemUserBinding itemView) {
            super(itemView.getRoot());

            binding = itemView;
        }
    }


    public void updateList(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
        Log.i("TAG", "updateList: " + users.get(users.size()-1).getFirstName());
    }
}
