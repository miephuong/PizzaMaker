package com.example.pizzamaker;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pizzamaker.SelectIngredients.SelectIngredients;
import com.example.pizzamaker.SelectPizza.SelectPizza;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    ImageButton selectPizza;
    ImageButton selectIngredients;
    ImageButton loginRegister;
    ImageButton contactUs;
    Button download_logo;
    String hotline = "01189998819991197253";
    private FirebaseAnalytics mfbAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up firebase analytics
        mfbAnalytics = FirebaseAnalytics.getInstance(this);


        //set up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel://" + hotline)));
            }
        });


        // WHEN OPTION 1 IS CLICKED
        selectPizza = findViewById(R.id.select_pizza_option);
        selectPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, SelectPizza.class);
                //intent1.putExtra("option 1", "Main");
                startActivity(intent1);
            }
        });


        // WHEN OPTION 2 IS CLICKED
        selectIngredients = findViewById(R.id.select_ingredient_option);
        selectIngredients.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, SelectIngredients.class);
                //intent2.putExtra("option 2", "Main");
                startActivity(intent2);
            }
        });


        // WHEN OPTION 3 IS CLICKED
        loginRegister = findViewById(R.id.login_option);
        loginRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, LoginRegister.class);
                startActivity(intent3);
            }
        });

        // WHEN OPTION 4 IS CLICKED
        contactUs = findViewById(R.id.about_option);
        contactUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, Info.class);
                startActivity(intent4);
            }
        });

        // WHEN download logo button is clickeed
        download_logo = findViewById(R.id.download_logo);
        download_logo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, DownloadLogo.class);
                startActivity(intent4);
            }
        });


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
                Toast.makeText(this, "You just clicked Home.", Toast.LENGTH_SHORT).show();
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


