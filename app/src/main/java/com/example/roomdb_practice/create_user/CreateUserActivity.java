package com.example.roomdb_practice.create_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomdb_practice.R;
import com.example.roomdb_practice.databinding.ActivityCreateUserBinding;
import com.example.roomdb_practice.room_db.AppDatabase;
import com.example.roomdb_practice.model.User;

import java.lang.ref.WeakReference;

public class CreateUserActivity extends AppCompatActivity {

    private ActivityCreateUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_user);

        setFunctionality();
        setListener();
    }

    private void setFunctionality() {
        binding.toolbar.backBtn.setVisibility(View.VISIBLE);
        binding.toolbar.title.setText("Create User");
    }

    private void setListener() {
        binding.toolbar.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
            }
        });
    }

    private void saveUser() {

        String firstName = binding.firstNameEt.getText().toString().trim();
        String lastName = binding.lastNameEt.getText().toString().trim();
        String address = binding.addressEt.getText().toString().trim();
        String age = binding.ageEt.getText().toString().trim();
        String number = binding.numberEt.getText().toString().trim();

        User user = new User(firstName, lastName, address, Integer.valueOf(age), number);

        new SaveUserToDBAsyncTask(CreateUserActivity.this, user).execute();
    }

    class SaveUserToDBAsyncTask extends AsyncTask<Void, Void, Boolean> {

        WeakReference<CreateUserActivity> weakActivity;
        User user;

        public SaveUserToDBAsyncTask(CreateUserActivity context, User user) {
            weakActivity = new WeakReference<>(context);
            this.user = user;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            // insert user to room database
            AppDatabase db = AppDatabase.getAppDatabase(weakActivity.get());
            db.getUserDao().insertUser(user);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean isOK) {
            if (isOK) {
                Toast.makeText(weakActivity.get(), "Saved", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(weakActivity.get(), "Not saved", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
