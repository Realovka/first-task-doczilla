package com.doczilla.filetask.reader.impl;

import com.doczilla.filetask.exception.CustomFileException;
import com.doczilla.filetask.reader.Reader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileReaderImpl implements Reader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String readStrings(List<File> files) throws CustomFileException {
        StringBuilder builder = new StringBuilder();
        for (File item : files) {
            String text = readStringFromFile(item.getPath());
            builder.append(text);
        }
        return builder.toString();
    }

    private String readStringFromFile(String pathToFile) throws CustomFileException {
        String lineFromFile = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            while ((lineFromFile = bufferedReader.readLine()) != null) {
                break;
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "File can't be open");
            throw new CustomFileException();
        }
        logger.log(Level.INFO, "String from file: " + lineFromFile);
        return lineFromFile;
    }
}
