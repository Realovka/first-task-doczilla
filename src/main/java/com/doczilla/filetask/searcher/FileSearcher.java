package com.doczilla.filetask.searcher;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;

public interface FileSearcher {

    List<Path> findTxtFiles(String folder) throws URISyntaxException, IOException;
}
