package com.doczilla.filetask.searcher;

import java.io.File;
import java.util.List;

public interface FileSearcher {
    void findTxtFiles(File folder, List<File> txtFiles);
}
