package com.johanlindkvist.rehapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity {

    private Workout mWorkout;
    private EditText[] mWeightEditTexts;
    private Button[] mEasyButtons;
    private Button[] mHardButtons;
    private TableRow[] mExerciseRows;
    private TextView[] mPreviousViews;
    private Helper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWorkout = new Workout();
        mHelper = new Helper();

        mWorkout.setUpExercises(this);
        setUpViews();
    }

    /** Sets up all the views and also tries to get the previous weight value
     *
     */
    private void setUpViews() {
        mWeightEditTexts = new EditText[6];
        mEasyButtons = new Button[6];
        mHardButtons = new Button[6];
        mExerciseRows = new TableRow[6];
        mPreviousViews = new TextView[6];

        for (int i = 0; i < 6; i++) {
            String weightEditName = "weightEditText" + (i + 1);
            String easyButtonName = "easyButton" + (i + 1);
            String hardButtonName = "hardButton" + (i + 1);
            String exerciseRowName = "exerciseRow" + (i + 1);
            String previousViewName = "previousView" + (i + 1);
            mWeightEditTexts[i] = findViewById(getResources().getIdentifier(weightEditName, "id", getPackageName()));
            mEasyButtons[i] = findViewById(getResources().getIdentifier(easyButtonName, "id", getPackageName()));
            mHardButtons[i] = findViewById(getResources().getIdentifier(hardButtonName, "id", getPackageName()));
            mExerciseRows[i] = findViewById(getResources().getIdentifier(exerciseRowName, "id", getPackageName()));
            mPreviousViews[i] = findViewById(getResources().getIdentifier(previousViewName, "id", getPackageName()));
            try {
                mPreviousViews[i].setText("Previous: " + mWorkout.getExercise(i).getWeight() + " kg");
                if (mWorkout.getExercise(i).isHard()) {
                    mPreviousViews[i].setTextColor(Color.parseColor("#EF5350"));
                }
            } catch (EmptyStackException ex) {
                mPreviousViews[i].setText("Previous: 0 kg");
            }
        }
    }

    public void easyOnClick(View v) {

        int index = 0;

        // Search for the right weight view and do appropriate action for that row
        for (Button temp : mEasyButtons) {
            if ((temp.getId() == v.getId()) && !mWeightEditTexts[index].getText().toString().equals("")) {
                String weight = mWeightEditTexts[index].getText().toString();
                if (Double.parseDouble(weight) > 100 || Double.parseDouble(weight) < 0) {
                    Toast.makeText(this, "Enter value between 0 - 100 kg.", Toast.LENGTH_SHORT).show();
                } else {
                    mWorkout.getExercise(index).setWeight(Double.parseDouble(weight));
                    mWorkout.getExercise(index).setHard(false);
                    mExerciseRows[index].removeAllViews();
                    TextView done = new TextView(this);
                    done.setText("Done!");
                    mExerciseRows[index].addView(done);

                    try {
                        mHelper.serializeExercise(mWorkout.getExercise(index), mWorkout.getExercise(index).getName() + ".ser", this);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Could not save exercise", Toast.LENGTH_SHORT).show();
                    }

                    break;
                }
            }
            else {
                index++;
            }
        } // for loop
    } // method

    public void hardOnClick(View v) {

        int index = 0;

        // Search for the right weight view and do appropriate action for that row
        for (Button temp : mHardButtons) {
            if ((temp.getId() == v.getId()) && !mWeightEditTexts[index].getText().toString().equals("")) {
                String weight = mWeightEditTexts[index].getText().toString();
                if (Double.parseDouble(weight) > 100 || Double.parseDouble(weight) < 0) {
                    Toast.makeText(this, "Enter value between 0 - 100 kg.", Toast.LENGTH_SHORT).show();
                } else {
                    mWorkout.getExercise(index).setWeight(Double.parseDouble(weight));
                    mWorkout.getExercise(index).setHard(true);
                    mExerciseRows[index].removeAllViews();
                    TextView done = new TextView(this);
                    done.setText("Done!");
                    mExerciseRows[index].addView(done);

                    try {
                        mHelper.serializeExercise(mWorkout.getExercise(index), mWorkout.getExercise(index).getName() + ".ser", this);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Could not save exercise", Toast.LENGTH_SHORT).show();
                    }

                    break;
                }
            }
            else {
                index++;
            }
        } // for loop
    } // method

    /** Quits the app in the current state
     *
     * @param v Required by the onClick method
     */
    public void finishOnClick(View v) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
} // class
