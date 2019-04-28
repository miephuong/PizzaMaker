package com.example.pizzamaker.SelectIngredients;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.pizzamaker.Info;
import com.example.pizzamaker.MainActivity;
import com.example.pizzamaker.R;

import java.util.ArrayList;

public class SelectIngredients extends AppCompatActivity implements RecyclerViewAdapter.OnListItemClickListener{
    RecyclerView sauceList;
    RecyclerView toppingList;
    RecyclerView.Adapter mIngredientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ingredients);

        //set up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // LIST FOR SAUCE
        sauceList = findViewById(R.id.sauce_recyclerView);
        sauceList.hasFixedSize();
        sauceList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Ingredients> sauce = new ArrayList<>();
        sauce.add(new Ingredients("Tomato sauce", R.drawable.sauce_tomato_icon));
        sauce.add(new Ingredients("Cheese sauce", R.drawable.sauce_cheese_icon));
        sauce.add(new Ingredients("Bolognese sauce", R.drawable.sauce_bolognese_icon));
        sauce.add(new Ingredients("Bearnaise sauce", R.drawable.sauce_bearnaise_icon));
        sauce.add(new Ingredients("Hot sauce", R.drawable.sauce_chili_icon));
        sauce.add(new Ingredients("Pesto sauce", R.drawable.sauce_pesto_icon));
        sauce.add(new Ingredients("Soy sauce", R.drawable.sauce_soy_icon));

        mIngredientAdapter = new RecyclerViewAdapter(sauce, this);
        sauceList.setAdapter(mIngredientAdapter);


        //LIST FOR TOPPINGS
        toppingList = findViewById(R.id.topping_recyclerView);
        toppingList.hasFixedSize();
        toppingList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Ingredients> toppings = new ArrayList<>();
        toppings.add(new Ingredients("Ham", R.drawable.topping_ham));
        toppings.add(new Ingredients("Beef", R.drawable.topping_beef));
        toppings.add(new Ingredients("Bacon", R.drawable.bacon));
        toppings.add(new Ingredients("Schrimp", R.drawable.shrimp));
        toppings.add(new Ingredients("Pepperoni", R.drawable.pepperoni));
        toppings.add(new Ingredients("Sausage", R.drawable.sausage));
        toppings.add(new Ingredients("Egg", R.drawable.sauce_bearnaise_icon));
        toppings.add(new Ingredients("Onions", R.drawable.onion));
        toppings.add(new Ingredients("Mushrooms", R.drawable.mushroom));
        toppings.add(new Ingredients("Olives", R.drawable.olive));
        toppings.add(new Ingredients("Pineapple", R.drawable.pineapple));
        toppings.add(new Ingredients("Broccoli", R.drawable.broccoli));
        toppings.add(new Ingredients("Lettuce", R.drawable.lettuce));
        toppings.add(new Ingredients("Chili", R.drawable.sauce_chili_icon));
        toppings.add(new Ingredients("Tomato slices", R.drawable.sauce_tomato_icon));
        toppings.add(new Ingredients("Beans", R.drawable.sauce_soy_icon));
        toppings.add(new Ingredients("Leaf", R.drawable.sauce_pesto_icon));



        mIngredientAdapter = new RecyclerViewAdapter(toppings, this);
        toppingList.setAdapter(mIngredientAdapter);

    }


    public void submitButton(View v){
       Toast.makeText(this, "Order sent.", Toast.LENGTH_SHORT).show();

       Intent intent = new Intent(this, MainActivity.class);
       startActivity(intent);
    }



    @Override
    public void onListItemClick(int adapterPosition) {
        int ingredientNo = adapterPosition +1;
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
                Intent intent1 = new Intent(this, MainActivity.class);
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
