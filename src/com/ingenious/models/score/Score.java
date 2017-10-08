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
        new ScoreIsUpdatedEvent();
        this.redScore = redScore;
    }

    public void setGreenScore(int greenScore) {
        new ScoreIsUpdatedEvent();
        this.greenScore = greenScore;
    }

    public void setBlueScore(int blueScore) {
        new ScoreIsUpdatedEvent();
        this.blueScore = blueScore;
    }

    public void setOrangeScore(int orangeScore) {
        new ScoreIsUpdatedEvent();
        this.orangeScore = orangeScore;
    }

    public void setYellowScore(int yellowScore) {
        new ScoreIsUpdatedEvent();
        this.yellowScore = yellowScore;
    }

    public void setPurpleScore(int purpleScore) {
        new ScoreIsUpdatedEvent();
        this.purpleScore = purpleScore;
    }

    public int[] toArray() {
        int[] score = {redScore, greenScore, blueScore, orangeScore, yellowScore, purpleScore};
        return score;
    }
}
