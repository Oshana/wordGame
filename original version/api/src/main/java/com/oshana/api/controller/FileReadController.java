//package com.oshana.api.controller;
//
//import java.io.*;
//
//public class FileReadController {
//
//    public String Read( file) throws IOException {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
//        StringBuilder stringBuilder = new StringBuilder();
//        char[] buffer = new char[10];
//        while (reader.read(buffer) != -1) {
//            stringBuilder.append(new String(buffer));
//            buffer = new char[10];
//        }
//        reader.close();
//
//        String data = stringBuilder.toString();
//
//        return (stringBuilder.toString());
//    }
//}
