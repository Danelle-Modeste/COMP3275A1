package edu.uwi.sta.comp3275a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BundleActivity extends AppCompatActivity implements View.OnClickListener{

    private final int BUNDLE2_ACTIVITY_REQUESTCODE=0;
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText)findViewById(R.id.bundle_edittxt);
        button = (Button)findViewById(R.id.bundle_btn);
        button.setOnClickListener(this);
    }

    public void onClick(View view){

        if(view == button){

            Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
            intent.putExtra("sendKey",editText.getText().toString());
            startActivityForResult(intent,BUNDLE2_ACTIVITY_REQUESTCODE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

        super.onActivityResult(requestCode,resultCode,intent);
        Bundle extras = intent.getExtras();

        editText.setText(extras!=null ? extras.getString("returnKey"):"nothing returned");
    }
}


