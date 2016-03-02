package edu.uwi.sta.comp3275a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //displays a list view of the different menu options
        //if a particular item is chosen within the list view, then that menu option is displayed
        //the activity is displayed by calling the specified activity class


        ListView functions = (ListView)findViewById(R.id.function_list);
        functions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this, MainActivity.class);
                if (position == 0) {
                    i = new Intent(MainActivity.this, UIComponents.class);
                } else if (position == 1) {
                    i = new Intent(MainActivity.this, Layouts.class);
                } else if (position == 2) {
                    i = new Intent(MainActivity.this, Dialogs.class);
                } else if (position == 3) {
                    i = new Intent(MainActivity.this, Toast_Snackbar.class);
                } else if (position == 4) {
                    i = new Intent(MainActivity.this, BundleActivity.class);
                } else if (position == 5) {
                    i = new Intent(MainActivity.this, ResultActivity.class);
                } else if (position == 6) {
                    i = new Intent(MainActivity.this, CustomAdapter.class);
                } else if (position == 7) {
                    i = new Intent(MainActivity.this, ActionBar_Menu.class);
                }
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
