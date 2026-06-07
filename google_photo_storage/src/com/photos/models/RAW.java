package com.photos.models;

import com.photos.exceptions.StorageLimitException;

public class RAW extends Photo {

    private String cameraModel;
    private String lensInfo;
    private String isoSetting;
    private String aperture;
    private String shutterSpeed;

    public RAW(String photoId, String fileName, long fileSize, User owner) {
        super(photoId, fileName, fileSize, owner);

        // Default RAW metadata placeholders
        this.cameraModel = "Unknown Camera";
        this.lensInfo = "Unknown Lens";
        this.isoSetting = "ISO 100";
        this.aperture = "f/2.8";
        this.shutterSpeed = "1/100s";
    }

    public String getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(String cameraModel) {
        if (cameraModel != null && !cameraModel.isEmpty()) {
            this.cameraModel = cameraModel;
        }
    }

    public String getLensInfo() {
        return lensInfo;
    }

    public void setLensInfo(String lensInfo) {
        if (lensInfo != null && !lensInfo.isEmpty()) {
            this.lensInfo = lensInfo;
        }
    }

    public String getIsoSetting() {
        return isoSetting;
    }

    public void setIsoSetting(String isoSetting) {
        if (isoSetting != null && isoSetting.toUpperCase().startsWith("ISO")) {
            this.isoSetting = isoSetting;
        }
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        if (aperture != null && aperture.startsWith("f/")) {
            this.aperture = aperture;
        }
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(String shutterSpeed) {
        if (shutterSpeed != null && shutterSpeed.contains("/")) {
            this.shutterSpeed = shutterSpeed;
        }
    }

    @Override
    public String getFormat() {
        return "RAW";
    }

    @Override
    public boolean isEditable() {
        return true; // RAW files always allow non-destructive editing
    }

    @Override
    public void upload() throws StorageLimitException {
        // Use User.canUpload and updateStorageUsage to check & consume quota
        if (owner == null) {
            System.out.println("No owner assigned for RAW file. Skipping upload.");
            return;
        }

        if (!owner.canUpload(this.getSize())) {
            throw new StorageLimitException("Not enough storage to upload RAW file. Required: "
                    + this.getSize() + " bytes");
        }

        System.out.println("Uploading RAW file with full metadata preserved...");
        owner.updateStorageUsage(this.getSize());
    }

    @Override
    public void organize(Album album) {
        album.addPhoto(this);
        System.out.println("RAW file added to album: " + album.getName());
    }

    @Override
    public void edit(String editType, Object parameters) {
        System.out.println("Applying non-destructive RAW edit: " + editType);
        // You can expand this later into a full RAW editor.
    }

    @Override
    public ShareLink share(User... users) {
        ShareLink link = new ShareLink(null, this, owner);
        System.out.println("RAW file shared (auto-conversion to JPEG for preview).");
        return link;
    }

    public void developToJPEG() {
        System.out.println("Converting RAW to JPEG using camera metadata...");
        // Later: return new JPEG(...);
    }

    public void extractMetadata() {
        System.out.println("Extracting RAW camera metadata...");
        // In real apps: parse EXIF using metadata libraries
    }
}
