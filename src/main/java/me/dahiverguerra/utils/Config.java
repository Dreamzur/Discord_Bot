package me.dahiverguerra.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {

    private static final Dotenv dotenv = Dotenv.load();

    //gets the token from the .env file
    public static String get(String key){
        return dotenv.get(key);
    }
}
