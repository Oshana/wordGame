package com.oshana.exceptions;

public class DataSourceTypeNotFoundException extends RuntimeException {
    public DataSourceTypeNotFoundException(String dataSourceType) {
        super("Data source type " + dataSourceType + " not found.");
    }
}
