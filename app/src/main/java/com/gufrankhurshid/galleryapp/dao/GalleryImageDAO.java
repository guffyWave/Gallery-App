package com.gufrankhurshid.galleryapp.dao;

import com.gufrankhurshid.galleryapp.dto.GalleryImage;

import java.util.List;

/**
 * Created by guffy on 10/13/15.
 */
public interface GalleryImageDAO {
    
    public List<GalleryImage> loadGallery();

    public void addGalleryImage(GalleryImage galleryImage);

    public void clearGallery();

}
