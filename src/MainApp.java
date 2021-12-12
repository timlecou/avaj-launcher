package src;

import src.aircraft.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class	MainApp
{
	private static int				simulationCycles;
	private static WeatherTower		tower;
	private static BufferedReader	buf;
	private static String			line;

	public static class SimulationException extends Exception {
		private static final long serialVersionUID = -1928219242566779452L;

		public SimulationException() { super(); }
		public SimulationException(String exception) { super (exception); }
		public SimulationException(Throwable exception) { super (exception); }
	}



	private static void	initSimulation(File file) throws SimulationException {
		try {

			buf = new BufferedReader(new FileReader(file));
			simulationCycles = Integer.parseInt(buf.readLine());

		} catch (NumberFormatException | IOException e) {

			throw new SimulationException(e);

		}
	}

	private static void	loadAircrafts() throws SimulationException {
		try {

			String	info[];
			tower = new WeatherTower();
			while ((line = buf.readLine()) != null) {
				info = line.split("\\s+");
				AircraftFactory.newAircraft(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4])).registerTower(tower);
			}
			buf.close();

		} catch (IOException e) {
			throw new SimulationException(e);
		}
	}


	public static void main (String[] arg)
	{
		if (arg.length < 1) {
			return ;
		}

		try {
			initSimulation(new File(arg[0]));
			loadAircrafts();
		}
		catch (SimulationException e) {
			System.out.println(e.getMessage());
			return ;
		}

		while (simulationCycles-- > 0) {
			tower.changeWeather();
		}
	}
}
