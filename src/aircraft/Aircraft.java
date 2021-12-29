package src.aircraft;

import java.util.HashMap;

import  src.Coordinates;

public class Aircraft
{
    protected   long            id = 0;
    protected   String          name = "";
    protected   Coordinates     coordinates;
    private     static long     idCounter = 0;


    private enum                coords { LONG, LAT, HEIGHT };

    private HashMap<String, int[]> sun = new HashMap<String, int[]>() {
        private static final long serialVersionUID = 6356290756913881892L;
    {
        put("JetPlane", new int[] {0, 10, 2});
        put("Helicopter", new int[] {10, 0, 2});
		put("Balloon", new int[] {2, 0, 4});
	}};
	
	private HashMap<String, int[]> rain = new HashMap<String, int[]>() {
		private static final long serialVersionUID = 6974717331598825516L;
	{
		put("JetPlane", new int[] {0, 5, 0});
		put("Helicopter", new int[] {5, 0, 0});
		put("Balloon", new int[] {0, 0, -5});
	}};
	
	private HashMap<String, int[]> fog = new HashMap<String, int[]>() {
		private static final long serialVersionUID = -4278780771210532897L;
	{
		put("JetPlane", new int[] {0, 1, 0});
		put("Helicopter", new int[] {1, 0, 0});
		put("Balloon", new int[] {0, 0, -3});
	}};
	
	private HashMap<String, int[]> snow = new HashMap<String, int[]>() {
		private static final long serialVersionUID = -7390929606208949424L;
	{
		put("JetPlane", new int[] {0, 0, -7});
		put("Helicopter", new int[] {0, 0, -12});
		put("Balloon", new int[] {0, 0, -15});
	}};

    public  Aircraft()
    {

    }

    protected   Aircraft(String name, Coordinates coordinates)
    {
        setName(name);
        setCoordinates(coordinates);
    }

    public void    setName(String name)
    {
        this.name = name;
    }

    public void    setCoordinates(Coordinates coordinates)
    {
        this.coordinates = coordinates;
    }

    private long    nextId()
    {
        return this.idCounter++;
    }

    public Coordinates     getCoordinates()
    {
        return this.coordinates;
    }

    public String   updateCoordinates(String weather, String type) {
        int newHeight = 0;
        int[] changes = null;

        if (weather.equals("SUN")) {
            changes = sun.get(type);
            newHeight = this.coordinates.getHeight() + changes[coords.HEIGHT.ordinal()] > 100 ?
                100 : this.coordinates.getHeight() + changes[coords.HEIGHT.ordinal()];
        } else if (weather.equals("RAIN")) {
            changes = rain.get(type);
            newHeight = this.coordinates.getHeight() + changes[coords.HEIGHT.ordinal()];
        } else if (weather.equals("FOG")) {
            changes = fog.get(type);
            newHeight = this.coordinates.getHeight() + changes[coords.HEIGHT.ordinal()];
        } else if (weather.equals("SNOW")) {
            changes = snow.get(type);
            newHeight = this.coordinates.getHeight() + changes[coords.HEIGHT.ordinal()];
        }
        this.coordinates = new Coordinates(
            this.coordinates.getLongitude() + changes[coords.LONG.ordinal()],
            this.coordinates.getLatitude() + changes[coords.LAT.ordinal()],
            newHeight
        );
        if (newHeight <= 0) {
            return "GROUNDED";
        }
        return weather;
    }
}
