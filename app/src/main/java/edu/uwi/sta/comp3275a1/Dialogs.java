package edu.uwi.sta.comp3275a1;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

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
                if (position == 0) {//ALERT
                    showAlert();
                } else if (position == 1) {//CONFIRM
                    showConfirm();
                } else if (position == 2) {//DATE
                    showDate();
                } else if (position == 3) {//LIST
                    showList();
                } else {//MULTIPLE CHOICE LIST
                    showMultiList();
                }
            }
        });
    }

    public void showAlert(){

        AlertDialog.Builder alert= new  AlertDialog.Builder(Dialogs.this);
        alert.setMessage("This is a simple alert dialog");
        alert.show();
    }

    public void showConfirm(){

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

    public void showDate(){

        final Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(Dialogs.this,"Date Selected is :"+dayOfMonth+"/"+(monthOfYear+1)+"/" + year,Toast.LENGTH_SHORT).show();
            }
        };

        DatePickerDialog date = new DatePickerDialog(Dialogs.this,dateListener,year,month,day);
        date.show();
    }

    String selectedItem=null;

    public void showList(){

        AlertDialog.Builder list  = new AlertDialog.Builder(Dialogs.this);
        selectedItem=null;

        DialogInterface.OnClickListener clickListener=new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String [] colorList = getResources().getStringArray(R.array.colors);
                selectedItem =colorList[which];
            }
        };

        list.setTitle("Select your preferred Colour")
                .setSingleChoiceItems(R.array.colors,-1, clickListener)
                .setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       if(selectedItem==null){
                            Toast.makeText(Dialogs.this,"No colour was selected",Toast.LENGTH_SHORT).show();
                       }
                       else {
                            Toast.makeText(Dialogs.this,"The colour selected is "+ selectedItem, Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();
    }

    ArrayList<Integer> selectedItems=new ArrayList<>();
    public void showMultiList(){

        AlertDialog.Builder multiList  = new AlertDialog.Builder(Dialogs.this);
        selectedItems.clear();

        DialogInterface.OnMultiChoiceClickListener multiClickListener = new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    // If the user checked the item, add it to the selected items
                    selectedItems.add(which);
                } else if (selectedItems.contains(which)) {
                    // Else, if the item is already in the array, remove it
                    selectedItems.remove(Integer.valueOf(which));
                }
            }
        };

        multiList.setTitle("Select the colours you like")
                .setMultiChoiceItems(R.array.colors, null, multiClickListener)
                .setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (selectedItems.isEmpty()) {
                            Toast.makeText(Dialogs.this, "You don't seem to like any of these colours", Toast.LENGTH_SHORT).show();
                        } else {
                            String[] colors = getResources().getStringArray(R.array.colors);
                            String colorChoice = "You chose: ";

                            for (int i = 0; i < selectedItems.size(); i++) {
                                if (selectedItems.size() > 1 && i == selectedItems.size() - 1)
                                    colorChoice += "and ";

                                else if (selectedItems.size() > 1 && i > 0)
                                    colorChoice += ", ";

                                colorChoice += colors[selectedItems.get(i)] + " ";
                            }

                            Toast.makeText(Dialogs.this, colorChoice, Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();
    }

}
