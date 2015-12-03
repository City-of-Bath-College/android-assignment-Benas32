package com.example.benas.myapplication;

public class HighScoreObject {
    //nothing here!
    private String name;
    private int score;
    private Long timestamp;

    public HighScoreObject(String name, int score, Long timestamp) {
        this.name = name;
        this.score = score;
        this.timestamp = timestamp;
    }

    public HighScoreObject() {
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public Long getTimestamp() {
        return timestamp;
    }
}