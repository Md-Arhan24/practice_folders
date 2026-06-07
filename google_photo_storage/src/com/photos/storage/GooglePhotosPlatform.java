package com.photos.storage;

import com.photos.models.*;
import com.photos.exceptions.*;

import java.io.*;
import java.util.*;

public class GooglePhotosPlatform {

    private HashMap<String, Photo> photos;
    private TreeSet<Album> albums;
    private User currentUser;
    private HashMap<String, ShareLink> activeLinks;
    private List<EditHistory> editHistory;

    // -------------------- Constructor --------------------
    public GooglePhotosPlatform() {
        this.photos = new HashMap<>();
        this.albums = new TreeSet<>((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
        this.activeLinks = new HashMap<>();
        this.editHistory = new ArrayList<>();
    }

    // -------------------- File Save / Load --------------------

    public void saveAlbums(String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(albums);
            System.out.println("Albums saved successfully.");
        } catch (Exception e) {
            System.err.println("Error saving albums: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadAlbums(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {

            TreeSet<Album> loaded = (TreeSet<Album>) in.readObject();

            // Rebuild relationships if required
            this.albums = loaded;
            System.out.println("Albums restored successfully.");

        } catch (Exception e) {
            System.err.println("Error loading albums: " + e.getMessage());
        }
    }

    public void saveUserPreferences(String filePath) {
        if (currentUser == null) return;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(currentUser);
            System.out.println("User preferences saved.");
        } catch (Exception e) {
            System.err.println("Error saving user preferences: " + e.getMessage());
        }
    }

    public void loadUserPreferences(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            this.currentUser = (User) in.readObject();
            System.out.println("User preferences loaded.");
        } catch (Exception e) {
            System.err.println("Error loading preferences: " + e.getMessage());
        }
    }

    // -------------------- Core Functions --------------------

    public void uploadPhoto(Photo photo)
            throws StorageLimitException, FormatNotSupportedException {

        if (photo == null)
            throw new IllegalArgumentException("Photo cannot be null");

        // validate format
        if (!photo.getFormat().equalsIgnoreCase("JPEG")
                && !photo.getFormat().equalsIgnoreCase("PNG"))
            throw new FormatNotSupportedException("Format not supported: " + photo.getFormat());

        // check storage quota
        if (currentUser != null &&
                currentUser.getUsedStorage() + photo.getSize() > currentUser.getStorageLimit())
            throw new StorageLimitException("Storage limit exceeded!");

        // add to main collection (use Photo ID)
        photos.put(photo.getPhotoId(), photo);

        // track user storage (update user's used storage)
        if (currentUser != null)
            currentUser.updateStorageUsage(photo.getSize());
    }

    public void createAlbum(String albumName) {
        if (albumName == null || albumName.isEmpty())
            throw new IllegalArgumentException("Album name cannot be empty");

        // Create album with generated id and current user as owner
        String albumId = java.util.UUID.randomUUID().toString();
        Album newAlbum = new Album(albumId, albumName, currentUser);
        albums.add(newAlbum);
    }

    public ShareLink sharePhoto(String photoId, User... users) {
        Photo photo = photos.get(photoId);

        if (photo == null) {
            System.err.println("Photo not found: " + photoId);
            return null;
        }

        ShareLink link = new ShareLink(null, photo, currentUser);

        // allow specific user access
        if (users != null) {
            for (User u : users)
                link.getAllowedUsers().add(u);
        }

        activeLinks.put(link.getLinkId(), link);
        return link;
    }

    public ShareLink shareAlbum(String albumName, User... users) {
        Album target = null;

        for (Album a : albums) {
            if (a.getName().equalsIgnoreCase(albumName)) {
                target = a;
                break;
            }
        }

        if (target == null) {
            System.err.println("Album not found: " + albumName);
            return null;
        }

        ShareLink link = new ShareLink(null, target, currentUser);

        if (users != null) {
            for (User u : users)
                link.getAllowedUsers().add(u);
        }

        activeLinks.put(link.getLinkId(), link);
        return link;
    }

    // -------------------- Getters --------------------
    public HashMap<String, Photo> getPhotos() {
        return photos;
    }

    public TreeSet<Album> getAlbums() {
        return albums;
    }
}
