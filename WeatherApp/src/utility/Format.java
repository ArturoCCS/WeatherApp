package utility;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import model.Data;

public class Format {

    public static String formatTxt(Data data) {

        String cityName = data.getCity().getName();
        String registrationDate = formatDate(data.getDt());
        String latitude = String.valueOf(data.getCity().getCoord().getLat());
        String longitude = String.valueOf(data.getCity().getCoord().getLon());
        String averageTemperature = String.valueOf(data.getTemp().getDay());
        String humidity = String.valueOf(data.getHumidity());
        String windSpeed = String.valueOf(data.getSpeed());
        String accumulatedPrecipitation = String.valueOf(data.getRain());

        return cityName +
                " " + registrationDate +
                " " + latitude +
                " " + longitude +
                " " + averageTemperature +
                " " + humidity +
                " " + windSpeed +
                " " + accumulatedPrecipitation;

    }

    public static String formatDate(long dt) {
        Instant instant = Instant.ofEpochSecond(dt);
        LocalDate date = instant.atZone(ZoneOffset.UTC).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}
