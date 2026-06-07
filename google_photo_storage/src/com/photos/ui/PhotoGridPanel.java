package com.photos.ui;

import com.photos.models.Photo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Simple photo grid — shows fileName and basic info.
 * Fires selection events to listeners.
 */
public class PhotoGridPanel extends JPanel {

    private List<Photo> displayedPhotos = new ArrayList<>();
    private Photo selectedPhoto;
    private int thumbnailSize = 120;

    private final List<Consumer<Photo>> selectionListeners = new ArrayList<>();

    public PhotoGridPanel() {
        setLayout(new WrapLayout(FlowLayout.LEFT, 8, 8));
        setBackground(Color.WHITE);
    }

    public void displayPhotos(List<Photo> photos) {
        this.displayedPhotos = photos != null ? photos : new ArrayList<>();
        removeAll();

        for (Photo p : displayedPhotos) {
            JPanel card = createPhotoCard(p);
            add(card);
        }

        revalidate();
        repaint();

        // reset selection
        setSelectedPhoto(null);
    }

    private JPanel createPhotoCard(Photo p) {
        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(thumbnailSize, thumbnailSize + 30));
        card.setBorder(new LineBorder(Color.GRAY, 1));
        card.setBackground(Color.WHITE);

        // Try to load image thumbnail from sourcePath; fall back to placeholder icon
        JLabel icon;
        BufferedImage img = null;
        try {
            String path = p.getSourcePath();
            if (path != null && !path.isEmpty()) {
                img = ImageIO.read(new java.io.File(path));
            }
        } catch (Exception ex) {
            img = null;
        }

        if (img != null) {
            // scale to thumbnail size while preserving aspect
            int w = img.getWidth();
            int h = img.getHeight();
            float scale = Math.min((float)thumbnailSize / w, (float)thumbnailSize / h);
            int tw = Math.max(1, Math.round(w * scale));
            int th = Math.max(1, Math.round(h * scale));
            Image scaled = img.getScaledInstance(tw, th, Image.SCALE_SMOOTH);
            icon = new JLabel(new ImageIcon(scaled), SwingConstants.CENTER);
            icon.setPreferredSize(new Dimension(thumbnailSize, thumbnailSize));
        } else {
            // Placeholder icon (file initial)
            icon = new JLabel(getInitialIcon(p.getFileName()), SwingConstants.CENTER);
            icon.setPreferredSize(new Dimension(thumbnailSize, thumbnailSize));
            icon.setFont(icon.getFont().deriveFont(28f));
        }

        card.add(icon, BorderLayout.CENTER);

        JLabel label = new JLabel("<html><center>" + p.getFileName() + "<br/>" + p.getSize() + " bytes</center></html>", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(11f));
        card.add(label, BorderLayout.SOUTH);

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setSelectedPhoto(p);
            }
        });

        return card;
    }

    private Icon getInitialIcon(String name) {
        String s = (name == null || name.isEmpty()) ? "?" : name.substring(0, 1).toUpperCase();
        BufferedImageBadge badge = new BufferedImageBadge(s, thumbnailSize, thumbnailSize);
        return new ImageIcon(badge.getImage());
    }

    public void setThumbnailSize(int size) {
        if (size > 40) this.thumbnailSize = size;
    }

    public Photo getSelectedPhoto() {
        return selectedPhoto;
    }

    public void setSelectedPhoto(Photo photo) {
        this.selectedPhoto = photo;
        // notify listeners
        for (Consumer<Photo> c : selectionListeners) c.accept(photo);
        repaint();
    }

    public void filterPhotos(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            displayPhotos(displayedPhotos);
            return;
        }
        String q = searchTerm.toLowerCase();
        displayPhotos(displayedPhotos.stream().filter(p ->
                p.getFileName().toLowerCase().contains(q) ||
                p.getTags().toString().toLowerCase().contains(q)
        ).toList());
    }

    public void addPhotoSelectionListener(Consumer<Photo> listener) {
        selectionListeners.add(listener);
    }
}
// Helper class — draws a simple colored badge with a character
class BufferedImageBadge {
    private final int w, h;
    private final String text;

    BufferedImageBadge(String text, int w, int h) {
        this.text = text;
        this.w = w;
        this.h = h;
    }

    public java.awt.image.BufferedImage getImage() {
        java.awt.image.BufferedImage bi = new java.awt.image.BufferedImage(w, h, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        g.setColor(new Color(230,230,250));
        g.fillRect(0,0,w,h);
        g.setColor(new Color(80,80,160));
        g.setFont(new Font("Dialog", Font.BOLD, Math.max(24, w/4)));
        FontMetrics fm = g.getFontMetrics();
        int tx = (w - fm.stringWidth(text)) / 2;
        int ty = (h - fm.getHeight()) / 2 + fm.getAscent();
        g.drawString(text, tx, ty);
        g.dispose();
        return bi;
    }
}
