package edu.uwi.sta.comp3275a1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UIComponents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicomponents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void SaveUserData(View view){
        TextView userName = (TextView)findViewById(R.id.txt_username);
        TextView password = (TextView)findViewById(R.id.txt_password);
        TextView email = (TextView)findViewById(R.id.txt_email);
        RadioGroup sex= (RadioGroup)findViewById(R.id.btn_sex);

        int radioButtonId=sex.getCheckedRadioButtonId();
        String user_sex;
        if(radioButtonId==-1) {
            user_sex="";
        }
        else{
            user_sex=((RadioButton)findViewById(radioButtonId)).getText().toString();
        }

        TextView usr_name = (TextView)findViewById(R.id.txt_show_uname);
        TextView usr_pword = (TextView)findViewById(R.id.txt_show_pword);
        TextView usr_email = (TextView)findViewById(R.id.txt_show_email);
        TextView usr_sex = (TextView)findViewById(R.id.txt_show_sex);

        usr_name.setText(userName.getText());
        usr_pword.setText(password.getText());
        usr_email.setText(email.getText());
        usr_sex.setText(user_sex);
    }

}
