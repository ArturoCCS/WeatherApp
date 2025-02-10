package com.arturoccs.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.arturoccs.model.Data;

public class DataParser {
    
    public static List<Data> txtToData() throws IOException {
        List<Data> dataList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/assets/data.txt"));
     
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim(); 
            
            String[] values = line.replace("\t", " ").split("\\s+");

            try {
                String city = values[0];
                LocalDate date = LocalDate.parse(values[1].trim());
                long epochDate = date.atStartOfDay(ZoneOffset.UTC).toEpochSecond();

                float lat = Float.parseFloat(values[2].trim());
                float lon = Float.parseFloat(values[3].trim());
                double temperature = Double.parseDouble(values[4].trim());
                double humidity = Double.parseDouble(values[5].trim());
                double windSpeed = Double.parseDouble(values[6].trim());
                double precipitation = Double.parseDouble(values[7].trim());

                Data data = new Data(city, lat, lon, epochDate, temperature, precipitation, windSpeed, humidity);
                dataList.add(data);
            } catch (Exception e) {
                // Handle the exception or log it
            }
        }

        reader.close();
        return dataList;
    }
}
