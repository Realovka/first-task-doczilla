package com.doczilla.filetask.searcher.impl;

import com.doczilla.filetask.searcher.FileSearcher;

import java.io.File;
import java.util.List;

public class FileSearcherImpl implements FileSearcher {
    @Override
    public void findTxtFiles(File folder, List<File> txtFiles) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                findTxtFiles(entry, txtFiles);
            } else {
                txtFiles.add(entry);
            }
        }
    }
}
