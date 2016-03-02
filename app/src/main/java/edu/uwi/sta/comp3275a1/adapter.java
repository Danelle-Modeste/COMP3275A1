package edu.uwi.sta.comp3275a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Map;

//Custom Adapter to display Item information in list view
public class adapter extends ArrayAdapter<Map> {

    public adapter(Context context, ArrayList<Map> items){
        super(context, 0, items);
    }

    public View getView(int position, View v, ViewGroup p){
        //Retrieves the view item position and View group
        v = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        final View V = v; // Copies the view into a final variable to be used by button function

        //Retrieves position, title, description and image information from the map
        Map map = getItem(position);

        String title = (String)map.get("title");
        String descr = (String)map.get("description");
        int icon = (Integer)map.get("icons");

        //Displays the information in the relevant areas in the view
        ((TextView)v.findViewById(R.id.title)).setText(title);
        ((TextView)v.findViewById(R.id.desc)).setText(descr);
        ((ImageView)v.findViewById(R.id.img)).setImageResource(icon);

        //Retrieves  the button from the view and sets the function to it
        final Button showDesc = (Button) v.findViewById(R.id.showDesc);
        showDesc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                TextView tv =(TextView) V.findViewById(R.id.desc);
                if(tv.getVisibility()==View.VISIBLE){
                    tv.setVisibility(View.INVISIBLE);
                    showDesc.setText("Show Description");
                }
                else{
                    tv.setVisibility(View.VISIBLE);
                    showDesc.setText("Hide Description");
                }
            }
        });
        return v; //Returns the view to be displayed as a list view item
    }
}

