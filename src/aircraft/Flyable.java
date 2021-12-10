package src.aircraft;

import src.WeatherTower;

public interface Flyable
{
    void    updateConditions();
    void    registerTower(WeatherTower weatherTower);
}
