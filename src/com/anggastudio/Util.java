package com.anggastudio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

public class Util {

    public static <T> T stringToClass(String stringToConvert, Class<T> classType) {
        try {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(stringToConvert, classType);
        } catch (Exception e) {
            return null;
        }
    }

    public static String classToString(Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(obj);
        } catch (java.util.ConcurrentModificationException exception) {
            return new Gson().toJson(obj);
        }
    }

    public static <T> T stringToClass(String stringToConvert, Class<T> classType, JsonDeserializer<T> jsonDeserializer) {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(classType, jsonDeserializer)
                    .create();
            return gson.fromJson(stringToConvert, classType);
        } catch (Exception e) {
            return null;
        }
    }
}
