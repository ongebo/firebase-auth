package com.example.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomescreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
    }

    public void onAddTextButtonClick(View view) {
        Intent intent = new Intent(this, AddTextActivity.class);
        startActivity(intent);
    }

    public void onViewAllTextsButtonClick(View view) {
        Intent intent = new Intent(this, AllTextsActivity.class);
        startActivity(intent);
    }
}
