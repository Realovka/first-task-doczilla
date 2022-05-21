package com.doczilla.filetask.sorter.impl;

import com.doczilla.filetask.sorter.FileSorter;
import com.doczilla.filetask.sorter.comparator.FileComparator;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FilesFileSorterImpl implements FileSorter {

    @Override
    public List<File> sortFilesByName(List<File> files) {
        return files.stream().sorted(new FileComparator()).collect(Collectors.toList());
    }
}
