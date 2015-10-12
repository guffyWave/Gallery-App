package com.gufrankhurshid.galleryapp.management;

import android.app.Application;
import android.content.Context;

/**
 * Created by gufran on 10/10/15.
 */
public class GalleryApp extends Application {
    private static GalleryApp galleryApp;
    public static String TAG = GalleryApp.class.getSimpleName();
    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        galleryApp = GalleryApp.this;
    }

    public GalleryApp getInstance() {
        return galleryApp;
    }

    public static Context getAppContext() {
        return galleryApp.getApplicationContext();
    }
}
