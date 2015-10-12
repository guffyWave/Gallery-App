package com.gufrankhurshid.galleryapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gufrankhurshid.galleryapp.R;
import com.gufrankhurshid.galleryapp.management.GalleryAppActivity;

public class WelcomeActivity extends GalleryAppActivity {

    //TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }


    public void clickMe(View v) {
       // textView.setText("Bismilah Hirrahma Nirrahim");
       // Toast.makeText(getApplicationContext(), "Bismillha", Toast.LENGTH_LONG).show();
    }

    @Override
    public void referView() {
        //textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void applyTypeFace() {

    }

    @Override
    public void initialize() {

    }

    @Override
    public void setUpActionBar() {

    }
}
