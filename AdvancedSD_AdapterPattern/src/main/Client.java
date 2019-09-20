package main;

import adapter.DistanceAdapter;
import calculator.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Client started");
		DistanceCalculator distanceCalculator = new DistanceCalculator();
		double distanceInMiles = distanceCalculator.computeDistance("start", "final");
		
		System.out.println("Distance from start to final is " + distanceInMiles + " miles");
		
		DistanceAdapter distanceAdapter = new KilometerDistanceAdapterImplementation();
		distanceAdapter.setDistanceCalculator(distanceCalculator);
		
		double distanceInKilometers = distanceAdapter.computeDistanceInKilometers("start", "final");
		System.out.println("Distance from start to final is " + distanceInKilometers + " kilometers");
	}

}
