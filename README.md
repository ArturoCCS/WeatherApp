# Meteorological Data Analysis for Climate Research

This project is designed to manage and analyze large volumes of meteorological data to support research on climate change and extreme weather phenomena. The data comes from globally distributed weather stations and covers key variables such as temperature, humidity, wind speed, and precipitation.

## Features

- **JSON to Java Object Conversion:** Converts meteorological records from JSON format into Java objects, facilitating processing and analysis.
- **Text File (TXT) Storage:** Processed data is efficiently stored in text files, optimizing reading and manipulation.
- **Data Analysis:** The system facilitates the analysis of large volumes of data to identify long-term trends, generate detailed reports, and create predictive climate models.

## Installation

### Requirements

- Necessary library for JSON to Java object conversion (`Gson`).  
    [Gson Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.11.0)
    
- Usage of (`JavaFX`).  
    [JavaFX - Gluon](https://gluonhq.com/products/javafx/)
	
	- Add the libraries to the Classpath: **Add External JARs**
	![Pasted image 20250115190639](https://github.com/user-attachments/assets/cc00ab06-efe4-4648-bd1f-68bb0b2a36a5)
	![Pasted image 20250115190900](https://github.com/user-attachments/assets/3e246931-1984-44b9-8de7-0c4e15f14155)
	

### Note

- Using **Java SE 22**
- Using **Eclipse IDE 2022**, due to compatibility with the (e(fx)clipse 3.8.0) plugin.


### Installation Steps

#### Using Git Bash

1. Clone this repository:

```bash   
$ git init
```
2. Add the repository link:

 ```bash 
   $ git clone https://github.com/ArturoCCS/WeatherApp.git
```

#### Using Eclipse

1. Import the project into Eclipse:
    ![Pasted image 20250115183602](https://github.com/user-attachments/assets/2859b7e6-4670-4c6e-9fd9-541e46bf2e4b)
    ![Pasted image 20250115183638](https://github.com/user-attachments/assets/fab8c9d8-e850-48bd-bc30-3c7e5e5ecf5d)
    ![Pasted image 20250115183706](https://github.com/user-attachments/assets/61beaa95-995e-48c3-86e5-582e4fc25f5d)
    ![Pasted image 20250115183908](https://github.com/user-attachments/assets/fb5b87df-18f8-4a9f-9fad-d428d8032686)
    ![Pasted image 20250115183941](https://github.com/user-attachments/assets/1a5be4c0-32e0-43fc-b117-dea3fc80a67b)

3. Select a directory to save the project.
	
	![Pasted image 20250115184015](https://github.com/user-attachments/assets/78850749-6545-4976-bddf-8061cc46ccd3)



### Execution Steps (Eclipse)

1. Once installed, select the **Main** class:
    ![Pasted image 20250115184731](https://github.com/user-attachments/assets/8485825d-412f-4b88-b1ed-796998460f9b)
2. Open **Run Configurations**:
    ![Pasted image 20250115184827](https://github.com/user-attachments/assets/6f253cd2-09de-4610-b321-496f46b27470)
3. Select **Java Application**:
    ![Pasted image 20250115184941](https://github.com/user-attachments/assets/de966631-7fd3-4d92-a1a0-bee80982b093)
4. Go to the **Arguments** tab:
    ![Pasted image 20250115185012](https://github.com/user-attachments/assets/d0818151-bd21-440f-b0fa-b75c8e551523)
5. Add the following (example):
```
--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
```
6. Ensure the path to the installed `javafx-sdk` is correct:  
    `/path/to/javafx-sdk/lib`

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

