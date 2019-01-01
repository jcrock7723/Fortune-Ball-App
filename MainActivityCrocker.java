package com.example.admin.crockerfortuneball;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Random;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class MainActivityCrocker extends AppCompatActivity {

    String fortuneList[] = {"Don’t count on it","Ask again later","You may rely on it","Without a doubt","Outlook not so good","It's decidedly so","Signs point to yes","Yes definitely","Yes","My sources say NO"};

    TextView mFortuneText;
    Button mGenerateFortuneButton;
    ImageView mFortuneBallImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Call the superclass implementation
        super.onCreate(savedInstanceState);

        //Specify layout and prep the toolbar
        setContentView(R.layout.activity_main_crocker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Populate the three member variables
        mFortuneText = (TextView) findViewById(R.id.fortuneText);
        mFortuneBallImage = (ImageView) findViewById(R.id.fortunateImage);
        mGenerateFortuneButton = (Button) findViewById(R.id.fortuneButton);

        //add an onclick listener
        mGenerateFortuneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Find a random fortune from array
                int index = new Random().nextInt(fortuneList.length);
                mFortuneText.setText(fortuneList[index]);

                // Use animation library to run an image on the crystal ball
                YoYo.with(Techniques.Swing)
                        .duration(500)
                        .playOn(mFortuneBallImage);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_crocker, menu);
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
