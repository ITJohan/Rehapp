package com.johanlindkvist.rehapp;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Helper {
    public void serializeExercise(Exercise exercise, String filename, Context context) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(context.openFileOutput(filename, Context.MODE_PRIVATE))) {
            out.writeObject(exercise);
        }
    }

    public Exercise deserializeExercise(String filename, Context context) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(context.openFileInput(filename))){
            Exercise exercise = (Exercise) in.readObject();
            return exercise;
        }
    }
}
