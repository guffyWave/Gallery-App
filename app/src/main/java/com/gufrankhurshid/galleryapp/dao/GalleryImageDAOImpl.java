package com.gufrankhurshid.galleryapp.dao;

import com.gufrankhurshid.galleryapp.dto.GalleryImage;
import com.gufrankhurshid.galleryapp.util.LocalPersistenceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guffy on 10/13/15.
 */
public class GalleryImageDAOImpl implements GalleryImageDAO {

    LocalPersistenceManager localPersistenceManager;

    public GalleryImageDAOImpl() {
        localPersistenceManager = LocalPersistenceManager.getInstance();
    }

    @Override
    public List<GalleryImage> loadGallery() {
        return (List<GalleryImage>) localPersistenceManager.load("GALLERY");
    }

    @Override
    public void addGalleryImage(GalleryImage galleryImage) {
        List<GalleryImage> localGallery = (List<GalleryImage>) localPersistenceManager.load("GALLERY");
        if (localGallery == null) {
            localGallery = new ArrayList<>();
        }
        localGallery.add(galleryImage);
        localPersistenceManager.save("GALLERY", localGallery);
    }

    @Override
    public void clearGallery() {
        List<GalleryImage> localGallery = (List<GalleryImage>) localPersistenceManager.load("GALLERY");
        localGallery.clear();
        localPersistenceManager.save("GALLERY", localGallery);
    }
}
