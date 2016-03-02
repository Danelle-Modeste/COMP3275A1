package edu.uwi.sta.comp3275a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BundleActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private Button button;
    private static final int RESULT_ACTIVITY_REQUEST_CODE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText)findViewById(R.id.birthMonth);
        button = (Button)findViewById(R.id.bundle_btn);
        button.setOnClickListener(this);
        button.setClickable(true);
    }

    public boolean checkBirthMonth(EditText editText){
        Integer num;
        if(editText.getText().toString().equals("")){
            return false;
        }
        else {
            num = Integer.parseInt(editText.getText().toString());
            return (num > 0 && num < 13);
        }
    }

    public void onClick(View view) {
        if (view == button) {
            if(checkBirthMonth(editText)) {

                //disables the button after it has been clicked
                button.setClickable(false);

                //create a new intent and specify the target class
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

                //assigns the editText data to the key "bundleKey"
                intent.putExtra("bundleKey", editText.getText().toString());

                //launches next activity and sends the intent along with it
                startActivityForResult(intent, RESULT_ACTIVITY_REQUEST_CODE);
            }

            else{
                String msg = "Invalid month entered or no input was entered";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        Bundle extras = intent.getExtras();

        if(requestCode == RESULT_ACTIVITY_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                editText.setText(extras.getString("returnKey"));

            }
            else
                editText.setText("nothing returned");
        }

    }



}


