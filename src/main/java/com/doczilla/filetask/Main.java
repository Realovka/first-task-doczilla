package com.doczilla.filetask;

import com.doczilla.filetask.exception.CustomFileException;
import com.doczilla.filetask.reader.Reader;
import com.doczilla.filetask.reader.impl.FileReaderImpl;
import com.doczilla.filetask.searcher.FileSearcher;
import com.doczilla.filetask.searcher.impl.FileSearcherImpl;
import com.doczilla.filetask.sorter.FileSorter;
import com.doczilla.filetask.sorter.impl.FilesFileSorterImpl;
import com.doczilla.filetask.writer.Writer;
import com.doczilla.filetask.writer.impl.WriterImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String PATH_TO_FOLDER = "src//main//resources//reading";
    private static final String PATH_TO_NEW_FILE = "src//main//resources//writing//file.txt";

    public static void main(String[] args) throws CustomFileException {
        File folder = new File(PATH_TO_FOLDER);
        List<File> txtFiles = new ArrayList<>();
        FileSearcher fileSearcher = new FileSearcherImpl();
        fileSearcher.findTxtFiles(folder, txtFiles);
        FileSorter fileSorter = new FilesFileSorterImpl();
        List<File> files = fileSorter.sortFilesByName(txtFiles);
        Reader reader = new FileReaderImpl();
        String stringToFile = reader.readStrings(files);
        Writer writer = new WriterImpl();
        writer.writeToFile(stringToFile, PATH_TO_NEW_FILE);
    }
}
