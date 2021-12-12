package src;

public class WeatherProvider
{
    private  WeatherProvider() {

    }

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[]        weather = {"RAIN", "SNOW", "SUN", "FOG"};

    public static  WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public  String  getCurrentWeather(Coordinates coordinates) {
        int value = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();

        return weather[value % 4];
    }
}
