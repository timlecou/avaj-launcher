package src.aircraft;
import src.Coordinates;
import src.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    public Helicopter()
    {

    }

    public Helicopter(String name, Coordinates coordinates)
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
