package com.example.roomdb_practice.read_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomdb_practice.R;
import com.example.roomdb_practice.databinding.ActivityViewAllBinding;
import com.example.roomdb_practice.model.User;
import com.example.roomdb_practice.room_db.AppDatabase;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private ActivityViewAllBinding binding;
    private List<User> users = new ArrayList<>();
    private ViewAllAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_all);

        setFunctionality();
        setListener();
        new ReadDataAsyncTask(this).execute();
    }

    private void setFunctionality() {
        toolbarSetUp();
        userListSetUp();
    }

    private void userListSetUp() {
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        usersAdapter = new ViewAllAdapter(this, users);
        binding.recycler.setAdapter(usersAdapter);
    }

    private void setListener() {
        binding.toolbar.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toolbarSetUp() {
        binding.toolbar.backBtn.setVisibility(View.VISIBLE);
        binding.toolbar.title.setText("View All");
    }


    class ReadDataAsyncTask extends AsyncTask<Void, Void, Boolean> {  // read from room database

        WeakReference<ViewAllActivity> weakActivity;

        public ReadDataAsyncTask(ViewAllActivity weakActivity) {
            this.weakActivity = new WeakReference<>(weakActivity);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {

            users.clear();

            AppDatabase db = AppDatabase.getAppDatabase(weakActivity.get());
            users = db.getUserDao().getUsers();

            return true;
        }

        @Override
        protected void onPostExecute(Boolean isOK) {
            if (isOK) {
                Toast.makeText(weakActivity.get(), "Read success", Toast.LENGTH_SHORT).show();
                usersAdapter.updateList(users);
            } else {
                Toast.makeText(weakActivity.get(), "No able to read", Toast.LENGTH_SHORT).show();
            }
        }
    }
}