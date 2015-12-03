package com.example.benas.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import com.parse.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import io.paperdb.Paper;


public class MainActivity extends ActionBarActivity {


    //variables go here

    private Button btnFalse;
    private Button btnTrue;
    private TextView lblQuestion;
    private ImageView imgPicture;
    private TextView lblScore;

    private boolean expectedAnswer;

    private List<QuestionObject> questions;
    private QuestionObject currentQuestion;

    private int index;
    private int score;

    private String username = "";
    //private String textQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_capitals);

        //connect variables to interface items
        btnFalse = (Button)findViewById(R.id.btnFalse);
        btnTrue = (Button)findViewById(R.id.btnTrue);
        lblQuestion = (TextView)findViewById(R.id.lblQuestion);
        imgPicture = (ImageView)findViewById(R.id.imgPicture);
        lblScore = (TextView)findViewById(R.id.lblScore);

        //set questionnaire text
        lblQuestion.setText("LOADING");

        //set image picture
        imgPicture.setImageResource(R.drawable.loading);

        //set index/score to zero
        index = 0;
        score = 0;

        //onclick listeners
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                determineButtonPress(false);
            }
        });

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                determineButtonPress(true);
            }
        });

        generateQuestion();
        setUpQuestion();
        Paper.init(this);

    }

    private void generateQuestion(){
        questions = new ArrayList<>();

        questions.add(new QuestionObject("XswXYoqd2r", R.drawable.lithuania));
        questions.add(new QuestionObject("gAa57RuCQ6", R.drawable.canada));
        questions.add(new QuestionObject("WqBHXcyHFR", R.drawable.russia));
        questions.add(new QuestionObject("68VFx2U4Jd", R.drawable.france));
        questions.add(new QuestionObject("cJyAm8oZQn", R.drawable.norway));
        questions.add(new QuestionObject("uDuL2g9lbu", R.drawable.germany));
        questions.add(new QuestionObject("YR2stY93op", R.drawable.china));
        questions.add(new QuestionObject("kJ1PzYTl0Q", R.drawable.usa));
        questions.add(new QuestionObject("FN4NoZmYA9", R.drawable.spain));
        questions.add(new QuestionObject("rxZwrSTM4I", R.drawable.england));
    }

    private void setUpQuestion() {

        if (index == questions.size()) {
            endGame();
        } else {

            currentQuestion = questions.get(index);

            ParseQuery<ParseObject> query = ParseQuery.getQuery("Question");
            query.getInBackground(currentQuestion.getQuestion(), new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    if (e == null) {
                        // object will be your game score
                        String textQuestion = object.getString("Question");
                        lblQuestion.setText(textQuestion);
                        expectedAnswer = object.getBoolean("answer");
                        imgPicture.setImageResource(currentQuestion.getPicture());
                        index++;
                    } else {
                        // somethings wrong
                    }
                }
            });

        }
    }

    private void determineButtonPress(boolean answer){

        MediaPlayer player;
        if (answer == expectedAnswer){
        //you were right!
        score ++;

            lblScore.setText("Score: " + score);
            Toast.makeText(MainActivity.this, "Right!!!", Toast.LENGTH_SHORT).show();
            player = MediaPlayer.create(MainActivity.this,R.raw.correct); // plays correct sound
            player.start();

        } else {

            //you were wrong!
            Toast.makeText(MainActivity.this, "Wrong!!!", Toast.LENGTH_SHORT).show();
            player = MediaPlayer.create(MainActivity.this,R.raw.wrong); // plays error sound
            player.start();
        }

        setUpQuestion();
    }

    private void endGame() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this); // declares builder which is going to be the prompt for users to type in their high scores
        builder.setTitle("Enter your name:");

        // Set up input
        final EditText input = new EditText(MainActivity.this);
        // Specify the type of input expected
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        builder.setView(input);
        builder.setCancelable(false);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                username = input.getText().toString(); // user types in their name here

                // new high score!
                HighScoreObject highScore = new HighScoreObject(username, score, new Date().getTime());

                // get user prefs
                List<HighScoreObject> highScores = Paper.book().read("highscores", new ArrayList<HighScoreObject>());

                // add item
                highScores.add(highScore);

                // this is ordering the highscores from highest to lowest
                Collections.sort(highScores, new Comparator<HighScoreObject>() {
                    public int compare(HighScoreObject a, HighScoreObject b) {

                        if (a.getScore() < b.getScore()) {
                            return 1;
                        } else if (a.getScore() > b.getScore()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });


                // save again
                Paper.book().write("highscores", highScores); // saving the highscore then the name the user put in
                //return back to intro screen
                finish();


            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // takes you back to main menu
            }
        });
        builder.show();
    }
}
