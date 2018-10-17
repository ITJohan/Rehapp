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

    private EditText[] weightEdits = new EditText[6];
    private Button[] easyButtons = new Button[6];
    private Button[] hardButtons = new Button[6];
    private TableRow[] exerciseRows = new TableRow[6];
    private TextView[] previousViews = new TextView[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String[] weightEditTextNames = {"weightEditTextOne", "weightEditTextTwo", "weightEditTextThree", "weightEditTextFour", "weightEditTextFive", "weightEditTextSix"};
//        String[] easyButtonNames = {"easyButtonOne", "easyButtonTwo", "easyButtonThree", "easyButtonFour", "easyButtonFive", "easyButtonSix"};
//        String[] hardButtonNames = {"hardButtonOne", "hardButtonTwo", "hardButtonThree", "hardButtonFour", "hardButtonFive", "hardButtonSix"};
//        String[] exerciseTableRowNames = {"exerciseOneRow", "exerciseTwoRow", "exerciseThreeRow", "exerciseFourRow", "exerciseFiveRow", "exerciseSixRow"};

        // Set up views
        // TODO:jol Is there a way to use for loop?
        weightEdits[0] = findViewById(R.id.weightEditTextOne);
        weightEdits[1] = findViewById(R.id.weightEditTextTwo);
        weightEdits[2] = findViewById(R.id.weightEditTextThree);
        weightEdits[3] = findViewById(R.id.weightEditTextFour);
        weightEdits[4] = findViewById(R.id.weightEditTextFive);
        weightEdits[5] = findViewById(R.id.weightEditTextSix);
        easyButtons[0] = findViewById(R.id.easyButtonOne);
        easyButtons[1] = findViewById(R.id.easyButtonTwo);
        easyButtons[2] = findViewById(R.id.easyButtonThree);
        easyButtons[3] = findViewById(R.id.easyButtonFour);
        easyButtons[4] = findViewById(R.id.easyButtonFive);
        easyButtons[5] = findViewById(R.id.easyButtonSix);
        hardButtons[0] = findViewById(R.id.hardButtonOne);
        hardButtons[1] = findViewById(R.id.hardButtonTwo);
        hardButtons[2] = findViewById(R.id.hardButtonThree);
        hardButtons[3] = findViewById(R.id.hardButtonFour);
        hardButtons[4] = findViewById(R.id.hardButtonFive);
        hardButtons[5] = findViewById(R.id.hardButtonSix);
        exerciseRows[0] = findViewById(R.id.exerciseOneRow);
        exerciseRows[1] = findViewById(R.id.exerciseTwoRow);
        exerciseRows[2] = findViewById(R.id.exerciseThreeRow);
        exerciseRows[3] = findViewById(R.id.exerciseFourRow);
        exerciseRows[4] = findViewById(R.id.exerciseFiveRow);
        exerciseRows[5] = findViewById(R.id.exerciseSixRow);
        previousViews[0] = findViewById(R.id.previousViewOne);
        previousViews[1] = findViewById(R.id.previousViewTwo);
        previousViews[2] = findViewById(R.id.previousViewThree);
        previousViews[3] = findViewById(R.id.previousViewFour);
        previousViews[4] = findViewById(R.id.previousViewFive);
        previousViews[5] = findViewById(R.id.previousViewSix);
    }

    public void easyOnClick(View v) {

        int index = 0;

        // Search for the right weight view and do appropriate action for that row
        for (Button temp : easyButtons) {
            if (temp.getId() == v.getId()) {
                // TODO:jol Check to see if weight has been added, if not don't do anything
                String weight = weightEdits[index].getText().toString();
                Toast.makeText(this, "Weight: " + weight + " kg", Toast.LENGTH_SHORT).show();
                exerciseRows[index].removeAllViews();
                TextView done = new TextView(this);
                done.setText("Done!");
                exerciseRows[index].addView(done);
            } else {
                index++;
            }
        } // for loop
    } // method

    // TODO:jol Add hardOnClick method
} // class
