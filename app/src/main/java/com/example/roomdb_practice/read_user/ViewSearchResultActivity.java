package com.example.roomdb_practice.read_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.roomdb_practice.R;
import com.example.roomdb_practice.databinding.ActivityViewSearchResultBinding;

public class ViewSearchResultActivity extends AppCompatActivity {

    private ActivityViewSearchResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_search_result);

        setFunctionality();
        setListener();
    }

    private void setFunctionality() {
        binding.toolbar.backBtn.setVisibility(View.VISIBLE);
    }

    private void setListener() {
        binding.toolbar.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}