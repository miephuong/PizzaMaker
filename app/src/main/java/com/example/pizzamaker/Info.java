package com.example.pizzamaker;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.example.pizzamaker.SelectPizza.SelectPizza;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Info extends AppCompatActivity {

    EditText comment_field;
    private static final String FILE_NAME = "text_comment.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        comment_field = findViewById(R.id.comment_field);

        //set up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //ASUBMIT A COMMENT, INTERNAL DATA STORAGE
    public void submitComment(View v){
        String comment_text = comment_field.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(comment_text.getBytes());

            comment_field.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + " and " + FILE_NAME, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //CALL US BUTTON
    public void visitPage(View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http:/google.com"));

        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }


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
                Intent intent1 = new Intent(Info.this, MainActivity.class);
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
