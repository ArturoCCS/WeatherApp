package com.arturoccs.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.arturoccs.model.WeatherData;
import com.google.gson.Gson;

public class JsonParser {
     private static List<WeatherData> data = new ArrayList<>();

     public static List<WeatherData> jsonToWeatherData(int maxCities) {
         int counter = 0;
         Gson gson = new Gson();
         WeatherData weatherData = new WeatherData();

         try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(JsonParser.class.getResourceAsStream("/assets/data.json")));

             String line = "";

             while ((line = buffer.readLine()) != null && counter < maxCities) {
                 weatherData = gson.fromJson(line, WeatherData.class);
                 weatherData.assignCity();
                 data.add(weatherData);
                 counter++;
             }

             buffer.close();

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }

         return data;
     }
}
