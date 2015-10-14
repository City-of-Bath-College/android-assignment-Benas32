package com.example.mik14145165.appone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class APP_1 extends AppCompatActivity {


    //variables go here
    private TextView lblQuestion;
    private Button btnTrue;
    private Button btnFalse;
    private Button btnSkip;
    private ImageView imgPicture;

    private List<QuestionObject> question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_1);


        //connect variables to interface items
        btnFalse = (Button)findViewById(R.id.btnFalse);
        btnTrue = (Button)findViewById(R.id.btnTrue);
        btnSkip = (Button)findViewById(R.id.btnSkip);
        lblQuestion = (TextView)findViewById(R.id.lblQuestion);
        imgPicture = (ImageView)findViewById(R.id.imgPicture);

        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "correct!!", Toast.LENGTH_SHORT).show();
            }
        });

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "correct!!", Toast.LENGTH_SHORT).show();
            }
        });

    }



}
