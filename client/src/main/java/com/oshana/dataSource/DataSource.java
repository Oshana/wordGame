package com.oshana.dataSource;

import com.oshana.APIConnection.APIConnection;
import com.oshana.APIConnection.APIConnectionFactory;
import com.oshana.APIConnection.APIConnectionInterface;

import java.util.HashMap;
import java.util.Random;

public class DataSource implements DataSourceInterface {

    public char[] wordBank(int wordLevel) throws Exception {

        String[] words;
        Random r = new Random();

        APIConnectionInterface apiConnectionInterface = APIConnectionFactory.create();

        words = apiConnectionInterface.sendGetAll().get(wordLevel);

//        words = apiConnectionInterface.sendGet(wordLevel);

        return (words[r.nextInt(words.length)].toUpperCase().toCharArray());

    }
}
