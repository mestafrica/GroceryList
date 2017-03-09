package com.zianos.grocerylist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.zianos.grocerylist.R;
import com.zianos.grocerylist.model.Grocery;

import java.util.List;

public class GroceryAdapter extends ArrayAdapter<Grocery> {
    public GroceryAdapter(Context context, int resource, List<Grocery> groceries) {
        super(context, android.R.layout.simple_list_item_1, groceries);

        Toast.makeText(context, "There are " + groceries.size() + "items in the list", Toast.LENGTH_LONG).show();
    }

    @Override
    public int getPosition(Grocery item) {
        return super.getPosition(item);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Grocery groceryItem = getItem(position);

        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inf = LayoutInflater.from(getContext());
            convertView = inf.inflate(android.R.layout.simple_list_item_2, null);


            viewHolder = new ViewHolder();
            viewHolder.lineOne = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.lineTwo = (TextView) convertView.findViewById(android.R.id.text2);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.lineOne.setText("Name: " + groceryItem.getName());
        viewHolder.lineTwo.setText("Price: "+groceryItem.getPrice());

        return convertView;
    }

    private static class ViewHolder {
        TextView lineOne;
        TextView lineTwo;
    }

}
