package com.porscheinterauto.porchequiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.Random;

//Video: Develop simple Quiz in Android Studio, Vrijeme: 6:00
public class MainActivity extends AppCompatActivity {

    Button answer2, answer3, answer4;
    TextView score, question;
    private Questions mQuestions = new Questions();
    private String mAnswer;
    private int mScore=0;
    private int mQuestionLength = mQuestions.mQuestions.length;
    public int counter=0;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

    }
    private void updateQuestion(int num){
        question.setText(mQuestions.getQuestion(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrect(num);
    }
    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Test završen! Tvoj rezultat je: " + mScore + " točnih odgovora.")
                .setCancelable(false)
                .setPositiveButton("Ponovi test",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("Izađi",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
