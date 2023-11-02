import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {


    public static String buildApiUrl(String cityName) {
        String apiKey = "977e5ddbe652f3a3131e9e61a0ce4d24";
        return "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;
    }

    public static String sendHttpRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        return response.toString();
    }

    public static void displayWeatherInformation(String cityName, String jsonResponse, WeatherAppGUI gui) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray weatherArray = jsonObject.getJSONArray("weather");
            String description = "N/A";
            if (weatherArray.length() > 0) {
                description = weatherArray.getJSONObject(0).getString("description");
            }

            JSONObject main = jsonObject.getJSONObject("main");
            double temperature = main.getDouble("temp");
            double pressure = main.getDouble("pressure");
            int humidity = main.getInt("humidity");

            JSONObject wind = jsonObject.getJSONObject("wind");
            double windSpeed = wind.getDouble("speed");

            int visibility = jsonObject.getInt("visibility");
            JSONObject clouds = jsonObject.getJSONObject("clouds");
            int cloudiness = clouds.getInt("all");

            if(WeatherAppGUI.changeUnit.isSelected()){
                temperature = (temperature - 273.15) * 9 / 5 + 32;
                WeatherAppGUI.tempUnit = "Fahrenheit";
            }
            else {
                temperature -= 273.15;
                WeatherAppGUI.tempUnit = "Celsius";
            }


            gui.setDescriptionLabel(description);
            gui.setTemperatureLabel(String.format("%.2f %s", temperature, WeatherAppGUI.tempUnit));
            gui.setPressureLabel(String.format("%.2f hPa", pressure));
            gui.setHumidityLabel(humidity + "%");
            gui.setWindLabel(String.format("%.2f m/s", windSpeed));
            gui.setVisibilityLabel(visibility + " meters");
            gui.setCloudinessLabel(cloudiness + "%");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error parsing JSON response: " + e.getMessage());
        }
    }


}
