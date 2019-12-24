package com.oshana.api.exception.fileContentException;

import com.oshana.api.exception.FileReaderException;

public class FileContentExceptionFactory {
    private FileContentExceptionFactory() {
    }

    public static FileContentExceptionInterface create(){
        try {
            return new FileContentException();
        }catch (Exception e){
            throw new FileReaderException(e);
        }
    }
}
