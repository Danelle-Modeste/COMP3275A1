package edu.uwi.sta.comp3275a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private String intentString;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText)findViewById(R.id.result);
        button = (Button)findViewById(R.id.finish_btn);

        button.setOnClickListener(new View.OnClickListener(){

           public void onClick(View view){

               intentString = editText.getText().toString();

               Intent intent = new Intent();
               intent.putExtra("returnKey",getMonth(editText));
               setResult(RESULT_OK,intent);

               finish();
           }

       });

       intentString = savedInstanceState!= null ? savedInstanceState.getString("bundleKey"):null;

       if (intentString == null) {

           Bundle extras = getIntent().getExtras();
           intentString = extras != null ? extras.getString("bundleKey") : "nothing passed in";
       }
        editText.setText(intentString);
   }

    public String getMonth(EditText editText){

        String month = editText.getText().toString();

        if(month.equals("1"))
            return "January";
        else if(month.equals("2"))
            return "February";
        else if(month.equals("3"))
            return "March";
        else if(month.equals("4"))
            return "April";
        else if(month.equals("5"))
            return "May";
        else if(month.equals("6"))
            return "June";
        else if(month.equals("7"))
            return "July";
        else if(month.equals("8"))
            return "August";
        else if(month.equals("9"))
            return "September";
        else if(month.equals("10"))
            return "October";
        else if(month.equals("11"))
            return "November";
        else
            return "December";

    }
}
