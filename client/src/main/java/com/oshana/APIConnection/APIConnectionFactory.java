package com.oshana.APIConnection;

import com.oshana.exceptions.APIConnectionErrorException;

public class APIConnectionFactory {

    private APIConnectionFactory() {
    }

    public static APIConnectionInterface create(){
        try {
            return new APIConnection();
        }catch (Exception e){
            throw new APIConnectionErrorException(e);
        }
    }
}
