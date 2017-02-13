package com.fimelab.reman.utils;

import java.io.File;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class FileManager {
    private static File storageDir;

    static {
        storageDir = new File("apps/");
    }

    public FileManager() {

    }

    public Set<File> listAllFilesInDirectory() {
        Set<File> fileSet = new TreeSet<>();
        File[] files = storageDir.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.getName().endsWith(".zip")) {
                    fileSet.add(f);
                }
            }
        }

        return fileSet;
    }

    public Set<File> listAllFilesInArchive() {
        Set<File> fileset = new TreeSet<>();
        File archiveDir = new File(storageDir.getAbsolutePath() + File.separator + "archive");
        File[] files = archiveDir.listFiles();

        if (files != null) {
            Collections.addAll(fileset, files);
        }

        return fileset;
    }

    public Set<File> listAllFiles() {
        Set<File> regularFiles = listAllFilesInDirectory();
        Set<File> archivedFiles = listAllFilesInArchive();

        Set<File> fileset = new TreeSet<>();
        fileset.addAll(archivedFiles);
        fileset.addAll(regularFiles);

        return fileset;
    }
}
