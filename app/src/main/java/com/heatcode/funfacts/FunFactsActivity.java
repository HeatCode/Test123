package com.heatcode.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {

    //TAG for log and trouble-shooting
    public static final String TAG = FunFactsActivity.class.getSimpleName();

//Declaring member VARiables
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColors = new ColorWheel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Declare our View VARiables and assign the Views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        //Activities done OnClick of Button
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //Fact Call
            String fact = mFactBook.getFacts();
                factLabel.setText(fact);

            //Color Call
            int color = mColors.getColor();
            relativeLayout.setBackgroundColor(color);

            //Change Button Text Color with background color
            //Call Button
            showFactButton.setTextColor(color);


            }
        };
        showFactButton.setOnClickListener(listener);

//      Toast.makeText(this,"Yay! Our Activity is Complete!",Toast.LENGTH_LONG).show();
        Log.d(TAG,"We're logging from the OnCreate() method!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fun_facts, menu);
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
