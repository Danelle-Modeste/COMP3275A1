package edu.uwi.sta.comp3275a1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Toast_Snackbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_snackbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View main=this.getWindow().getDecorView();

        final ListView msg_type= (ListView)findViewById(R.id.msg_type_list);
        msg_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg;
                if(position==0){
                    msg="This is a Short Toast";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
                }
                else if(position==1){
                    msg="This is a Long Toast";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }
                else if(position==2){
                    msg="This is a SnackBar";
                    Snackbar.make(view,msg,Snackbar.LENGTH_SHORT).show();
                }
                else{
                    msg="This SnackBar has a button! Check it out";
                    Snackbar.make(view,msg,Snackbar.LENGTH_LONG).setAction("Awesome SnackBar Action", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String msg = "Click the SnackBar to change it back";
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                            RelativeLayout main = (RelativeLayout) findViewById(R.id.snackbarLayout);

                            int color = Color.TRANSPARENT;
                            Drawable background = main.getBackground();
                            if (background instanceof ColorDrawable)
                                color = ((ColorDrawable) background).getColor();

                            String hexColor = String.format("#%06X", (0xFFFFFF & color));
                            if (hexColor.equals("#3F51B5")) {
                                main.setBackgroundColor(Color.parseColor("#FFFFFF"));
                            } else {
                                main.setBackgroundColor(Color.parseColor("#3F51B5"));
                            }
                        }
                    }).show();
                }
            }
        });
    }
}
