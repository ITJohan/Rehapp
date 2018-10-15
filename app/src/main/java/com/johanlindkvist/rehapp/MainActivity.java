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

    private EditText weightEditTextOne;
    private Button easyButtonOne, hardButtonOne;
    private TableRow exerciseOneRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up views
        weightEditTextOne = (EditText) findViewById(R.id.weightEditTextOne);
        easyButtonOne = (Button) findViewById(R.id.easyButtonOne);
        hardButtonOne = (Button) findViewById(R.id.hardButtonOne);
        exerciseOneRow = (TableRow) findViewById(R.id.exerciseOneRow);
    }

    public void easyOnClick(View v) {
        String weight = weightEditTextOne.getText().toString();
        Toast.makeText(this, "Weight: " + weight + " kg", Toast.LENGTH_SHORT).show();
        exerciseOneRow.removeAllViews();
        TextView done = new TextView(this);
        done.setText("Done!");
        exerciseOneRow.addView(done);
    }
}
