package src;

public class WeatherTower extends Tower
{
    public  WeatherTower() {

    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    protected void changeWeather () {
        this.conditionsChanged();
    }
}
