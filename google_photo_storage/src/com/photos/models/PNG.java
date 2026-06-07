package com.photos.models;

import com.photos.exceptions.StorageLimitException;

public class PNG extends Photo {

    private boolean hasTransparency;   // true if PNG has alpha channel
    private int colorDepth;            // 8, 16, 24, 32 bits
    private boolean isLossless;        // always true for PNG but included for completeness

    // ----------------- Constructor -----------------
    public PNG(String photoId, String fileName, long fileSize, User owner) {
        super(photoId, fileName, fileSize, owner);

        // Default PNG properties
        this.hasTransparency = false;
        this.colorDepth = 24;
        this.isLossless = true;
    }

    // ----------------- Getters & Setters -----------------
    public boolean hasTransparency() {
        return hasTransparency;
    }

    public void setHasTransparency(boolean hasTransparency) {
        this.hasTransparency = hasTransparency;
    }

    public int getColorDepth() {
        return colorDepth;
    }

    public void setColorDepth(int colorDepth) {
        if (colorDepth == 8 || colorDepth == 16 || colorDepth == 24 || colorDepth == 32) {
            this.colorDepth = colorDepth;
        }
    }

    public boolean isLossless() {
        return isLossless;
    }

    public void setLossless(boolean lossless) {
        this.isLossless = lossless;
    }

    // ----------------- Abstract Implementations -----------------
    @Override
    public String getFormat() {
        return "PNG";
    }

    @Override
    public boolean isEditable() {
        return true;
    }

    // ----------------- Storable Methods -----------------
    @Override
    public void upload() throws StorageLimitException {
        System.out.println("Uploading PNG: " + fileName +
                " (Transparency: " + hasTransparency + ")");
        // Future: preserve alpha channel, handle large PNG uploads
    }

    @Override
    public void organize(Album album) {
        if (album != null) {
            album.addPhoto(this);
        }
    }

    @Override
    public void edit(String editType, Object parameters) {
        System.out.println("Applying PNG edit: " + editType + " to " + fileName);
        // Future: handle alpha edits, color depth changes
    }

    @Override
    public ShareLink share(User... users) {
        ShareLink link = new ShareLink(null, this, owner);
        if (users != null) for (User u : users) link.getAllowedUsers().add(u);
        return link;
    }

    // ----------------- PNG-specific feature -----------------
    public void removeBackground() {
        if (hasTransparency) {
            System.out.println("Background removed using transparency.");
        } else {
            System.out.println("No transparency available to remove background.");
        }
    }
}

