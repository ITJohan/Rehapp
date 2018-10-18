package com.johanlindkvist.rehapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Exercise implements Serializable {
    private String mName;
    private int mGoalReps;
    private int mGoalSets;
    private double mWeight;

    public Exercise(String name, int goalReps, int goalSets) {
        mName = name;
        mGoalReps = goalReps;
        mGoalSets = goalSets;
        mWeight = 0;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double weight) {
        mWeight = weight;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getGoalReps() {
        return mGoalReps;
    }

    public void setGoalReps(int goalReps) {
        mGoalReps = goalReps;
    }

    public int getGoalSets() {
        return mGoalSets;
    }

    public void setGoalSets(int goalSets) {
        mGoalSets = goalSets;
    }
}
