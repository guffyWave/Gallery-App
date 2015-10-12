package com.gufrankhurshid.galleryapp.dto;

/**
 * Created by guffy on 10/12/15.
 */
public class GalleryImage {
    String fileUri;
    String description;

    public GalleryImage(String fileUri, String description) {
        this.fileUri = fileUri;
        this.description = description;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
