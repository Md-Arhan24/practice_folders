package com.photos.storable;

import com.photos.exceptions.StorageLimitException;
import com.photos.models.Album;
import com.photos.models.ShareLink;
import com.photos.models.User;

public interface Storable {

    /**
     * Upload the file to cloud storage.
     * @throws StorageLimitException if user exceeds quota
     */
    void upload() throws StorageLimitException;

    /**
     * Organize this item into an album.
     * @param album the album to add the item into
     */
    void organize(Album album);

    /**
     * Edit this media item.
     * @param editType type of edit (crop, rotate, filter, etc.)
     * @param parameters edit-specific parameters (size, angle, filter data)
     */
    void edit(String editType, Object parameters);

    /**
     * Share this media item with one or more users.
     * @param users list of users to share with
     * @return a shareable link object
     */
    ShareLink share(User... users);
}
