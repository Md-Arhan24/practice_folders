package com.photos.ui;

import com.photos.models.*;
import com.photos.storage.GooglePhotosPlatform;

import javax.swing.*;
import javax.swing.tree.*;
import java.util.List;

/**
 * Simple album tree showing user's albums.
 */
public class AlbumTree extends JTree {

    private DefaultTreeModel treeModel;
    private final User currentUser;
    private final GooglePhotosPlatform platform;

    public AlbumTree(User currentUser, GooglePhotosPlatform platform) {
        super(new DefaultMutableTreeNode("Albums"));
        this.currentUser = currentUser;
        this.platform = platform;
        this.treeModel = (DefaultTreeModel) getModel();
        refreshTree();
    }

    public void refreshTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(currentUser.getUsername());
        for (Album a : currentUser.getAlbums()) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(a);
            root.add(node);
        }
        treeModel.setRoot(root);
        expandRow(0);
        repaint();
    }

    public void expandAlbum(Album album) {
        // Find node and expand it
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(i);
            if (child.getUserObject().equals(album)) {
                TreePath path = new TreePath(child.getPath());
                expandPath(path);
                setSelectionPath(path);
                return;
            }
        }
    }

    public Album getSelectedAlbum() {
        TreePath p = getSelectionPath();
        if (p == null) return null;
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) p.getLastPathComponent();
        Object obj = node.getUserObject();
        if (obj instanceof Album) return (Album) obj;
        return null;
    }

    public void createNewAlbum(String albumName) {
        Album a = currentUser.createAlbum(albumName);
        refreshTree();
    }
}

