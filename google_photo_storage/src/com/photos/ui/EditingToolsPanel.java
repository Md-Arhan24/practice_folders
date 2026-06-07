package com.photos.ui;

import com.photos.models.*;
import com.photos.storage.GooglePhotosPlatform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Basic editing tools panel (simulates edits and stores EditHistory entries).
 */
public class EditingToolsPanel extends JPanel {

    private Photo currentPhoto;
    private final List<EditHistory> editStack = new ArrayList<>();
    private final GooglePhotosPlatform platform;

    private final JLabel photoLabel = new JLabel("No photo selected");
    private final JButton rotateButton = new JButton("Rotate 90°");
    private final JButton undoButton = new JButton("Undo");
    private final JButton saveButton = new JButton("Save edits");

    public EditingToolsPanel(GooglePhotosPlatform platform) {
        this.platform = platform;
        setLayout(new BorderLayout(6,6));
        JPanel top = new JPanel(new GridLayout(0,1,4,4));
        top.add(photoLabel);
        add(top, BorderLayout.NORTH);

        JPanel controls = new JPanel(new GridLayout(0,1,4,4));
        controls.add(rotateButton);
        controls.add(undoButton);
        controls.add(saveButton);
        add(controls, BorderLayout.CENTER);

        rotateButton.addActionListener(this::onRotate);
        undoButton.addActionListener(e -> undoEdit());
        saveButton.addActionListener(e -> saveEdits());

        setBorder(BorderFactory.createTitledBorder("Editing Tools"));
        updateButtons();
    }

    public void setCurrentPhoto(Photo photo) {
        this.currentPhoto = photo;
        editStack.clear();
        if (photo != null) {
            photoLabel.setText("Editing: " + photo.getFileName());
        } else {
            photoLabel.setText("No photo selected");
        }
        updateButtons();
    }

    public void applyEdit(String editType, Object parameters) {
        if (currentPhoto == null) return;
        // Simulate an edit by recording an EditHistory object
        EditHistory eh = new EditHistory(editType + " applied");
        editStack.add(eh);
        currentPhoto.edit(editType, parameters);
        updateButtons();
    }

    public void undoEdit() {
        if (editStack.isEmpty()) return;
        // remove last
        EditHistory removed = editStack.remove(editStack.size() - 1);
        // In a real app we'd revert the photo; here, we record the undo in history
        System.out.println("Undo: " + removed.getDescription());
        updateButtons();
    }

    public void saveEdits() {
        if (currentPhoto == null) return;
        // Persist edits into photo's history for now
        for (EditHistory h : editStack) {
            // You may store these into photo.getEdits() in your real model
            System.out.println("Saved edit: " + h.getDescription());
        }
        editStack.clear();
        updateButtons();
    }

    public void resetEdits() {
        editStack.clear();
        updateButtons();
    }

    private void onRotate(ActionEvent e) {
        applyEdit("rotate90", null);
    }

    private void updateButtons() {
        boolean hasPhoto = currentPhoto != null;
        rotateButton.setEnabled(hasPhoto && currentPhoto.isEditable());
        undoButton.setEnabled(!editStack.isEmpty());
        saveButton.setEnabled(!editStack.isEmpty());
    }
}
