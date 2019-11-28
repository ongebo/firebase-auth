package com.example.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onSubmitButtonClick(View view) {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
    }
}
