package com.oshana.api.exception.fileContentException;

import com.oshana.api.payload.UploadFileResponse;
import com.oshana.api.service.LevelService;

public interface FileContentExceptionInterface {
    public UploadFileResponse FileContentExceptionHandler(LevelService levelService);
}
