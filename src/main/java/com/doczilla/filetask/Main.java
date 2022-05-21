package com.doczilla.filetask;

import com.doczilla.filetask.exception.CustomFileException;
import com.doczilla.filetask.reader.Reader;
import com.doczilla.filetask.reader.impl.FileReaderImpl;
import com.doczilla.filetask.searcher.FileSearcher;
import com.doczilla.filetask.searcher.impl.FileSearcherImpl;
import com.doczilla.filetask.sorter.FileSorter;
import com.doczilla.filetask.sorter.impl.FileSorterImpl;
import com.doczilla.filetask.writer.Writer;
import com.doczilla.filetask.writer.impl.WriterImpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;

public class Main {

    private static final String PATH_TO_FOLDER = "/reading";
    private static final String PATH_TO_NEW_FILE = "file.txt";

    public static void main(String[] args) throws CustomFileException, URISyntaxException, IOException {
        FileSearcher fileSearcher = new FileSearcherImpl();
        List<Path> paths = fileSearcher.findTxtFiles(PATH_TO_FOLDER);
        FileSorter fileSorter = new FileSorterImpl();
        List<Path> sortPaths = fileSorter.sortFilesByName(paths);
        Reader reader = new FileReaderImpl();
        String stringToFile = reader.readStrings(sortPaths);
        Writer writer = new WriterImpl();
        writer.writeToFile(stringToFile, PATH_TO_NEW_FILE);
    }
}
