package com.gufrankhurshid.galleryapp.activities;

import android.os.Bundle;
import android.widget.GridView;

import com.gufrankhurshid.galleryapp.R;
import com.gufrankhurshid.galleryapp.adapter.GalleryAdapter;
import com.gufrankhurshid.galleryapp.dao.GalleryImageDAO;
import com.gufrankhurshid.galleryapp.dao.GalleryImageDAOImpl;
import com.gufrankhurshid.galleryapp.management.GalleryAppActivity;

/**
 * Created by guffy on 10/12/15.
 */
public class GalleryActivity extends GalleryAppActivity {

    //----->>
    GridView galleryGridView;
    GalleryAdapter galleryAdapter;

    GalleryImageDAO galleryImageDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }

    @Override
    public void referView() {
        galleryGridView = (GridView) findViewById(R.id.galleryGridView);
    }

    @Override
    public void applyTypeFace() {

    }

    @Override
    public void initialize() {
        galleryImageDAO = new GalleryImageDAOImpl();
        galleryAdapter = new GalleryAdapter(getApplicationContext(), galleryImageDAO.loadGallery());
        galleryGridView.setAdapter(galleryAdapter);
    }

    @Override
    public void setUpActionBar() {

    }
}
