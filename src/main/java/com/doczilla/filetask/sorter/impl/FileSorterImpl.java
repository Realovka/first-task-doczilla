package com.doczilla.filetask.sorter.impl;

import com.doczilla.filetask.sorter.FileSorter;
import com.doczilla.filetask.sorter.comparator.PathComparator;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileSorterImpl implements FileSorter {

    @Override
    public List<Path> sortFilesByName(List<Path> files) {
        return files.stream().sorted(new PathComparator()).collect(Collectors.toList());
    }
}
