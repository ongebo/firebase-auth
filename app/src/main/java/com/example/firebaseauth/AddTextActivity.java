package com.example.firebaseauth;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddTextActivity extends AppCompatActivity {

    public static final String ERROR_MESSAGE = "Failed to save text!";
    private EditText textTitle;
    private EditText textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_text);
        textTitle = findViewById(R.id.textTitle);
        textDescription = findViewById(R.id.textDescription);
    }

    public void handleSaveClick(View view) {
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        Map<String, String> map = prepareTextMap();
        OnSuccessListener<DocumentReference> onSuccessListener = new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                onBackPressed();
            }
        };
        OnFailureListener onFailureListener = new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
            }
        };
        firestore.collection("texts")
                .add(map)
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);
    }

    private Map<String, String> prepareTextMap() {
        Map<String, String> entry = new HashMap<>();
        String title = textTitle.getText().toString();
        String description = textDescription.getText().toString();
        entry.put("title", title);
        entry.put("description", description);
        return entry;
    }
}
