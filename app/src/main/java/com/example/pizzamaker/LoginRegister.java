package com.example.pizzamaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.*;
import android.widget.Toast;

import com.example.pizzamaker.UserRegistration.RegisterPage;


public class LoginRegister extends AppCompatActivity {
    EditText username;
    EditText password_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        username = findViewById(R.id.username);
        password_field = findViewById(R.id.password);
    }

    public void loginButton(View v){
        if (username.getText().toString().equals("john") && password_field.getText().toString().equals("123")){
            Toast.makeText(this, "Logged in.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginRegister.this, JsonReader.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "User not found. Please register.", Toast.LENGTH_SHORT).show();
        }

    }

    public void registerButton(View v){
        Intent intent = new Intent(LoginRegister.this, RegisterPage.class);
        startActivity(intent);
    }


}
