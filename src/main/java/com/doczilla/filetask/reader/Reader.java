package com.doczilla.filetask.reader;

import com.doczilla.filetask.exception.CustomFileException;

import java.nio.file.Path;
import java.util.List;

public interface Reader {

    String readStrings(List<Path> paths) throws CustomFileException;

}
