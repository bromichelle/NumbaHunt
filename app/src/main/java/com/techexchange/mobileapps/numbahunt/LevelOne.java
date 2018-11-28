package com.techexchange.mobileapps.numbahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LevelOne extends AppCompatActivity {

    String inputAnswer = "";
    String correctAnswer = "1234567910";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
    }


    public void buttonClicked (View view) {

        Button b = (Button)view;
        String buttonText = b.getText().toString();
        inputAnswer += buttonText;

        TextView answer = findViewById(R.id.userAnswer);
        answer.setText(String.valueOf(inputAnswer));
    }

    public void decrementString (View view) {

        if(inputAnswer != "") {
            inputAnswer = inputAnswer.substring(0, inputAnswer.length() - 1);
        }

        TextView answer = findViewById(R.id.userAnswer);
        answer.setText(String.valueOf(inputAnswer));
    }

    public void correctString (View view) {

        if (inputAnswer.equals(correctAnswer)) {
            Toast.makeText(this, "Congrats!", Toast.LENGTH_LONG).show();

            Intent nextLevel = new Intent(LevelOne.this, LevelTwo.class);
            startActivity(nextLevel);
        }
        else {
            Toast.makeText(this,"Sorry Try Again", Toast.LENGTH_LONG).show();

            inputAnswer = "";
            TextView answer = findViewById(R.id.userAnswer);
            answer.setText(String.valueOf(inputAnswer));
        }

    }


}
