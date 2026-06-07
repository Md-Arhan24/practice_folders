package com.photos.ui;

import com.photos.models.*;
import com.photos.storage.GooglePhotosPlatform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Main application window.
 * The GUI works with an instance of GooglePhotosPlatform and a User.
 */
public class GooglePhotosGUI extends JFrame {
    private List<PhotoSelectionListener> listeners = new ArrayList<>();

    public interface PhotoSelectionListener {
        void onPhotoSelected(Photo photo);
    }

    public void addPhotoSelectionListener(PhotoSelectionListener l) {
        listeners.add(l);
    }


    private final GooglePhotosPlatform platform;
    private final User currentUser;

    private final PhotoGridPanel photoGridPanel;
    private final AlbumTree albumTree;
    private final EditingToolsPanel editingToolsPanel;

    private final JLabel storageInfo = new JLabel("Storage: --");
    private final JButton uploadButton = new JButton("Upload");
    private final JButton shareButton = new JButton("Share");
    private final JButton editButton = new JButton("Edit");

    public GooglePhotosGUI(GooglePhotosPlatform platform, User currentUser) {
        super("Google Photos Storage - Demo");
        this.platform = platform;
        this.currentUser = currentUser;

        // Components
        this.photoGridPanel = new PhotoGridPanel();
        this.albumTree = new AlbumTree(currentUser, platform);
        this.editingToolsPanel = new EditingToolsPanel(platform);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLayout(new BorderLayout(8, 8));
        initializeGUI();
        setupEventListeners();
        refreshPhotoGrid();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeGUI() {
        // Left: Albums + storage
        JPanel leftPane = new JPanel(new BorderLayout(6, 6));
        leftPane.setPreferredSize(new Dimension(260, getHeight()));
        leftPane.add(new JScrollPane(albumTree), BorderLayout.CENTER);

        JPanel leftTop = new JPanel(new BorderLayout());
        leftTop.add(storageInfo, BorderLayout.CENTER);
        leftTop.add(uploadButton, BorderLayout.SOUTH);
        leftPane.add(leftTop, BorderLayout.NORTH);

        // Center: Photo grid
        JPanel center = new JPanel(new BorderLayout(6, 6));
        center.add(new JScrollPane(photoGridPanel), BorderLayout.CENTER);

        // Top toolbar with actions
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(editButton);
        toolBar.add(shareButton);
        center.add(toolBar, BorderLayout.NORTH);

        // Right: Editing tools
        JPanel rightPane = new JPanel(new BorderLayout());
        rightPane.setPreferredSize(new Dimension(300, getHeight()));
        rightPane.add(editingToolsPanel, BorderLayout.CENTER);

        add(leftPane, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        add(rightPane, BorderLayout.EAST);
    }

    private void setupEventListeners() {
        // Upload button: choose files and add as simple Photo objects (JPEG placeholder)
        uploadButton.addActionListener(e -> uploadPhotos());

        // Album click: refresh grid to show only album photos
        albumTree.addTreeSelectionListener(e -> {
            Album selected = albumTree.getSelectedAlbum();
            if (selected != null) {
                List<Photo> photos = new ArrayList<>(selected.getPhotos());
                photoGridPanel.displayPhotos(photos);
            } else {
                refreshPhotoGrid();
            }
        });

        // Photo selection in grid -> show editing tools
        photoGridPanel.addPhotoSelectionListener(photo -> {
            editingToolsPanel.setCurrentPhoto(photo);
            editButton.setEnabled(photo != null && photo.isEditable());
            shareButton.setEnabled(photo != null);
        });

        // Edit button
        editButton.addActionListener(e -> {
            Photo p = photoGridPanel.getSelectedPhoto();
            if (p != null) editingToolsPanel.applyEdit("rotate90", null);
        });

        // Share button
        shareButton.addActionListener(e -> shareSelected());
    }

    public void refreshPhotoGrid() {
        // Display all photos from platform
        Collection<Photo> all = platform.getPhotos().values();
        List<Photo> list = new ArrayList<>(all);
        // sort by capture date if available
        list.sort(Comparator.comparing(Photo::getCaptureDate));
        photoGridPanel.displayPhotos(list);
        updateStorageDisplay();
    }

    private void showEditingTools(Photo photo) {
        editingToolsPanel.setCurrentPhoto(photo);
    }

    private void uploadPhotos() {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int res = chooser.showOpenDialog(this);
        if (res != JFileChooser.APPROVE_OPTION) return;

        File[] files = chooser.getSelectedFiles();
        for (File f : files) {
            // Create a simple JPEG object as placeholder for upload
            String id = UUID.randomUUID().toString();
            long size = f.length();
            Photo p = new com.photos.models.JPEG(id, f.getName(), size, currentUser);
            p.setSourcePath(f.getAbsolutePath());
            try {
                platform.uploadPhoto(p);
                platform.getPhotos().put(id, p); // ensure it is present
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Upload failed: " + ex.getMessage());
            }
        }
        refreshPhotoGrid();
    }

    private void shareSelected() {
        Photo sel = photoGridPanel.getSelectedPhoto();
        if (sel == null) {
            JOptionPane.showMessageDialog(this, "Select a photo to share.");
            return;
        }

        // Create a share link for the selected photo (no recipients)
        ShareLink link = platform.sharePhoto(sel.getPhotoId());
        if (link != null) {
            JOptionPane.showMessageDialog(this, "Share link: " + link.generateLinkUrl());
        } else {
            JOptionPane.showMessageDialog(this, "Could not create share link.");
        }
    }

    public void updateStorageDisplay() {
        long used = currentUser.getUsedStorage();
        long quota = currentUser.getStorageQuota();
        storageInfo.setText(String.format("Storage: %s / %s bytes", used, quota));
    }

    public void showBackupStatus(String status) {
        // For now, show status as tooltip on storage label
        storageInfo.setToolTipText(status);
    }
}
