package com.photos.models;

import com.photos.storable.Storable;
import com.photos.exceptions.StorageLimitException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Photo implements Storable, Serializable {

    protected String photoId;
    protected String fileName;
    protected long fileSize;
    protected String sourcePath; // optional local file path or URL for thumbnails/previews
    protected Date captureDate;
    protected String location;
    protected User owner;
    protected List<String> tags;
    protected int width;
    protected int height;

    // ---------------------- Constructor ----------------------
    public Photo(String photoId, String fileName, long fileSize, User owner) {
        this.photoId = photoId;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.owner = owner;
        this.captureDate = new Date();        // auto timestamp
        this.tags = new ArrayList<>();
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    // ---------------------- Getters ----------------------
    public String getPhotoId() {
        return photoId;
    }

    public String getFileName() {
        return fileName;
    }

    public long getSize() {
        return fileSize;
    }

    public Date getCaptureDate() {
        return captureDate;
    }

    public String getLocation() {
        return location;
    }

    public User getOwner() {
        return owner;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // ---------------------- Setters ----------------------
    public void setLocation(String location) {
        this.location = location;
    }

    public void setWidth(int width) {
        if (width > 0) this.width = width;
    }

    public void setHeight(int height) {
        if (height > 0) this.height = height;
    }

    // ---------------------- Tag Methods ----------------------
    public void addTag(String tag) {
        if (tag != null && !tag.isEmpty() && !tags.contains(tag)) {
            tags.add(tag);
        }
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    // ---------------------- Abstract Methods ----------------------
    public abstract String getFormat();

    public abstract boolean isEditable();

    // ---------------------- Storable Interface Methods ----------------------
    @Override
    public void organize(Album album) {
        if (album != null) {
            album.addPhoto(this);
        }
    }

    @Override
    public void edit(String editType, Object parameters) {
        // Basic placeholder for edit logic
        System.out.println("Editing photo: " + fileName + " using: " + editType);
    }

    @Override
    public ShareLink share(User... users) {
        ShareLink link = new ShareLink(null, this, owner);

        if (users != null) {
            for (User u : users) {
                link.getAllowedUsers().add(u);
            }
        }

        return link;
    }

    @Override
    public void upload() throws StorageLimitException {
        // Basic simulated upload
        System.out.println("Uploading photo: " + fileName);
    }
}

