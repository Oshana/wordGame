package com.oshana.api.controller;

import com.oshana.api.controller.fileReader.FileReaderFactory;
import com.oshana.api.controller.fileReader.FileReaderInterface;
import com.oshana.api.exception.fileContentException.FileContentExceptionFactory;
import com.oshana.api.exception.fileContentException.FileContentExceptionInterface;
import com.oshana.api.payload.UploadFileResponse;
import com.oshana.api.service.ClassifierService;
import com.oshana.api.service.FileStorageService;
import com.oshana.api.service.LevelService;
import com.oshana.api.util.LevelAssignLogicStrategy;
import com.oshana.api.util.WordLengthLevelAssignStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private LevelService levelService;
    @Autowired
    private ClassifierService classifierService;

    public FileController() {
        LevelAssignLogicStrategy levelAssignLogicStrategy = new WordLengthLevelAssignStrategy();
        this.classifierService = new ClassifierService(levelAssignLogicStrategy);
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException{

        //store the uploaded file for the future use
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        FileReaderInterface fileReaderInterface = FileReaderFactory.create();
        classifierService.classifier(fileReaderInterface.readFile(file));

        FileContentExceptionInterface fileContentExceptionInterface = FileContentExceptionFactory.create();
        return fileContentExceptionInterface.FileContentExceptionHandler(levelService);
    }
}
