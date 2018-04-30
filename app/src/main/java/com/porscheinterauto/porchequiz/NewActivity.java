package com.porscheinterauto.porchequiz;

import android.os.Bundle;
import android.app.Activity;
/**
 * Created by Predsjednik on 29-Mar-18.
 */

public class NewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.nav_drawer);
    }
}