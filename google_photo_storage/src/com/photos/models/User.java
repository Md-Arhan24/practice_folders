package com.photos.models;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;

public class User implements Serializable {

    private String userId;
    private String username;
    private String email;
    private long storageQuota;      // total storage allowed
    private long usedStorage;       // used storage in bytes
    private Date accountCreated;
    private List<Album> albums;
    private Map<String, ShareLink> sharedLinks;

    public User(String userId, String username, String email, long storageQuota) {
        this.userId = userId;
        this.username = username;
        setEmail(email);
        this.storageQuota = storageQuota;
        this.usedStorage = 0;
        this.accountCreated = new Date();
        this.albums = new ArrayList<>();
        this.sharedLinks = new HashMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        if (userId != null && !userId.trim().isEmpty()) {
            this.userId = userId;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username != null && username.trim().length() > 2) {
            this.username = username;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        }
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", email);
    }

    public long getStorageLimit() {
        return storageQuota;
    }

    /** Alias for UI: storage quota getter used elsewhere */
    public long getStorageQuota() {
        return storageQuota;
    }

    public void setStorageQuota(long storageQuota) {
        if (storageQuota > 0) {
            this.storageQuota = storageQuota;
        }
    }

    public long getUsedStorage() {
        return usedStorage;
    }

    public void setUsedStorage(long usedStorage) {
        if (usedStorage >= 0) {
            this.usedStorage = usedStorage;
        }
    }

    public Date getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(Date accountCreated) {
        if (accountCreated != null) {
            this.accountCreated = accountCreated;
        }
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public Map<String, ShareLink> getSharedLinks() {
        return sharedLinks;
    }

    /** Check if user has enough quota to upload a file */
    public boolean canUpload(long fileSize) {
        return (usedStorage + fileSize) <= storageQuota;
    }

    /** Update storage usage (+ or - delta) */
    public void updateStorageUsage(long delta) {
        long newUsage = usedStorage + delta;
        if (newUsage < 0) newUsage = 0;
        usedStorage = newUsage;
    }

    /** Create a new album for the user */
    public Album createAlbum(String albumName) {
        if (albumName == null || albumName.trim().isEmpty()) return null;

        String albumId = UUID.randomUUID().toString();
        Album album = new Album(albumId, albumName, this);
        albums.add(album);
        return album;
    }

    /** Add or update a share link */
    public void addShareLink(ShareLink link) {
        if (link != null) {
            sharedLinks.put(link.getLinkId(), link);
        }
    }

    /** Remove share link by ID */
    public void removeShareLink(String linkId) {
        if (linkId != null) {
            sharedLinks.remove(linkId);
        }
    }
}

