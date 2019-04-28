package com.example.pizzamaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class JsonReader extends AppCompatActivity {
    ArrayList<String> numberlist = new ArrayList<>();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_reader);

        //set up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button = findViewById(R.id.button_see_profile);


    }

    public void loadJson(View view){
        InputStream is = getResources().openRawResource(R.raw.test);

        Scanner scanner = new Scanner(is);

        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()){
            builder.append(scanner.nextLine());
        }
        parseJson(builder.toString());
        button = findViewById(R.id.button_see_profile);
        button.setText("Profile");
    }

    private void parseJson(String s){

        TextView textView = findViewById(R.id.textview_see_profile);

        StringBuilder builder = new StringBuilder();

        try {
            JSONObject root = new JSONObject(s);
            JSONObject object = root.getJSONObject("users");

            builder.append("Name: ").append(object.getString("firstname")).append("\n");
            builder.append("Email: ").append(object.getString("mail")).append("\n");
            builder.append("Age: ").append(object.getInt("age")).append("\n");

            JSONArray address = object.getJSONArray("address");
            for(int i = 0; i < address.length(); i++){
                JSONObject add = address.getJSONObject(i);
                builder.append(add.getString("street")).append(", ")
                        .append(add.getString("city")).append("\n");
            }

            //Toast.makeText(this, "Parsed successfully", Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Cannot get profile.", Toast.LENGTH_SHORT).show();
        }

        String built = builder.toString();
        textView.setText(built);

    }

    //ACTION BAR
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Intent intent1 = new Intent(JsonReader.this, MainActivity.class);
                startActivity(intent1);
                return true;
            case R.id.navigation_setting:
                Toast.makeText(this, "You just clicked Settings.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_account:
                Toast.makeText(this, "You just clicked Account.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sub1:
                Toast.makeText(this, "You just clicked See Account.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sub2:
                Toast.makeText(this, "You just clicked Edit Account.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
