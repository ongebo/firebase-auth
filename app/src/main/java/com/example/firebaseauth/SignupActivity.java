package com.example.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    public static final String SIGNUP_ERROR_MESSAGE = "You could not be registered!";
    private EditText emailInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailInput = findViewById(R.id.emailField);
        passwordInput = findViewById(R.id.passwordField);
    }

    public void handleSignup(View view) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        OnSuccessListener<AuthResult> onSuccessListener = new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(SignupActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        };
        OnFailureListener onFailureListener = new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), SIGNUP_ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
            }
        };
        auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);
    }
}
