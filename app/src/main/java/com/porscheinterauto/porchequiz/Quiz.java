package com.porscheinterauto.porchequiz;

import android.content.Context;
import android.view.View;

import java.util.Random;

public class Quiz {
    //Button answer2, answer3, answer4,button1;
    //TextView score, question;
    Random r;
    Context context;
    private Questions mQuestions = new Questions();
    private String mAnswer;
    private int mScore=0;
    private int mQuestionLength = mQuestions.mQuestions.length;
    public int counter=0;

    private void updateQuestion(int num){
        //answer2.setText(mQuestions.getChoice2(num));
        //answer3.setText(mQuestions.getChoice3(num));
        //answer4.setText(mQuestions.getChoice4(num));
        mAnswer = mQuestions.getCorrect(num);
        RefreshFragment.setScore(mScore);
        //RefreshFragment.setAnswer2("Proba");
        //RefreshFragment.setAnswer3("Proba");
        //RefreshFragment.setAnswer4("Proba");
        RefreshFragment.setAnswer2(mQuestions.getChoice2(num));
        RefreshFragment.setAnswer3(mQuestions.getChoice3(num));
        RefreshFragment.setAnswer4(mQuestions.getChoice4(num));
        RefreshFragment.setQuestion(mQuestions.getQuestion(num));
    }
    public void startQuiz (){
        if (counter<mQuestionLength){
            updateQuestion(counter);}
            RefreshFragment.answer2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (RefreshFragment.answer2.getText()==mAnswer){
                        mScore++;
                        RefreshFragment.setScore(mScore);
                        counter++;
                        if (counter<mQuestionLength){
                        updateQuestion(counter);}
                    }
                }
            });
            RefreshFragment.answer3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (RefreshFragment.answer3.getText()==mAnswer){
                        mScore++;
                        RefreshFragment.setScore(mScore);
                        counter++;
                        if (counter<mQuestionLength){
                            updateQuestion(counter);}
                    }
                }
            });
            RefreshFragment.answer4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (RefreshFragment.answer4.getText()==mAnswer){
                        mScore++;
                        RefreshFragment.setScore(mScore);
                        counter++;
                        if (counter<mQuestionLength){
                            updateQuestion(counter);}
                    }
                }
            });
            /*
            answer3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (answer3.getText()==mAnswer){
                        mScore++;
                    }
                }
            });
            answer4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (answer4.getText()==mAnswer){
                        mScore++;
                    }
                }
            });

        }*/

    /*private void gameOver(){
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
    }*/
}}
