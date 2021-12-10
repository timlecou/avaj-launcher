package src;

public class WeatherProvider
{
    public  WeatherProvider() {

    }

    private WeatherProvider weatherProvider;
    private String[]        weather;

    public  WeatherProvider getProvider() {
        return this.weatherProvider;
    }

    public  String  getCurrentWeather(Coordinates coordinates) {
        return null;
    }
}
