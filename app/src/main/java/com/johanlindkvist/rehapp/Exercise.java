package com.johanlindkvist.rehapp;

import java.io.Serializable;
import java.util.Stack;

public class Exercise implements Serializable {
    private String mName;
    private int mGoalReps;
    private int mGoalSets;
    private Stack<Double> mWeights;
    private boolean mIsHard;

    public Exercise(String name, int goalReps, int goalSets) {
        mName = name;
        mGoalReps = goalReps;
        mGoalSets = goalSets;
        mWeights = new Stack<>();
        mIsHard = false;
    }

    public boolean isHard() {
        return mIsHard;
    }

    public void setHard(boolean hard) {
        mIsHard = hard;
    }

    public Double getWeight() {
        return mWeights.peek();
    }

    public void setWeight(double weight) {
        mWeights.push(weight);
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
