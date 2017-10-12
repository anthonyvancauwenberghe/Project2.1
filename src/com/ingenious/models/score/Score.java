package com.ingenious.models.score;

import com.ingenious.events.impl.ScoreIsUpdatedEvent;

public class Score {

    public int redScore;
    public int greenScore;
    public int blueScore;
    public int orangeScore;
    public int yellowScore;
    public int purpleScore;

    public Score() {
        this.redScore = 0;
        this.greenScore = 0;
        this.blueScore = 0;
        this.orangeScore = 0;
        this.yellowScore = 0;
        this.purpleScore = 0;
    }

    public Score(int redScore, int greenScore, int blueScore, int orangeScore, int yellowScore, int purpleScore) {
        this.redScore = redScore;
        this.greenScore = greenScore;
        this.blueScore = blueScore;
        this.orangeScore = orangeScore;
        this.yellowScore = yellowScore;
        this.purpleScore = purpleScore;
    }

    public int getRedScore() {
        return redScore;
    }

    public int getGreenScore() {
        return greenScore;
    }

    public int getBlueScore() {
        return blueScore;
    }

    public int getOrangeScore() {
        return orangeScore;
    }

    public int getYellowScore() {
        return yellowScore;
    }

    public int getPurpleScore() {
        return purpleScore;
    }

    public void setRedScore(int redScore) {
        this.redScore = redScore;
        new ScoreIsUpdatedEvent();
    }

    public void setGreenScore(int greenScore) {
        this.greenScore = greenScore;
        new ScoreIsUpdatedEvent();
    }

    public void setBlueScore(int blueScore) {
        this.blueScore = blueScore;
        new ScoreIsUpdatedEvent();
    }

    public void setOrangeScore(int orangeScore) {
        this.orangeScore = orangeScore;
        new ScoreIsUpdatedEvent();
    }

    public void setYellowScore(int yellowScore) {
        this.yellowScore = yellowScore;
        new ScoreIsUpdatedEvent();
    }

    public void setPurpleScore(int purpleScore) {
        this.purpleScore = purpleScore;
        new ScoreIsUpdatedEvent();
    }

    public int[] toArray() {
        int[] score = {redScore, greenScore, blueScore, orangeScore, yellowScore, purpleScore};
        return score;
    }
}