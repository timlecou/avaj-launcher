package src.aircraft;

import src.MainApp.SimulationException;
import src.Coordinates;

public class AircraftFactory
{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws SimulationException {
        if (longitude < 0 || latitude < 0 || height < 0)
        {
            throw new SimulationException("Error: Cannot have negative coordinates");
        }

        if (height > 100)
        {
            height = 100;
        }

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.toLowerCase().equals("helicopter")) {
            System.out.println(type + " " + name + " has been created.");
            return new Helicopter(name, coordinates);
        }
        else if (type.toLowerCase().equals("baloon")) {
            System.out.println(type + " " + name + " has been created.");
            return new Baloon(name, coordinates);
        }
        else if (type.toLowerCase().equals("jetplane")) {
            System.out.println(type + " " + name + " has been created.");
            return new JetPlane(name, coordinates);
        }

        return null;
    }
}
