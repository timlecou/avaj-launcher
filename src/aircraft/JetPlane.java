package src.aircraft;
import src.Coordinates;
import src.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    public JetPlane()
    {

    }

    public JetPlane(String name, Coordinates coordinates)
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
