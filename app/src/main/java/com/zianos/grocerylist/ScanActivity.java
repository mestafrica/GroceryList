package com.zianos.grocerylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zianos.grocerylist.model.Grocery;
import com.zianos.grocerylist.model.GroceryDao;

public class ScanActivity extends AppCompatActivity {

    private Button scanButton, payButton;
    private EditText nameInput, priceInput;

    private GroceryDao groceryDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        GroceryApplication groceryApplication = (GroceryApplication) getApplication();
        groceryDao = groceryApplication.getDaoSession().getGroceryDao();

        scanButton = (Button) findViewById(R.id.scan_button);
        payButton = (Button) findViewById(R.id.pay_button);
        nameInput = (EditText) findViewById(R.id.name_input);
        priceInput = (EditText) findViewById(R.id.price_input);

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Grocery enteredGrocery = getGrocery();
                groceryDao.insert(enteredGrocery);
    
                clearGrocery();
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), GroceryActivity.class);
                startActivity(i);
            }
        });
    }

    private Grocery getGrocery(){
        String groceryName = nameInput.getText().toString();
        double groceryPrice = Double.valueOf(priceInput.getText().toString());

        return new Grocery(null, groceryName, groceryPrice);
    }

    private void clearGrocery(){
        nameInput.setText("");
        priceInput.setText("");
    }
}