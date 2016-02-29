package edu.uwi.sta.comp3275a1;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

public class Dialogs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView dialogs=(ListView)findViewById(R.id.dialog_list);
        dialogs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){//ALERT
                    AlertDialog.Builder alert= new  AlertDialog.Builder(Dialogs.this);
                    alert.setMessage("This is a simple alert dialog");
                    alert.show();
                }
                else if(position==1){//CONFIRM
                    AlertDialog.Builder confirm = new AlertDialog.Builder(Dialogs.this);
                    confirm.setMessage("Will you take the red pill?");
                    confirm.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Dialogs.this, "CONGRATULATIONS :)", Toast.LENGTH_SHORT).show();
                        }
                    });

                    confirm.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Dialogs.this, "Maybe Next Time Then :(", Toast.LENGTH_SHORT).show();
                        }
                    });
                    confirm.show();
                }
                else if(position==2){//DATE
                    DatePickerDialog.Builder date= new DatePickerDialog.Builder(Dialogs.this);

                    date.show();
                }
                else  if(position==3){//LIST

                }
                else{//MULTIPLE CHOICE LIST

                }
            }
        });

    }

}
