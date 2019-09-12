package com.wtiii.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mQuestion;
    TextView mNoCounter;
    TextView mYesCounter;
    TextView mVoteLabel;
    Button mNoButton;
    Button mYesButton;
    Button mClearButton;

    ArrayList<String> mVotes;

    private static final String TAG = "SurveyAppActivity";
    private static final String YES_COUNT_KEY = "yes_count_key";
    private static final String NO_COUNT_KEY = "no_count_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion = findViewById(R.id.question);
        mNoCounter = findViewById(R.id.no_counter);
        mYesCounter = findViewById(R.id.yes_counter);
        mVoteLabel = findViewById(R.id.vote_label);
        mNoButton = findViewById(R.id.no_button);
        mYesButton = findViewById(R.id.yes_button);
        mClearButton = findViewById(R.id.clear_vote_button);

        if (savedInstanceState != null) {
            mYesCounter.setText(savedInstanceState.getString(YES_COUNT_KEY));
            mNoCounter.setText(savedInstanceState.getString(NO_COUNT_KEY));
        }

        if (savedInstanceState == null) {
            mYesCounter.setText("0");
            mNoCounter.setText("0");
        }

        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateYesCount();
            }
        });

        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNoCount();
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCounts();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outBundle) {
        // Required to call superclass method first
        super.onSaveInstanceState(outBundle);
        outBundle.putString(YES_COUNT_KEY, mYesCounter.getText().toString());
        outBundle.putString(NO_COUNT_KEY, mNoCounter.getText().toString());
    }


    private void updateYesCount() {
        int counter = Integer.parseInt(mYesCounter.getText().toString());
        counter += 1;
        mYesCounter.setText(Integer.toString(counter));
    }

    private void updateNoCount() {
        int counter = Integer.parseInt(mNoCounter.getText().toString());
        counter += 1;
        mNoCounter.setText(Integer.toString(counter));
    }

    private void resetCounts() {
        mYesCounter.setText("0");
        mNoCounter.setText("0");
    }
}
