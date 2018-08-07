package com.porscheinterauto.porchequiz;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class RefreshFragment extends Fragment {
    static Button answer2, answer3, answer4;
    static TextView score, question;
    Quiz quiz = new Quiz();

    public static void setAnswer2(String text) {
        answer2.setText(text);
    }
    public static void setAnswer3(String text) {
        answer3.setText(text);
    }
    public static void setAnswer4(String text) {
        answer4.setText(text);
    }
    public static void setScore(int text) {
        score.setText("Rezultat: "+ text);
    }
    public static void setQuestion(String text) {
        question.setText(text);
    }
    //TODO: dodat sve settere i isprobat dal to radi - gumbi i text promijeneni u static
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);
        answer2 = v.findViewById(R.id.answer2);
        answer3 = v.findViewById(R.id.answer3);
        answer4 = v.findViewById(R.id.answer4);
        score = v.findViewById(R.id.score);
        question = v.findViewById(R.id.question);
        question.setText("ALOO");
        setAnswer2("Ide");
        quiz.startQuiz();
        return v;
    }
}
