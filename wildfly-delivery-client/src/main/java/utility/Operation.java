package utility;

public class Operation {

	public static void main(String[] args) {
		System.out.println(distFrom((float) 36.852857315242936 ,  (float) 10.159928798675537,
				(float) 36.820678,  (float) 10.144877));
	}

	public static float distFrom(float lat1, float lng1, float lat2, float lng2) {
		double earthRadius = 6371000; // meters
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2)
				* Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		float dist = (float) (earthRadius * c);

		return dist/1000;
	}
}
