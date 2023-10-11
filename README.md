# Weather Forecast App

This is a simple Weather Forecast application that provides weather information based on the city input provided by the user.

## Features
* Retrieve and display weather information for a given city.
* Display temperature, pressure, humidity, wind speed, visibility, and cloudiness.

## Prerequisites
* Java Development Kit (JDK) installed
* json-java library (java-json.jar) for handling JSON data. You can find it in the lib directory.

## Installation

1. Clone the repository to your local machine:
```
git clone https://github.com/0xSakib/WeatherForecast.git
cd WeatherForecast
```
2. Compile the Java source files using the following command:
```
javac -cp ".:lib/java-json.jar" -d out/production/WeatherForcastApp src/*.java
```

3. Run the application
```
java -cp ".:lib/java-json.jar:out/production/WeatherForcastApp" WeatherAppGUI
```

## Usage
1. Enter the name of the city for which you want to get weather information.
2. Click on the "Fetch Weather" button.
3. The application will display the weather information.

## Contributors

## License
This project is licensed under the MIT License
