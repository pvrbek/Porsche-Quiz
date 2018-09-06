package com.porscheinterauto.porchequiz;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

//Video: Develop simple Quiz in Android Studio, Vrijeme: 6:00
public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
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



}
