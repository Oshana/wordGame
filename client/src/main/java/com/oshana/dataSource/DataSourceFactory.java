package com.oshana.dataSource;

import com.oshana.exceptions.DataSourceTypeNotFoundException;

public class DataSourceFactory {

    private DataSourceFactory() {
    }

    public static DataSourceInterface create(DataSourceType type){
        if(type == DataSourceType.API_DATA){
            return new DataSource();
        }else{
            throw new DataSourceTypeNotFoundException(type.toString());
        }
    }
}
