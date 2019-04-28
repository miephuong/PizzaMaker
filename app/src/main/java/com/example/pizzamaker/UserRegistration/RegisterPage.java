package com.example.pizzamaker.UserRegistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import com.example.pizzamaker.R;

public class RegisterPage extends AppCompatActivity {
    EditText name_field, email_field, phone_field, city_field;
    UserDatabase myDb;
    Button registerbtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        myDb = new UserDatabase(this);

        name_field = findViewById(R.id.add_name_field);
        email_field = findViewById(R.id.add_email_field);
        phone_field = findViewById(R.id.add_phone_field);
        city_field = findViewById(R.id.add_city_field);

        registerbtn = findViewById(R.id.add_profile_button);
    }

    public void registerUser(View v){
                boolean isInserted = myDb.insertData(name_field.getText().toString(),
                                email_field.getText().toString(),
                                phone_field.getText().toString(),
                                city_field.getText().toString());
                if(isInserted = true){
                    Toast.makeText(RegisterPage.this, "User registered", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterPage.this, "User not registered", Toast.LENGTH_SHORT).show();
                }
    }


}
