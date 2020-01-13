package com.example.firebaseauth;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllTextsActivity extends AppCompatActivity {
    public static final String ERROR_MESSAGE = "Could not fetch texts!";
    private static List<Text> texts;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_texts);
        texts = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        fetchAndDisplayTexts();
    }

    private void fetchAndDisplayTexts() {
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        OnCompleteListener<QuerySnapshot> onCompleteListener = getOnCompleteListener();
        firestore.collection("texts")
                .get()
                .addOnCompleteListener(onCompleteListener);
    }

    private OnCompleteListener<QuerySnapshot> getOnCompleteListener() {
        return new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        Map<String, Object> map = documentSnapshot.getData();
                        String title = (String) map.get("title");
                        String description = (String) map.get("description");
                        texts.add(new Text(title, description));
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(AllTextsActivity.this));
                    recyclerView.setAdapter(new AllTextsAdapter(texts));
                } else {
                    Toast.makeText(getApplicationContext(), ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}
