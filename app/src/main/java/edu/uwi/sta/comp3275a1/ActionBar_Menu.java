package edu.uwi.sta.comp3275a1;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ActionBar_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_info:

                //info action bar button was clicked and a dialog pops up
                AlertDialog.Builder alert= new  AlertDialog.Builder(ActionBar_Menu.this);
                alert.setMessage("This is an info action bar button");
                alert.show();
                return true;

            case R.id.action_home:

                //home action bar button was clicked, and it takes you back to the main activity
                Intent i= new Intent(ActionBar_Menu.this,MainActivity.class);
                startActivity(i);
                this.finish();
                return true;

            case R.id.action_help:

                //help action bar button was clicked, and a toast displays a short msg
                String msg="Help was clicked";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            case R.id.action_settings:

                //settings action bar button was clicked, and a toast displays a short msg
                msg="Settings was clicked";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    //sets up or "inflates" the menu for the user to see it in the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }


}