package com.doczilla.filetask.writer;

import com.doczilla.filetask.exception.CustomFileException;

import java.net.MalformedURLException;

public interface Writer {

    void writeToFile(String stringToFile, String pathToFile) throws CustomFileException, MalformedURLException;
}
