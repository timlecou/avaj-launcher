package src.aircraft;
import src.Coordinates;
import src.WeatherTower;
import java.util.HashMap;

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

    private HashMap<String, String> msg = new HashMap<String, String>() {
        private static final long serialVersionUID = 3219411135754797890L;
    {
        put("SUN", "AHHH I CAN FEEL THE SKIN PEELING FROM MY FLESH!!!");
		put("RAIN", "Who knew this inflatable rubber could act like an umbrella.");
		put("FOG", "I'd love a fog repeller but it'd probably not a good idea in a balloon.");
		put("SNOW", "I bet I looked like ice cream from below being covered in snow.");
		put("GROUNDED", "Crash landing! I hope this balloon can cushion the crash!");
    }};

    @Override
    public void updateConditions() {
        String update = this.updateCoordinates(weatherTower.getWeather(this.coordinates), "Baloon");
        System.out.println("Baloon#" + this.name + "(" + this.id + "):" + msg.get(update));
        if (update == "GROUNDED") {
            System.out.println("Baloon#" + this.name + "(" + this.id + "): landing.");
            System.out.println("Current coordinates: Longtitude: [" + this.coordinates.getLongitude() 
				+ "] Latitude: [" + this.coordinates.getLatitude()
				+ "] Height: [" + this.coordinates.getHeight() + "]");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
	}

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
