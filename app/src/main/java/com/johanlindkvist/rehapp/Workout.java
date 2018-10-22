package com.johanlindkvist.rehapp;

import android.content.Context;

import java.io.IOException;

public class Workout {
    private Exercise[] mExercises;
    private String[] mNamesArray = {"Diamanten", "Rundrotation", "Kabelpress", "Uppåtrotation", "Utåtrotation", "Innåtrotation"};
    private int[] mRepsArray = {10, 10, 10, 5, 10, 10};
    private int[] mSetsArray = {3, 3, 3, 3, 3, 3};
    private Helper mHelper;

    public Workout() {
        mExercises = new Exercise[6];
        mHelper = new Helper();
    }

    public void setUpExercises(Context context) {
        for (int i = 0; i < 6; i++) {
            mExercises[i] = setUpExercise(context, mNamesArray[i], mRepsArray[i], mSetsArray[i]);
        }
    }

    private Exercise setUpExercise(Context context, String name, int reps, int sets) {
        Exercise exercise = null;

        try {
            exercise = mHelper.deserializeExercise(name + ".ser", context);

        }
        catch (IOException ex) {
            ex.printStackTrace();
            exercise = new Exercise(name, reps, sets);
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            exercise = new Exercise(name, reps, sets);
        }

        return exercise;
    }

    public Exercise getExercise(int index) {
        return mExercises[index];
    }
}