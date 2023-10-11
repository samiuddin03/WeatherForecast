# Weather Forecast App

A simple Java application to fetch and display weather information based on user input.

## Features

- Fetch and display basic weather information such as temperature, weather description, and humidity.
- Allow users to input a city name to get the weather data for that location.
- Utilize a weather API to retrieve current weather data.
- Present the weather information in a clear and easily understandable format.
- Handle cases where the user enters an invalid location or the API request fails.
- Allow users to choose temperature units (e.g., Celsius, Fahrenheit).
- Validate user input to ensure it is a valid location.

## Usage

1. Clone the repository:
   ```
   git clone https://github.com/0xSakib/WeatherForecast.git
   ```

2. Navigate to the project directory:

```
cd WeatherForecast
```

3. Compile the Java source files:
```
javac -d bin src/*.java
```

4. Create the runnable JAR:

``` jar cmf Manifest.txt WeatherApp.jar -C bin .
```

5. Run the application:
```
java -jar WeatherApp.jar
```


## APIs Used
OpenWeatherMap API for weather data.

## Credits
Developed by

## License
This project is licensed under the MIT License - see the LICENSE file for details.
