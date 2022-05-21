package com.doczilla.filetask.sorter;

import java.io.File;
import java.util.List;

public interface FileSorter {

    List<File> sortFilesByName(List<File> files);

}
