package com.example.firebaseauth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AllTextsActivity extends AppCompatActivity {
    private static List<Text> dummyTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_texts);
        initializeDummyTexts();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AllTextsAdapter(dummyTexts));
    }

    private void initializeDummyTexts() {
        dummyTexts = new ArrayList<>();
        dummyTexts.add(new Text("One", "Hello One!"));
        dummyTexts.add(new Text("Two", "Hello Two!"));
        dummyTexts.add(new Text("Three", "Hello Three!"));
        dummyTexts.add(new Text("Four", "Hello Four!"));
        dummyTexts.add(new Text("Five", "Hello Five!"));
        dummyTexts.add(new Text("Six", "Hello Six!"));
        dummyTexts.add(new Text("Seven", "Hello Seven!"));
        dummyTexts.add(new Text("Eight", "Hello Eight!"));
        dummyTexts.add(new Text("Nine", "Hello Nine!"));
        dummyTexts.add(new Text("Ten", "Hello Ten!"));
        dummyTexts.add(new Text("Eleven", "Hello Eleven!"));
        dummyTexts.add(new Text("Twelve", "Hello Twelve!"));
        dummyTexts.add(new Text("Thirteen", "Hello Thirteen!"));
    }
}
