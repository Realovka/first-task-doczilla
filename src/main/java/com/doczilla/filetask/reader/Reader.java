package com.doczilla.filetask.reader;

import com.doczilla.filetask.exception.CustomFileException;

import java.io.File;
import java.util.List;

public interface Reader {
    String readStrings(List<File> files) throws CustomFileException;
}
