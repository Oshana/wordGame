package com.oshana.APIConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class APIConnection implements APIConnectionInterface{

    public HashMap<Integer, String[]> sendGetAll() throws Exception {

        final String USER_AGENT = "Mozilla/5.0";

        String url = "http://localhost:8080/getAllWords";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection ) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonObj = new JSONObject(response.toString());
        int numberOfLevels = jsonObj.getJSONObject("numberOfLevels").getInt("levels");
        HashMap<Integer, String[]> hashMapWords = new HashMap<Integer, String[]>();

        for(int i=1; i<numberOfLevels+1; i++){
            JSONObject level = jsonObj.getJSONObject(String.valueOf(i));
            JSONArray arrJson = level.getJSONArray("words");

            String[] words = new String[arrJson.length()];
            for(int j = 0; j < arrJson.length(); j++){
                words[j] = arrJson.getString(j);
            }
            hashMapWords.put(i,words);
        }

        return hashMapWords;
    }

    // HTTP GET request
    public String[] sendGet(int level) throws Exception {

        final String USER_AGENT = "Mozilla/5.0";

        String url = "http://localhost:8080/getWords/"+level;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection ) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonObj = new JSONObject(response.toString());
        JSONArray arrJson = jsonObj.getJSONArray("words");
        String[] words = new String[arrJson.length()];
        for(int i = 0; i < arrJson.length(); i++){
            words[i] = arrJson.getString(i);
        }

        return words;
    }

    public int NumberOfLevels() throws Exception{

        final String USER_AGENT = "Mozilla/5.0";

        String url = "http://localhost:8080/getNumberOfTotalLevels/";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection ) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        int numberOfLevels = Integer.parseInt(response.toString());

        return numberOfLevels;
    }
}
