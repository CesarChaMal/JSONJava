package com.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.util.Iterator;

import static java.lang.String.*;

public class JsonSimpleReadExample {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
//        String filename = "E:\\IdeaProjects\\JSONJava\\src\\main\\resources\\json_test.json";
        String filename = "json_test.json";

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        ClassLoader classloader = JsonSimpleReadExample.class.getClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(filename);

//        try (Reader reader = new FileReader(filename)) {
        try (Reader reader = new InputStreamReader(inputStream)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
