package com.zianos.grocerylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.zianos.grocerylist.adapter.GroceryAdapter;
import com.zianos.grocerylist.model.Grocery;

import java.util.ArrayList;
import java.util.Arrays;

public class GroceryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        ArrayList<Grocery> groceryItems = new ArrayList<Grocery>(Arrays.asList(
                new Grocery("Apple", 4.0),
                new Grocery("Ground Nut Paste", 16.8),
                new Grocery("Yoghurt", 22.0),
                new Grocery("Ground Nut Paste", 16.8),
                new Grocery("Digestives", 11.0),
                new Grocery("Flour", 24)
        ));

        ListView groceryListView = (ListView) findViewById(R.id.grocery_list_view);
        ListAdapter adapter = new GroceryAdapter(this, 0, groceryItems);

        groceryListView.setAdapter(adapter);
    }
}
