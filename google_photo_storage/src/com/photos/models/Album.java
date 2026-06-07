package com.photos.models;

import java.io.Serializable;
import java.util.Date;
import java.util.TreeSet;
import java.util.Objects;

public class Album implements Serializable, Comparable<Album> {

    private String albumId;
    private String albumName;
    private String description;
    private Date createdDate;
    private User owner;
    private TreeSet<Photo> photos;
    private String coverPhotoId;
    private boolean isShared;

    public Album(String albumId, String albumName, User owner) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.owner = owner;
        this.createdDate = new Date();     // current timestamp
        this.photos = new TreeSet<>(       // TreeSet automatically sorts photos
            (p1, p2) -> p1.getCaptureDate().compareTo(p2.getCaptureDate())
        );
        this.isShared = false;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        if (albumId == null || albumId.isEmpty()) return;
        this.albumId = albumId;
    }

    public String getName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        if (albumName == null || albumName.trim().isEmpty()) return;
        this.albumName = albumName;
    }

    public String getDescription() { 
        return description; 
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        if (createdDate != null) {
            this.createdDate = createdDate;
        }
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        if (owner != null) this.owner = owner;
    }

    public TreeSet<Photo> getPhotos() {
        return photos;
    }

    public String getCoverPhotoId() {
        return coverPhotoId;
    }

    public void setCoverPhotoId(String coverPhotoId) {
        this.coverPhotoId = coverPhotoId;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        this.isShared = shared;
    }

    public void addPhoto(Photo photo) {
        if (photo == null) return;

        photos.add(photo);

        // Set cover photo if album previously had none
        if (coverPhotoId == null) {
            coverPhotoId = photo.getPhotoId();
        }
    }

    public void removePhoto(String photoId) {
        if (photoId == null) return;

        Photo toRemove = photos.stream()
                .filter(ph -> Objects.equals(ph.getPhotoId(), photoId))
                .findFirst()
                .orElse(null);

        if (toRemove != null) {
            photos.remove(toRemove);

            // If removed photo was the cover, update cover
            if (Objects.equals(coverPhotoId, photoId)) {
                coverPhotoId = photos.isEmpty() 
                                ? null 
                                : photos.first().getPhotoId();
            }
        }
    }

    public int getPhotoCount() {
        return photos.size();
    }

    public long getAlbumSize() {
        return photos.stream().mapToLong(Photo::getSize).sum();
    }

    public Photo getCoverPhoto() {
        if (coverPhotoId == null) return null;

        return photos.stream()
                .filter(ph -> ph.getPhotoId().equals(coverPhotoId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int compareTo(Album other) {
        return this.createdDate.compareTo(other.createdDate);
    }
}

