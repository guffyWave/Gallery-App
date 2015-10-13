package com.gufrankhurshid.galleryapp.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gufran on 14/10/15.
 */
public class Gallery {
    List<GalleryImage> galleryImageList;

    public Gallery() {
        galleryImageList = new ArrayList<>();
    }

    public List<GalleryImage> getGalleryImageList() {
        return galleryImageList;
    }

    public void setGalleryImageList(List<GalleryImage> galleryImageList) {
        this.galleryImageList = galleryImageList;
    }
}
