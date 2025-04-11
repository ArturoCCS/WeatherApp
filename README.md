# Meteorological Data Analysis for Climate Research

This project is designed to manage and analyze large volumes of meteorological data to support research on climate change and extreme weather phenomena. The data comes from globally distributed weather stations and covers key variables such as temperature, humidity, wind speed, and precipitation.

## Features

- **JSON to Java Object Conversion:** Converts meteorological records from JSON format into Java objects, facilitating processing and analysis.
- **Text File (TXT) Storage:** Processed data is efficiently stored in text files, optimizing reading and manipulation.
- **Data Analysis:** The system facilitates the analysis of large volumes of data to identify long-term trends, generate detailed reports, and create predictive climate models.

## Installation

### Requirements

- **Java SE 22**
- **Maven** for dependency management.

The necessary dependencies (Gson, JavaFX) are already included in the `pom.xml`. Just ensure you have Maven installed and properly configured in your development environment.

### Installation Steps

1. Clone this repository:

```bash   
$ git clone https://github.com/ArturoCCS/WeatherApp.git
```

### Run
 
```bash
cd WeatherApp
```
```bash  
mvn clean install
```
```bash
mvn javafx:run
```

## Usage

To use the project, simply pass your JSON files with meteorological data through the conversion system. The data will be processed and stored in text files, which can be analyzed to generate reports or feed predictive models.

### Example Input (JSON)

```json
{"city":{"id":707860,"name":"Hurzuf","country":"UA","coord":{"lon":34.283333,"lat":44.549999}},"time":1489458708,"data":[{"dt":1489395600,"temp":{"day":285.33,"min":277.97,"max":285.33,"night":279.36,"eve":280.94,"morn":277.97},"pressure":1006.85,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":3.2,"deg":44,"clouds":53,"rain":0.43,"uvi":3.09},{"dt":1489482000,"temp":{"day":281.66,"min":277.1,"max":281.9,"night":277.1,"eve":279.71,"morn":277.28},"pressure":991.08,"humidity":83,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":4.13,"deg":60,"clouds":76,"rain":0.95,"uvi":3.19},{"dt":1489568400,"temp":{"day":278.97,"min":275.65,"max":279.95,"night":275.65,"eve":279.13,"morn":275.93},"pressure":993.96,"humidity":94,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":3.76,"deg":41,"clouds":80,"rain":0.25,"uvi":3.01},{"dt":1489654800,"temp":{"day":279.79,"min":276.01,"max":279.79,"night":276.01,"eve":278.73,"morn":276.86},"pressure":990.04,"humidity":97,"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"speed":3.51,"deg":244,"clouds":92,"rain":3.17,"uvi":3.2},{"dt":1489741200,"temp":{"day":280.8,"min":272.36,"max":280.8,"night":272.36,"eve":276.71,"morn":277.43},"pressure":1012.47,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":2.05,"deg":317,"clouds":30,"rain":0.33,"uvi":2.79},{"dt":1489827600,"temp":{"day":281.5,"min":272.69,"max":281.5,"night":272.69,"eve":276.26,"morn":276.57},"pressure":1010.58,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":2.29,"deg":242,"clouds":21,"rain":0.48,"uvi":3.36},{"dt":1489914000,"temp":{"day":283.87,"min":273.73,"max":283.87,"night":273.73,"eve":277.1,"morn":277.3},"pressure":1008.61,"humidity":0,"weather":[{"id":800,"main":"Clear","description":"sky is clear","icon":"01d"}],"speed":2.27,"deg":166,"clouds":1,"uvi":3.3},{"dt":1490000400,"temp":{"day":285.22,"min":278.05,"max":285.22,"night":278.85,"eve":280.1,"morn":278.05},"pressure":1002.01,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":4.36,"deg":154,"clouds":34,"rain":1.9,"uvi":3.3},{"dt":1490086800,"temp":{"day":284.12,"min":279.07,"max":284.12,"night":279.07,"eve":280.24,"morn":280.81},"pressure":995.72,"humidity":0,"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],"speed":1.86,"deg":289,"clouds":52,"rain":14.44,"uvi":3.3},{"dt":1490173200,"temp":{"day":283.15,"min":277.4,"max":283.15,"night":277.4,"eve":278.56,"morn":278.69},"pressure":1013.61,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":3.34,"deg":279,"clouds":5,"rain":0.32,"uvi":3.3},{"dt":1490259600,"temp":{"day":283.16,"min":273.3,"max":283.16,"night":273.3,"eve":277.97,"morn":279.78},"pressure":1013.07,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":2.15,"deg":276,"clouds":14,"rain":0.38,"uvi":3.3},{"dt":1490346000,"temp":{"day":282.89,"min":275.36,"max":282.89,"night":275.36,"eve":279.01,"morn":276.61},"pressure":1013.2,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":2,"deg":65,"clouds":68,"uvi":3.3},{"dt":1490432400,"temp":{"day":286.7,"min":278.31,"max":286.7,"night":278.44,"eve":281.22,"morn":278.31},"pressure":1008.32,"humidity":0,"weather":[{"id":800,"main":"Clear","description":"sky is clear","icon":"01d"}],"speed":3.8,"deg":58,"clouds":5,"uvi":3.3},{"dt":1490518800,"temp":{"day":286.07,"min":279.97,"max":286.07,"night":280.45,"eve":282.58,"morn":279.97},"pressure":1003.89,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":3.09,"deg":51,"clouds":67,"rain":2.54,"uvi":3.3},{"dt":1490605200,"temp":{"day":284.9,"min":279.04,"max":284.9,"night":279.04,"eve":281.56,"morn":281.65},"pressure":1006.67,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":2.74,"deg":253,"clouds":76,"rain":0.85,"uvi":3.3},{"dt":1490691600,"temp":{"day":287.83,"min":279.65,"max":287.83,"night":279.65,"eve":283.6,"morn":280.4},"pressure":1016.53,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":2.83,"deg":170,"clouds":32,"rain":0.73,"uvi":3.3},{"dt":1490778000,"temp":{"day":279.65,"min":279.65,"max":279.65,"night":279.65,"eve":279.65,"morn":279.65},"pressure":1019.41,"humidity":0,"weather":[{"id":800,"main":"Clear","description":"sky is clear","icon":"01ddd"}],"speed":2.04,"deg":113,"clouds":7,"uvi":3.3}]}
```


