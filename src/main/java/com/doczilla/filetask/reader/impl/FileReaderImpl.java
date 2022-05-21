package com.doczilla.filetask.reader.impl;

import com.doczilla.filetask.exception.CustomFileException;
import com.doczilla.filetask.reader.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements Reader {

    @Override
    public String readStrings(List<Path> paths) throws CustomFileException {
        StringBuilder builder = new StringBuilder();
        for (Path item : paths) {
            String text = readStringFromFile(item.toAbsolutePath().toString());
            builder.append(text);
        }
        return builder.toString();
    }

    private String readStringFromFile(String pathToFile) throws CustomFileException {
        String lineFromFile = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(pathToFile)))) {
            while ((lineFromFile = bufferedReader.readLine()) != null) {
                break;
            }
        } catch (IOException e) {
            throw new CustomFileException();
        }
        return lineFromFile;
    }
}
