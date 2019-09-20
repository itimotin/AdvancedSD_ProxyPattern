package calculator;
import adapter.DistanceAdapter;

public class KilometerDistanceAdapterImplementation implements DistanceAdapter {

	private DistanceCalculator distanceCalculator;
	@Override
	public double computeDistanceInKilometers(String startPosition, String finalPosition) {
		// TODO Auto-generated method stub
		double distanceInMiles = this.distanceCalculator.computeDistance(startPosition, finalPosition);
		
		return distanceInMiles * 1.609344;
	}

	@Override
	public void setDistanceCalculator(DistanceCalculator distanceCalculator) {
		// TODO Auto-generated method stub
		this.distanceCalculator = distanceCalculator;
	}

}
