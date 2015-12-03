package com.example.benas.myapplication;

public class QuestionObject {


    //variables
    private String question;
    private int picture;

    public QuestionObject(String question, int picture) {
        this.question = question;
        this.picture = picture;
    }

    public String getQuestion() {
        return question;
    }

    public int getPicture() {
        return picture;
    }
}
