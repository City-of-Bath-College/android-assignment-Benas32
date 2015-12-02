package com.example.benas.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.paperdb.Paper;


public class HighScoreActivity extends ActionBarActivity {

    private ListView listView;
    private List<HighScoreObject> highscores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        Paper.init(this);

        highscores = Paper.book().read("highscores", new ArrayList<HighScoreObject>());
        listView = (ListView) findViewById(R.id.listView);
        //Toast.makeText(this, "Number = " + highscores.size(), Toast.LENGTH_SHORT).show();
        HighscoreAdapter adapter = new HighscoreAdapter(highscores);

        listView.setAdapter(adapter);
    }

    private class HighscoreAdapter extends ArrayAdapter<HighScoreObject> {

        public HighscoreAdapter(List<HighScoreObject> items) {
            super(HighScoreActivity.this, 0, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.row_highscore, null);
            }

            //get the highscore object for the row we're looking at
            HighScoreObject highscore = highscores.get(position);

            Date date = new Date(highscore.getTimestamp());
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd-MM-yyyy");

            TextView lblTitle = (TextView)convertView.findViewById(R.id.lblTitle);
            lblTitle.setText(highscore.getScore() + " - " + highscore.getName() + " - " + fmtOut.format(date));

            return  convertView;
        }//end get view
    }//end adapter class

}
