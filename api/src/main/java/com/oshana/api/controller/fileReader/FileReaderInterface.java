package com.oshana.api.controller.fileReader;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileReaderInterface {
    String readFile(MultipartFile file) throws IOException;
}
