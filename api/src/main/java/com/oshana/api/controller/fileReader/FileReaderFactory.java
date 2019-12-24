package com.oshana.api.controller.fileReader;

import com.oshana.api.exception.FileReaderException;

public class FileReaderFactory {
    private FileReaderFactory() {
    }

    public static FileReaderInterface create(){
        try {
            return new FileReaderController();
        }catch (Exception e){
            throw new FileReaderException(e);
        }
    }
}
