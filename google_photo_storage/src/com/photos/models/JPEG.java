package com.photos.models;

import com.photos.exceptions.StorageLimitException;

public class JPEG extends Photo {

    private int quality;              // 1-100
    private boolean isProgressive;    // progressive JPEG support
    private String colorProfile;      // sRGB, AdobeRGB, etc.

    // ----------------- Constructor -----------------
    public JPEG(String photoId, String fileName, long fileSize, User owner) {
        super(photoId, fileName, fileSize, owner);

        // Default JPEG properties
        this.quality = 80;
        this.isProgressive = false;
        this.colorProfile = "sRGB";
    }

    // ----------------- Getters & Setters -----------------
    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        if (quality >= 1 && quality <= 100) {
            this.quality = quality;
        }
    }

    public boolean isProgressive() {
        return isProgressive;
    }

    public void setProgressive(boolean progressive) {
        this.isProgressive = progressive;
    }

    public String getColorProfile() {
        return colorProfile;
    }

    public void setColorProfile(String colorProfile) {
        if (colorProfile != null && !colorProfile.isEmpty()) {
            this.colorProfile = colorProfile;
        }
    }

    // ----------------- Abstract Implementations -----------------
    @Override
    public String getFormat() {
        return "JPEG";
    }

    @Override
    public boolean isEditable() {
        return true;
    }

    // ----------------- Storable Implementations -----------------
    @Override
    public void upload() throws StorageLimitException {
        System.out.println("Uploading JPEG: " + fileName + " with quality " + quality);
        // Future: compress based on quality, upload to cloud
    }

    @Override
    public void organize(Album album) {
        if (album != null) {
            album.addPhoto(this);
        }
    }

    @Override
    public void edit(String editType, Object parameters) {
        System.out.println("Applying JPEG edit: " + editType + " to " + fileName);
        // Future: apply actual edit logic
    }

    @Override
    public ShareLink share(User... users) {
        ShareLink link = new ShareLink(null, this, owner);
        if (users != null) for (User u : users) link.getAllowedUsers().add(u);
        return link;
    }

    // ----------------- JPEG-specific method -----------------
    public void optimizeForWeb() {
        this.quality = 70;
        this.isProgressive = true;
        System.out.println("JPEG optimized for web display.");
    }
}

