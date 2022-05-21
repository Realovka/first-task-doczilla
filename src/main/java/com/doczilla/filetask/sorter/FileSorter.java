package com.doczilla.filetask.sorter;

import java.nio.file.Path;
import java.util.List;

public interface FileSorter {

    List<Path> sortFilesByName(List<Path> files);

}
