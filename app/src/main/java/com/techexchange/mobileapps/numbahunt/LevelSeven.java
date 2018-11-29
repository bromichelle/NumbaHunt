package com.techexchange.mobileapps.numbahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LevelSeven extends AppCompatActivity {

    String inputAnswer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_seven);
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

    public  Boolean testAnswer (String inputAnswer){
        for (int i = 0; i < inputAnswer.length(); i++){
            if (i % 2 == 1) {
                if (inputAnswer.charAt(i) % 2 != 1){
                    return false;
                }
            }
            else if (i % 2 == 0) {
                if (inputAnswer.charAt(i) % 2 != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void correctString (View view) {

        Boolean isCorrect = testAnswer(inputAnswer);

        if (isCorrect) {
            Toast.makeText(this, "Congrats!", Toast.LENGTH_LONG).show();

            Intent nextLevel = new Intent(LevelSeven.this, LevelEight.class);
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
