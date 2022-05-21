package com.doczilla.filetask.searcher.impl;

import com.doczilla.filetask.searcher.FileSearcher;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileSearcherImpl implements FileSearcher {

    @Override
    public List<Path> findTxtFiles(String folder) throws URISyntaxException, IOException {
       List<Path> result;
       String jarPath = getClass().getProtectionDomain()
               .getCodeSource()
               .getLocation()
               .toURI()
               .getPath();
        URI uri = URI.create("jar:file:" + jarPath);

        try (FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
            result = Files.walk(fileSystem.getPath(folder))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        return result;
    }
}
