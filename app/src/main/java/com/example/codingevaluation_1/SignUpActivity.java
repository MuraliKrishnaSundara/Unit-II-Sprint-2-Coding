package com.example.codingevaluation_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    private Button mBtnSignUp;
    private EditText mEtUserName;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                boolean isUserNameValid = isUserNameValid();
                boolean isPasswordValid = isPasswordValid();
                boolean isEmailValid = isEmailValid();
                if (isEmailValid && isPasswordValid && isUserNameValid) {
                Intent intent = new Intent(SignUpActivity.this, SigninActivity.class);
                startActivity(intent);}
            }
        });

    }

    private void initViews() {
        mEtUserName = findViewById(R.id.et3);
        mEtPassword = findViewById(R.id.et4);
        mBtnSignUp = findViewById(R.id.btnSignUp);
    }

    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Invalid email");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (mEtPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            mEtPassword.setError("Password length is less than 6 characters");
            return false;
        }
    }

    private boolean isUserNameValid() {
        if (mEtUserName.getText().toString().trim().length() >= 4) {
            return true;
        } else {
            mEtUserName.setError("Username is not valid");
            return false;
        }
    }
}