This is the format of the `data.json` file for the different `city` objects. However, the Java class only collects the following data:

```json
{
  "city": {
    "name": "Hurzuf",
    "coord": {
      "lon": 34.283333,
      "lat": 44.549999
    }
  },
  "data": [
    {
      "dt": 1489395600,
      "temp": {
        "day": 285.33
      },
      "speed": 3.2,
      "humidity": 0,
      "rain": 0.43
    },
    {
      "dt": 1489482000,
      "temp": {
        "day": 281.66
      },
      "speed": 4.13,
      "humidity": 83,
      "rain": 0.95
    },
    {
      "dt": 1489568400,
      "temp": {
        "day": 278.97
      },
      "speed": 3.76,
      "humidity": 94,
      "rain": 0.25
    },
    {
      "dt": 1489654800,
      "temp": {
        "day": 279.79
      },
      "speed": 3.51,
      "humidity": 97,
      "rain": 3.17
    },
    {
      "dt": 1489741200,
      "temp": {
        "day": 280.8
      },
      "speed": 2.05,
      "humidity": 0,
      "rain": 0.33
    },
    {
      "dt": 1489827600,
      "temp": {
        "day": 281.5
      },
      "speed": 2.29,
      "humidity": 0,
      "rain": 0.48
    },
    {
      "dt": 1489914000,
      "temp": {
        "day": 283.87
      },
      "speed": 2.27,
      "humidity": 0,
      "rain": 0
    },
    {
      "dt": 1490000400,
      "temp": {
        "day": 285.22
      },
      "speed": 4.36,
      "humidity": 0,
      "rain": 1.9
    },
    {
      "dt": 1490086800,
      "temp": {
        "day": 284.12
      },
      "speed": 1.86,
      "humidity": 0,
      "rain": 14.44
    },
    {
      "dt": 1490173200,
      "temp": {
        "day": 283.15
      },
      "speed": 3.34,
      "humidity": 0,
      "rain": 0.32
    }
  ]
}

```

The project is based on this format and data, but you can modify the Java classes to handle custom JSON files tailored to your needs, such as store inventory, various articles, or any information you wish to manage. Since the variable names and types match the JSON format, customization is straightforward for your specific requirements or creativity.



## Application Functionality

### Demo Video

https://github.com/user-attachments/assets/c034841e-2d8c-45be-85f8-2515a3ba3045

