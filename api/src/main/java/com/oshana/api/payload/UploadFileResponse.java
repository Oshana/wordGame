package com.oshana.api.payload;


public class UploadFileResponse {

    private String response;

    public UploadFileResponse(String response) {
        this.response = response;
    }

    public void setResponse(String response) { this.response = response; }

    public String getResponse() {
        return response;
    }
}
