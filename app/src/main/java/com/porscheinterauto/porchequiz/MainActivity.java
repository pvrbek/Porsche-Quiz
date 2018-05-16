package com.porscheinterauto.porchequiz;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

//Video: Develop simple Quiz in Android Studio, Vrijeme: 6:00
public class MainActivity extends AppCompatActivity {

    Button answer2, answer3, answer4,button1;
    TextView score, question;
    private Questions mQuestions = new Questions();
    private String mAnswer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private int mScore=0;
    private int mQuestionLength = mQuestions.mQuestions.length;
    public int counter=0;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        setToolbar();
        mDrawerLayout = findViewById(R.id.mainLayout);
        Fragment f = null;
        f = new CreateUser();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,f);
        transaction.commit();
        configureNavigationDrawer();
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.empty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setToolbar(){
        Toolbar tb = findViewById(R.id.tool_bar);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_action_menu);
    }

    private void configureNavigationDrawer(){
        mDrawerLayout = findViewById(R.id.mainLayout);
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment f = null;
                int itemId = item.getItemId();

                if (itemId == R.id.create_user){
                    f = new CreateUser();
                } else if (itemId == R.id.refresh){
                    f = new RefreshFragment();
                } else if (itemId == R.id.list_users){
                    f = new ListAllUsers();
                }
                if (f != null){
                    android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame,f);
                    transaction.commit();
                    mDrawerLayout.closeDrawers();
                    return true;

                }

                return false;
            }
        });
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
