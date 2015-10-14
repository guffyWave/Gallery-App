package com.gufrankhurshid.galleryapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gufrankhurshid.galleryapp.R;
import com.gufrankhurshid.galleryapp.dao.GalleryImageDAO;
import com.gufrankhurshid.galleryapp.dao.GalleryImageDAOImpl;
import com.gufrankhurshid.galleryapp.management.GalleryAppActivity;

public class WelcomeActivity extends GalleryAppActivity {

    GalleryImageDAO galleryImageDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }


    public void clickMe(View v) {
        Intent i = new Intent(getApplicationContext(), GalleryActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem mnu1 = menu.add(1, 1, 1, "CLEAR");
        mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                galleryImageDAO.clearGallery();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void referView() {

    }

    @Override
    public void applyTypeFace() {

    }

    @Override
    public void initialize() {
        galleryImageDAO = new GalleryImageDAOImpl();
        //galleryImageDAO.clearGallery();
    }

    @Override
    public void setUpActionBar() {

    }
}
