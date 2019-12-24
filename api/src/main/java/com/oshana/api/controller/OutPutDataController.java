vpackage com.oshana.api.controller;

import com.google.gson.Gson;
import com.oshana.api.entity.Level;
import com.oshana.api.entity.Word;
import com.oshana.api.exception.OutPutDataException;
import com.oshana.api.service.LevelService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class OutPutDataController {

        @Autowired
        LevelService levelService;

    @GetMapping("/getAllWords")
    public JSONObject allWords(){

        List<Level> levels = levelService.findAllLevels();
        JSONObject mainObj = new JSONObject();

        for(Level level:levels){
            Set<Word> words = level.getWords();
            ArrayList<String> wordsArray = new ArrayList<String>();
            for(Word word:words){
                wordsArray.add(word.getword());
            }

            JSONObject jo = new JSONObject();
            jo.put("words", wordsArray);
            mainObj.put(level.getLevelNo(), jo);
        }

        JSONObject jo = new JSONObject();
        jo.put("levels", levelService.findAllLevels().size());
        mainObj.put("numberOfLevels", jo);

        try {
            return mainObj;
        }catch (Exception e){
            throw new OutPutDataException(e);
        }
    }

        @GetMapping("/getWords/{levelNo}")
        public JSONObject words(@PathVariable int levelNo){
            Set<Word> setWords = levelService.findLevelByLevelNo(levelNo).getWords();
            String[] words = new String[setWords.size()];
            int i = 0;
            for (Word w: setWords){
                String s = w.getword();
                words[i++] = s;
            }

            Gson gson = new Gson();
            String wordsJson = gson.toJson(words);

            JSONObject wordJsonpObject = new JSONObject ();
            wordJsonpObject.put("words",words);

            try {
                return wordJsonpObject;
            }catch (Exception e){
                throw new OutPutDataException(e);
            }
        }

        @GetMapping("/getNumberOfTotalLevels")
        public int TotalNumberOfLevels(){
            int numberOfLevels = levelService.findAllLevels().size();
            return numberOfLevels;
        }
}
