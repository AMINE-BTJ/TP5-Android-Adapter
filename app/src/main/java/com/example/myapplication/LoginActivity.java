package com.example.myapplication;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername , etPassword ;
    Button btnLogin ;




    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v->{
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            if(TextUtils.isEmpty(username)){
                etUsername.setError("Username is required");
                etUsername.requestFocus();
                return;
            }
            if (username.equals("admin") && password.equals("1234")) {
                Intent intent = new Intent(this, spinnerActivity.class);
                startActivity(intent);
            } else {
                Log.d(LOG_TAG, "Login échoué");
                Toast.makeText(this,
                        "Wrong credentials ",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}