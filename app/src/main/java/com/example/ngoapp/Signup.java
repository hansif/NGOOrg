package com.example.ngoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText name;
    EditText username;
    EditText password;
    EditText email;
    EditText phone;

    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.signup_text_name);
        username = findViewById(R.id.signup_text_username);
        password = findViewById(R.id.signup_text_password);
        email = findViewById(R.id.signup_text_email);
        phone = findViewById(R.id.signup_text_phone);

        signup = findViewById(R.id.signup_button_signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Signup.this, "Your account was created successfuly\nLogin with same account", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(Signup.this, Login.class));
            }
        });
    }
}