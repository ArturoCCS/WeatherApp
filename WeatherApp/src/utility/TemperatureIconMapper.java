package utility;

import java.util.TreeMap;

public class TemperatureIconMapper {

    private static final TreeMap<Double, String> fahrenheitRanges = new TreeMap<>();
    private static final TreeMap<Double, String> celsiusRanges = new TreeMap<>();
    private static final TreeMap<Double, String> kelvinRanges = new TreeMap<>();

    static {
        fahrenheitRanges.put(32.0, "icons/snowflake.png"); 
        fahrenheitRanges.put(50.0, "icons/cold_wind.png"); 
        fahrenheitRanges.put(68.0, "icons/partly_cloudy.png"); 
        fahrenheitRanges.put(86.0, "icons/sunny.png"); 
        fahrenheitRanges.put(104.0, "icons/sunny.png"); 
        fahrenheitRanges.put(Double.MAX_VALUE, "icons/extreme_heat.png"); 

        celsiusRanges.put(0.0, "icons/snowflake.png"); 
        celsiusRanges.put(10.0, "icons/cold_wind.png"); 
        celsiusRanges.put(20.0, "icons/partly_cloudy.png"); 
        celsiusRanges.put(30.0, "icons/sunny.png"); 
        celsiusRanges.put(40.0, "icons/sunny.png"); 
        celsiusRanges.put(Double.MAX_VALUE, "icons/extreme_heat.png"); 

        kelvinRanges.put(240.0, "icons/snowflake.png"); 
        kelvinRanges.put(273.0, "icons/cold_wind.png"); 
        kelvinRanges.put(300.0, "icons/partly_cloudy.png"); 
        kelvinRanges.put(320.0, "icons/sunny.png"); 
        kelvinRanges.put(Double.MAX_VALUE, "icons/extreme_heat.png"); 
    }
    
    public static String getIconForTemperature(double temperature, String scale) {
        if (scale.equalsIgnoreCase("Fahrenheit")) {
            return getIconFromRanges(temperature, fahrenheitRanges);
        } else if (scale.equalsIgnoreCase("Celsius")) {
            return getIconFromRanges(temperature, celsiusRanges);
        } else if (scale.equalsIgnoreCase("Kelvin")) {
            return getIconFromRanges(temperature, kelvinRanges);
        } else {
            throw new IllegalArgumentException("Unknown temperature scale: " + scale);
        }
    }
    
    private static String getIconFromRanges(double temperature, TreeMap<Double, String> ranges) {
        
    	
        for (Double key : ranges.descendingKeySet()) {
            if (temperature >= key) {
                return ranges.get(key); 
            }
        }
        return "icons/extreme_heat.jpg"; 
    }
}
