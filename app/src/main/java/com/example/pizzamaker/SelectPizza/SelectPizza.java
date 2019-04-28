package com.example.pizzamaker.SelectPizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pizzamaker.Info;
import com.example.pizzamaker.MainActivity;
import com.example.pizzamaker.R;
import java.util.ArrayList;

public class SelectPizza extends AppCompatActivity implements PizzaAdapter.OnListItemClickListener {
    RecyclerView pizzalist;
    RecyclerView.Adapter pizzalistAdapter;
    Button forwardBtn, backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pizza);

        //set up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //populate lists
        pizzalist = findViewById(R.id.pizza_list);
        pizzalist.hasFixedSize();
        pizzalist.setLayoutManager(new GridLayoutManager(SelectPizza.this, 3));

        ArrayList<PizzaItem> pizzas = new ArrayList<>();
        pizzas.add(new PizzaItem("1. Pepperoni", R.drawable.pizza1));
        pizzas.add(new PizzaItem("2. Veggie Lovers", R.drawable.pizza2));
        pizzas.add(new PizzaItem("3. Supreme", R.drawable.pizza3));
        pizzas.add(new PizzaItem("4. Surf and Turf", R.drawable.pizza4));
        pizzas.add(new PizzaItem("5. Margherita", R.drawable.pizza5));
        pizzas.add(new PizzaItem("6. Hawaiian", R.drawable.pizza6));
        pizzas.add(new PizzaItem("7. Cream Mushroom", R.drawable.pizza7));
        pizzas.add(new PizzaItem("8. Squid and Scallop", R.drawable.pizza8));
        pizzas.add(new PizzaItem("9. Ranch Chicken", R.drawable.pizza10));
        pizzas.add(new PizzaItem("10. Napoli", R.drawable.pizza11));
        pizzas.add(new PizzaItem("11. Quatro Stagioni", R.drawable.pizza12));
        pizzas.add(new PizzaItem("12. Montanara", R.drawable.pizza13));
        pizzas.add(new PizzaItem("13. Braccio di Ferro", R.drawable.pizza14));
        pizzas.add(new PizzaItem("14. Gorgonzola", R.drawable.pizza17));
        pizzas.add(new PizzaItem("15. Pizza al Pesto", R.drawable.pizza16));

        pizzalistAdapter = new PizzaAdapter(pizzas, this);
        pizzalist.setAdapter(pizzalistAdapter);


        // WHEN forward btn is clicked
        forwardBtn = findViewById(R.id.forwardButton);
        forwardBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(SelectPizza.this, "Order sent.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SelectPizza.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // WHEN backward btn is clicked
        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectPizza.this, MainActivity.class);
                startActivity(intent);
                finish();;
            }
        });
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        int pizzaNumber = clickedItemIndex +1;
        Toast.makeText(this, pizzaNumber + ". added to your basket.", Toast.LENGTH_SHORT).show();
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
