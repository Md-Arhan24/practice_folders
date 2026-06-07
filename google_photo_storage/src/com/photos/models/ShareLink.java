package com.photos.models;

import java.io.Serializable;
import java.util.*;

public class ShareLink implements Serializable {

    private String linkId;
    private Photo sharedPhoto;
    private Album sharedAlbum;
    private User createdBy;
    private Date createdDate;
    private Date expiryDate;
    private String permissionLevel; // VIEW / COMMENT / EDIT
    private boolean allowDownload;
    private List<User> allowedUsers;

    // -------------------- Constructors ---------------------

    public ShareLink(String linkId, Photo sharedPhoto, User createdBy) {
        this.linkId = generateUniqueId(linkId);
        this.sharedPhoto = sharedPhoto;
        this.createdBy = createdBy;
        this.createdDate = new Date();
        this.permissionLevel = "VIEW";
        this.allowDownload = false;
        this.allowedUsers = new ArrayList<>();
    }

    public ShareLink(String linkId, Album sharedAlbum, User createdBy) {
        this.linkId = generateUniqueId(linkId);
        this.sharedAlbum = sharedAlbum;
        this.createdBy = createdBy;
        this.createdDate = new Date();
        this.permissionLevel = "VIEW";
        this.allowDownload = false;
        this.allowedUsers = new ArrayList<>();
    }

    // -------------------- Getters / Setters ---------------------

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        if (linkId == null || linkId.isEmpty())
            throw new IllegalArgumentException("Link ID cannot be null/empty");

        this.linkId = linkId;
    }

    public Photo getSharedPhoto() {
        return sharedPhoto;
    }

    public void setSharedPhoto(Photo sharedPhoto) {
        if (sharedPhoto == null)
            throw new IllegalArgumentException("Photo cannot be null");

        this.sharedPhoto = sharedPhoto;
    }

    public Album getSharedAlbum() {
        return sharedAlbum;
    }

    public void setSharedAlbum(Album sharedAlbum) {
        if (sharedAlbum == null)
            throw new IllegalArgumentException("Album cannot be null");

        this.sharedAlbum = sharedAlbum;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        if (createdBy == null)
            throw new IllegalArgumentException("Creator cannot be null");

        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        if (createdDate == null)
            throw new IllegalArgumentException("Invalid timestamp");

        this.createdDate = createdDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        if (expiryDate != null && expiryDate.before(new Date()))
            throw new IllegalArgumentException("Expiry date must be in future");

        this.expiryDate = expiryDate;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        if (!Arrays.asList("VIEW", "COMMENT", "EDIT").contains(permissionLevel))
            throw new IllegalArgumentException("Invalid permission level");

        this.permissionLevel = permissionLevel;
    }

    public boolean isAllowDownload() {
        return allowDownload;
    }

    public void setAllowDownload(boolean allowDownload) {
        this.allowDownload = allowDownload;
    }

    public List<User> getAllowedUsers() {
        return allowedUsers;
    }

    // -------------------- Utility Methods ---------------------

    public boolean isValid() {
        // expired?
        if (expiryDate != null && expiryDate.before(new Date()))
            return false;

        // photo or album removed?
        if (sharedPhoto == null && sharedAlbum == null)
            return false;

        return true;
    }

    public String generateLinkUrl() {
        return "https://photoshare.com/share/" + linkId;
    }

    public void revokeAccess() {
        this.expiryDate = new Date(); // mark as expired NOW
    }

    private String generateUniqueId(String inputId) {
        if (inputId != null && !inputId.isEmpty())
            return inputId;

        return UUID.randomUUID().toString();
    }
}

