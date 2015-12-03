package com.example.benas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.paperdb.Paper;

public class GameOptionsActivity extends ActionBarActivity {

    //variables
    private Button btnCapitals;
    private Button btnBuildings;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_options);


        //Parse.enableLocalDatastore(this);

       // Parse.initialize(this, "i9nFLx6PXDZKzuU2axG36m6DfVFC2Ut3FAkrBccO", "nTAHXRqge41QUFKXjo1c4fZrBd6hxi84wvMlOfvy");

        btnCapitals = (Button)findViewById(R.id.btnCapitals);
        btnBuildings = (Button) findViewById(R.id.btnBuildings);
        btnBack = (Button) findViewById(R.id.btnBack);

        Paper.init(this);

        btnCapitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameOptionsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnBuildings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameOptionsActivity.this, MainBuildingActivity.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                /*Intent i = new Intent(GameOptionsActivity.this, IntroductionActivity.class);
                startActivity(i);*/
            }
        });
    }

}