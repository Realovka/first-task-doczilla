package com.doczilla.filetask.writer.impl;

import com.doczilla.filetask.exception.CustomFileException;
import com.doczilla.filetask.writer.Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class WriterImpl implements Writer {

    @Override
    public void writeToFile(String stringToFile, String pathToFile) throws CustomFileException {
        try {
            URL appLocation = getClass().getProtectionDomain().getCodeSource().getLocation();
            URI folderLocation = new URL(appLocation, pathToFile).toURI();
            File file = new File(folderLocation);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(stringToFile);
            writer.flush();
            writer.close();
        } catch (IOException | URISyntaxException e) {
            throw new CustomFileException();
        }
    }
}
