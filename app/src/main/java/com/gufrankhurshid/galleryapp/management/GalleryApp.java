package com.gufrankhurshid.galleryapp.management;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

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

        //--------->> Initializing Stetho
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

    public GalleryApp getInstance() {
        return galleryApp;
    }

    public static Context getAppContext() {
        return galleryApp.getApplicationContext();
    }
}
