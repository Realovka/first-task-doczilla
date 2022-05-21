package com.doczilla.filetask;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File folder = new File("f://package");
        List<File> txtFiles = new ArrayList<>();
        findTxtFiles(folder, txtFiles);
        sortFilesByName(txtFiles);

    }

    public static void findTxtFiles(File folder, List<File> txtFiles) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                findTxtFiles(entry, txtFiles);
            } else {
                if (entry.isFile()) {
                 txtFiles.add(entry);
                }
            }
        }
    }

    public static void sortFilesByName(List<File> files) {
        List<File> fileNames = files.stream().sorted().collect(Collectors.toList());
    }
}
