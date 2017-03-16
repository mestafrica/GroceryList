package com.zianos.grocerylist;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.zianos.grocerylist.adapter.GroceryAdapter;
import com.zianos.grocerylist.model.Grocery;
import com.zianos.grocerylist.model.GroceryDao;

import java.util.ArrayList;
import java.util.Arrays;

public class GroceryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        //Get the application and cast it to a groceryApplication
        GroceryApplication groceryApplication = (GroceryApplication) getApplication();

        //Get  a connection to the grocery database
        GroceryDao groceryDao = groceryApplication.getDaoSession().getGroceryDao();

        ListView groceryListView = (ListView) findViewById(R.id.grocery_list_view);

        //Pass all of the items in the table into the Adapter
        ListAdapter adapter = new GroceryAdapter(this, 0, groceryDao.loadAll());

        groceryListView.setAdapter(adapter);
    }
}
