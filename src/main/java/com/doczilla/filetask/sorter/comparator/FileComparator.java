package com.doczilla.filetask.sorter.comparator;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File> {
    @Override
    public int compare(File firstFile, File secondFile) {
       return firstFile.getName().compareTo(secondFile.getName());
    }
}
