package com.example.benas.myapplication;

/**
 * Created by Benas on 28/11/2015.
 */
public class QuestionObject {


    //variables
    private String question;
    private int picture;

    public QuestionObject(String question, int picture) {
        this.question = question;
        //this.answer = answer;
        this.picture = picture;
    }

    public String getQuestion() {
        return question;
    }

    /*public boolean isAnswer() {
        return answer;
    }*/

    public int getPicture() {
        return picture;
    }
}
