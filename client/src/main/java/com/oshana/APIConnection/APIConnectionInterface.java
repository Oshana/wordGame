package com.oshana.APIConnection;

import java.util.HashMap;

public interface APIConnectionInterface {
    String[] sendGet(int level) throws Exception;
    HashMap<Integer, String[]> sendGetAll() throws Exception;
    int NumberOfLevels() throws Exception;
}
