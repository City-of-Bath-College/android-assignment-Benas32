package com.example.benas.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;


public class IntroductionActivity extends ActionBarActivity {

    //variables
    private Button btnPlay;
    private Button btnHighScore;
    private Button btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        //Parse.enableLocalDatastore(this);

        Parse.initialize(this, "i9nFLx6PXDZKzuU2axG36m6DfVFC2Ut3FAkrBccO", "nTAHXRqge41QUFKXjo1c4fZrBd6hxi84wvMlOfvy");


        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnHighScore = (Button) findViewById(R.id.btnHighScore);
        btnAbout = (Button) findViewById(R.id.btnAbout);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntroductionActivity.this, GameOptionsActivity.class);
                startActivity(i);
            }
        });

        btnHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntroductionActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntroductionActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });
    }

}
