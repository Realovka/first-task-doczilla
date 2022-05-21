package com.doczilla.filetask.writer.impl;

import com.doczilla.filetask.exception.CustomFileException;
import com.doczilla.filetask.writer.Writer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void writeToFile(String stringToFile, String pathToFile) throws CustomFileException {
        File file = new File(pathToFile);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(stringToFile);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while writing to " + pathToFile + " file " + e);
            throw new CustomFileException();
        }
        logger.log(Level.INFO, "String to file: " + stringToFile);
    }
}
