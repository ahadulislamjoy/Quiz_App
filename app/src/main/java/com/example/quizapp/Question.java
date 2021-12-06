package com.example.quizapp;

public class Question {
    private int ansResId;
    private boolean ansTrue;

    public Question(int ansResId, boolean ansTrue) {
        this.ansResId = ansResId;
        this.ansTrue = ansTrue;
    }

    public int getAnsResId() {
        return ansResId;
    }

    public void setAnsResId(int ansResId) {
        this.ansResId = ansResId;
    }

    public boolean isAnsTrue() {
        return ansTrue;
    }

    public void setAnsTrue(boolean ansTrue) {
        this.ansTrue = ansTrue;
    }
}
