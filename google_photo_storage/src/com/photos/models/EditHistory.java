package com.photos.models;

import java.io.Serializable;
import java.util.Date;

public class EditHistory implements Serializable {
    private final String description;
    private final Date timestamp;

    public EditHistory(String description) {
        this.description = description;
        this.timestamp = new Date();
    }

    public String getDescription() {
        return description;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
