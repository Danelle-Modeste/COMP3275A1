package edu.uwi.sta.comp3275a1;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomAdapter extends AppCompatActivity {
    ListView itemList; //List View of items
    adapter customAdapter; //Custom adapter for list items in the list view
    private ArrayList<Map> items; //List of item information to be displayed in list view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //gets the list view from the xml
        itemList=(ListView)findViewById(R.id.listView);

        items = new ArrayList<>();

        //Retrieves item information to be displayed in list view
        String[] title = getResources().getStringArray(R.array.items_available);
        String[] description= getResources().getStringArray(R.array.items_description);
        TypedArray icons =getResources().obtainTypedArray(R.array.items_images);

        int icon;
        //Sends item information for each item to be displayed in the list view
        for(int i=0;i<title.length;i++){
            icon=icons.getResourceId(i,-1);
            Map temp = new HashMap();
            temp.put("icons",icon);
            temp.put("title",title[i]);
            temp.put("description",description[i]);
            items.add(temp);
        }
        customAdapter= new adapter(this, items);//creates an instance of a custom adapter with item information
        itemList.setAdapter(customAdapter); //sets the adapter to the item list
    }
}


