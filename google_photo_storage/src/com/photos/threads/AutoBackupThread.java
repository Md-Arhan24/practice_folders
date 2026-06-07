package com.photos.threads;

import com.photos.storage.GooglePhotosPlatform;

import java.io.File;
import java.util.*;

public class AutoBackupThread extends Thread {

    private final GooglePhotosPlatform platform;
    private volatile boolean backupRunning;
    private final Queue<String> backupQueue;
    private final String backupFolder;

    private int completedBackups = 0;
    private int totalBackups = 0;

    public AutoBackupThread(GooglePhotosPlatform platform, String backupFolder) {
        this.platform = platform;
        this.backupFolder = backupFolder;
        this.backupQueue = new LinkedList<>();
        this.backupRunning = true;

        File folder = new File(backupFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        System.out.println("[AutoBackupThread] Initialized. Backup folder: " + backupFolder);
    }

    @Override
    public void run() {
        System.out.println("[AutoBackupThread] Backup service started.");

        while (backupRunning) {
            try {
                synchronized (backupQueue) {
                    if (backupQueue.isEmpty()) {
                        backupQueue.wait(500); // wait for new jobs
                        continue;
                    }

                    String filePath = backupQueue.poll();
                    if (filePath == null) continue;

                    totalBackups++;

                    File file = new File(filePath);
                    if (!file.exists()) {
                        System.err.println("[AutoBackupThread] File not found: " + filePath);
                        continue;
                    }

                    // Simulate backup operation (copy file)
                    File target = new File(backupFolder + "/" + file.getName());
                    java.nio.file.Files.copy(
                            file.toPath(),
                            target.toPath(),
                            java.nio.file.StandardCopyOption.REPLACE_EXISTING
                    );

                    completedBackups++;

                    System.out.println("[AutoBackupThread] Backed up: " + file.getName());
                }

            } catch (Exception e) {
                System.err.println("[AutoBackupThread] Error: " + e.getMessage());
            }
        }

        System.out.println("[AutoBackupThread] Backup service stopped.");
    }

    public void addToBackupQueue(String filePath) {
        File f = new File(filePath);

        if (!f.exists()) {
            System.err.println("[BackupQueue] Ignored — File does not exist: " + filePath);
            return;
        }

        synchronized (backupQueue) {
            backupQueue.offer(filePath);
            backupQueue.notify();
        }

        System.out.println("[BackupQueue] Added to backup: " + filePath);
    }

    public void stopBackup() {
        backupRunning = false;

        synchronized (backupQueue) {
            backupQueue.notifyAll();
        }

        System.out.println("[AutoBackupThread] Requested stop. Finishing remaining tasks...");
    }

    public boolean isBackupRunning() {
        return backupRunning;
    }

    public int getBackupProgress() {
        if (totalBackups == 0) return 0;
        return (completedBackups * 100) / totalBackups;
    }
}

