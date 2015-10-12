package com.gufrankhurshid.galleryapp.management;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gufran on 10/10/15.
 */
public abstract class GalleryAppActivity extends AppCompatActivity implements ActivitySetup {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        referView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initialize();
        applyTypeFace();
        setUpActionBar();
    }

}
