package com.example.codingevaluation_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView mTvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvUserName = findViewById(R.id.userNameTv2);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        mTvUserName.setText(userName);
    }
}