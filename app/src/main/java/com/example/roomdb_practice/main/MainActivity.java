package com.example.roomdb_practice.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdb_practice.R;
import com.example.roomdb_practice.create_user.CreateUserActivity;
import com.example.roomdb_practice.databinding.ActivityMainBinding;
import com.example.roomdb_practice.delete_user.DeleteUserActivity;
import com.example.roomdb_practice.read_user.ViewAllActivity;
import com.example.roomdb_practice.room_db.AppDatabase;
import com.example.roomdb_practice.search_user.SearchActivity;
import com.example.roomdb_practice.update_user.UpdateUserActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        AppDatabase.getAppDatabase(MainActivity.this).getUserDao();


        setListener();
    }

    private void setListener() {

        binding.createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateUserActivity.class));
            }
        });

        binding.readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewAllActivity.class));
            }
        });

        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UpdateUserActivity.class));
            }
        });

        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DeleteUserActivity.class));
            }
        });

        binding.searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });
    }
}
