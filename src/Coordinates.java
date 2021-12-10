package src;

public class Coordinates
{
    private int     longitude = 0;
    private int     latitude = 0;
    private int     height = 0;

    public  Coordinates()
    {
    }

    public  Coordinates(int longitude, int latitude, int height)
    {
        setLatitude(latitude);
        setLongitude(longitude);
        setHeight(height);
    }

    public  int     getLatitude()
    {
        return this.latitude;
    }

    public  int     getLongitude()
    {
        return this.longitude;
    }

    public  int     getHeight()
    {
        return this.height;
    }

    public  void    setLongitude(int longitude)
    {
        this.longitude = longitude;
    }

    public  void    setLatitude(int latitude)
    {
        this.latitude = latitude;
    }

    public  void    setHeight(int height)
    {
        this.height = height;
    }
}
