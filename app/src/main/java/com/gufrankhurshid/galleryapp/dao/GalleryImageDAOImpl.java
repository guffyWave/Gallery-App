package com.gufrankhurshid.galleryapp.dao;

import com.gufrankhurshid.galleryapp.dto.Gallery;
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
    public Gallery loadGallery() {
        return (Gallery) localPersistenceManager.load("GALLERY", Gallery.class);
    }

    @Override
    public void addGalleryImage(GalleryImage galleryImage) {
        Gallery localGallery = (Gallery) localPersistenceManager.load("GALLERY", Gallery.class);
        if (localGallery == null) {
            localGallery = new Gallery();
        }
        localGallery.getGalleryImageList().add(galleryImage);
        localPersistenceManager.save("GALLERY", localGallery);
    }

    @Override
    public void clearGallery() {
        Gallery localGallery = (Gallery) localPersistenceManager.load("GALLERY", Gallery.class);
        localGallery.getGalleryImageList().clear();
        localPersistenceManager.save("GALLERY", localGallery);
    }
}
