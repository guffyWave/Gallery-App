package com.gufrankhurshid.galleryapp.util;

import android.content.SharedPreferences;

import com.google.gson.Gson;
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
    private static Gson gson;

    private LocalPersistenceManager() {
    }

    public static LocalPersistenceManager getInstance() {
        synchronized (LocalPersistenceManager.class) {
            if (localPersistenceManager == null) {
                localPersistenceManager = new LocalPersistenceManager();
                sharedPreferences = GalleryApp.getAppContext().getSharedPreferences("GALLERYAPP", GalleryApp.MODE_APPEND);
                gson = new Gson();
            }
        }
        return localPersistenceManager;
    }


    public void save(String key, Object value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ///---->> convert to json by GSON and then save it.
        editor.putString(key, gson.toJson(value));
        editor.commit();
    }

    public Object load(String key, Class cl) {
        String obtainedString = sharedPreferences.getString(key, "NULL");
        //convert from JSON String to Object
        if (!obtainedString.equals("NULL")) {
            return gson.fromJson(obtainedString, cl);
        }
        return null;
    }


}
