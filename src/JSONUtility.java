import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtility {

    public static String getWeatherDescription(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray weatherArray = jsonObject.getJSONArray("weather");
            if (weatherArray.length() > 0) {
                return weatherArray.getJSONObject(0).getString("description");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "N/A";
    }

    public static double getTemperature(String jsonResponse, WeatherApp.TemperatureUnit unit) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject main = jsonObject.getJSONObject("main");
            double temperature = main.getDouble("temp");

            if (unit == WeatherApp.TemperatureUnit.CELSIUS) {
                temperature = temperature - 273.15; // Kelvin to Celsius
            } else if (unit == WeatherApp.TemperatureUnit.FAHRENHEIT) {
                temperature = (temperature - 273.15) * 9 / 5 + 32; // Kelvin to Fahrenheit
            }

            return temperature;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static double getPressure(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject main = jsonObject.getJSONObject("main");
            return main.getDouble("pressure");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getHumidity(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject main = jsonObject.getJSONObject("main");
            return main.getInt("humidity");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static double getWindSpeed(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject wind = jsonObject.getJSONObject("wind");
            return wind.getDouble("speed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getCloudiness(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject clouds = jsonObject.getJSONObject("clouds");
            return clouds.getInt("all");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
