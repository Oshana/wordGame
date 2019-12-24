package com.oshana.api.exception.fileContentException;

import com.oshana.api.entity.Level;
import com.oshana.api.payload.UploadFileResponse;
import com.oshana.api.service.LevelService;

import java.util.Arrays;
import java.util.List;

public class FileContentException implements FileContentExceptionInterface {

    public UploadFileResponse FileContentExceptionHandler(LevelService levelService){
        List<Level> levels = levelService.findAllLevels();
        int[] levelCheckArray = new int[levels.size()];
        for (int i=0; i<levels.size();i++){
            levelCheckArray[i] = levels.get(i).getLevelNo();
        }

        Arrays.sort(levelCheckArray);

        if(levelCheckArray[0] != 1 || levelCheckArray[levelCheckArray.length-1] - levelCheckArray[0] != levelCheckArray.length-1){
            if(levelCheckArray[0] != 1){
                return new UploadFileResponse("Words for the Minimum Level (Level 01) is not present  in the Database and also not defined in the uploaded file.");
            }else {
                return new UploadFileResponse("Words for all the Levels from "+levelCheckArray[levelCheckArray.length-1]+" to "+levelCheckArray[0]+" is not defined in the Database and also not defined in the Uploaded File.");
            }
        } else {
            return new UploadFileResponse("File Uploaded Successfully");
        }
    }
}
