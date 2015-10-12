package com.gufrankhurshid.galleryapp.util;

import android.content.SharedPreferences;

import com.gufrankhurshid.galleryapp.dto.GalleryImage;
import com.gufrankhurshid.galleryapp.management.GalleryApp;

import java.util.List;

/**
 * Created by guffy on 10/12/15.
 */
public class LocalPersistenceManager {
    private static GalleryApp galleryApp;
    static private LocalPersistenceManager localPersistenceManager;
    private static SharedPreferences sharedPreferences;


    private LocalPersistenceManager() {
    }

    public static LocalPersistenceManager getInstance() {
        synchronized (localPersistenceManager) {
            if (localPersistenceManager == null) {
                localPersistenceManager = new LocalPersistenceManager();
                sharedPreferences = GalleryApp.getAppContext().getSharedPreferences("GALLERYAPP", GalleryApp.MODE_APPEND);
            }
        }
        return localPersistenceManager;
    }


    public void save(String key, Object value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ///---->> convert to json by GSON and then save it .
        editor.putString(key, (String) value);
    }

    public Object load(String key) {
        String obtainedString = sharedPreferences.getString(key, null);
        //convert from JSON String to Object
        return null;
    }


}
