package src.aircraft;
import src.Coordinates;
import src.WeatherTower;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    public Baloon()
    {

    }

    public Baloon(String name, Coordinates coordinates)
    {
        super (name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
