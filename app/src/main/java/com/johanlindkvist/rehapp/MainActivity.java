package com.johanlindkvist.rehapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

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

        setUpViews();
        mWorkout.setUpExercises(this);
    }

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
            mWeightEditTexts[i] = findViewById(getResources().getIdentifier(weightEditName, "id", getPackageName()));
            mEasyButtons[i] = findViewById(getResources().getIdentifier(easyButtonName, "id", getPackageName()));
            mHardButtons[i] = findViewById(getResources().getIdentifier(hardButtonName, "id", getPackageName()));
            mExerciseRows[i] = findViewById(getResources().getIdentifier(exerciseRowName, "id", getPackageName()));
        }
    }

    public void easyOnClick(View v) {

        int index = 0;

        // Search for the right weight view and do appropriate action for that row
        for (Button temp : mEasyButtons) {
            if ((temp.getId() == v.getId()) && !mWeightEditTexts[index].getText().toString().equals("")) {
                String weight = mWeightEditTexts[index].getText().toString();
                Toast.makeText(this, "Weight: " + weight + " kg", Toast.LENGTH_SHORT).show();
                mExerciseRows[index].removeAllViews();
                TextView done = new TextView(this);
                done.setText("Done!");
                mExerciseRows[index].addView(done);
            }
            else {
                index++;
            }
        } // for loop
    } // method

    // TODO:jol Add hardOnClick method
} // class
