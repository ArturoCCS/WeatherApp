package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import model.Data;
import model.WeatherData;

import static utility.Format.*;

public class TxtParser {

    private static List<WeatherData> cities;

    public static void weatherDataToTxt(int maxCities) {
        cities = JsonParser.jsonToWeatherData(maxCities);
        
        try {
            FileWriter file = new FileWriter("src/application/resource/data.txt");

            try (PrintWriter writer = new PrintWriter(file)) {
                for (WeatherData city : cities) {
                    for (Data data : city.getRecords()) {
                        writer.println(formatTxt(data));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
