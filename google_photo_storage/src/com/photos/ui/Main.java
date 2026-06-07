package com.photos.ui;

import com.photos.models.*;
import com.photos.storage.GooglePhotosPlatform;
import com.photos.ui.GooglePhotosGUI;

public class Main {
    public static void main(String[] args) {
        // create demoher user and platform
        User demo = new User(java.util.UUID.randomUUID().toString(), "demo_user", "demo@example.com", 1_000_000_000L);
        GooglePhotosPlatform platform = new GooglePhotosPlatform();

        // add some demo photos
        Photo p1 = new com.photos.models.JPEG(java.util.UUID.randomUUID().toString(), "beach.jpg", 150_000, demo);
        Photo p2 = new com.photos.models.PNG(java.util.UUID.randomUUID().toString(), "logo.png", 40_000, demo);
        platform.getPhotos().put(p1.getPhotoId(), p1);
        platform.getPhotos().put(p2.getPhotoId(), p2);

        // add a demo album
        demo.createAlbum("Vacations");

        javax.swing.SwingUtilities.invokeLater(() -> {
            new GooglePhotosGUI(platform, demo);
        });
    }
}
