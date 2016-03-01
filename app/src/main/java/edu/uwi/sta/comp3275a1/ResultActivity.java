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
               intent.putExtra("returnKey",editText.getText().toString());
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
}
