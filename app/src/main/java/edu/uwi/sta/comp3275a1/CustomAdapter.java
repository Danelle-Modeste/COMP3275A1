package edu.uwi.sta.comp3275a1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class CustomAdapter extends AppCompatActivity {
    ListView itemList;
    adapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* itemList=(ListView)findViewById(R.id.listView);
        //customAdapter=new adapter(this)
        String[] menuList = { "HOME", "PREFERENCES", "VIEW MAP","LOG OUT"};
        Integer[] icons = {R.drawable.home2,R.drawable.settings2,R.drawable.view2,R.drawable.logout2};

        CustomListAdapter Adapter= new CustomListAdapter(this, menuList, icons);
        DrawerList.setAdapter(Adapter);*/
    }

    public void ShowDesc(View view){
        TextView tv =(TextView)findViewById(R.id.desc);
        if(tv.getVisibility()==View.VISIBLE){
            tv.setVisibility(View.INVISIBLE);
        }
        else{
            tv.setVisibility(View.VISIBLE);
        }
    }
}


