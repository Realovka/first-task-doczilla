package com.doczilla.filetask.sorter.comparator;

import java.nio.file.Path;
import java.util.Comparator;

public class PathComparator implements Comparator<Path> {

    @Override
    public int compare(Path firstPath, Path secondPath) {

        return firstPath.getFileName().compareTo(secondPath.getFileName());
    }
}
