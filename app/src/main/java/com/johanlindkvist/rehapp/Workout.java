package com.johanlindkvist.rehapp;

import android.content.Context;

import com.johanlindkvist.rehapp.Exercise;
import com.johanlindkvist.rehapp.Helper;

import java.io.IOException;

public class Workout {
    private Exercise[] mExercises;
    private Helper mHelper;

    public void setUpExercises(Context context) {
        mExercises = new Exercise[6];

        for (int i = 0; i < 6; i++) {
            setUpExercise(context,(i + 1) + ".ser", mExercises[i]);
        }
    }

    private void setUpExercise(Context context, String filename, Exercise exercise) {
        try {
            exercise = mHelper.deserializeExercise(filename, context);

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            createExercise(filename);
        }
    }

    private Exercise createExercise(String filename) {
        // TODO:jol Create a new Exercise object with correct information and return it
        return new Exercise("Böj", 5, 5);
    }
}