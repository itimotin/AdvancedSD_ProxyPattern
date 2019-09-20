package adapter;

import calculator.DistanceCalculator;

public interface DistanceAdapter {
	double computeDistanceInKilometers(String startPosition, String finalPosition);
	void setDistanceCalculator(DistanceCalculator distanceCalculator);
}
