package src.aircraft;

import  src.Coordinates;

public class Aircraft
{
    protected   long            id = 0;
    protected   String          name = "";
    protected   Coordinates     coordinates;
    private     static long     idCounter = 0;

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
}
