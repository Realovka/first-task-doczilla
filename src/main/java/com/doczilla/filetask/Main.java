package com.doczilla.filetask;

import com.doczilla.filetask.exception.CustomFileException;
import com.doczilla.filetask.reader.Reader;
import com.doczilla.filetask.reader.impl.FileReaderImpl;
import com.doczilla.filetask.searcher.FileSearcher;
import com.doczilla.filetask.searcher.impl.FileSearcherImpl;
import com.doczilla.filetask.sorter.FileSorter;
import com.doczilla.filetask.sorter.impl.FilesFileSorterImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CustomFileException {
        File folder = new File("f://package");
        List<File> txtFiles = new ArrayList<>();
        FileSearcher fileSearcher = new FileSearcherImpl();
        fileSearcher.findTxtFiles(folder, txtFiles);
        FileSorter fileSorter = new FilesFileSorterImpl();
        List<File> files = fileSorter.sortFilesByName(txtFiles);
        Reader reader = new FileReaderImpl();
        String text = reader.readStrings(files);
    }
}
