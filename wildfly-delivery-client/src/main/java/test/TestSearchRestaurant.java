package test;

import delegate.RestaurantServiceDelegate;

public class TestSearchRestaurant {
	
	public static Double ALT = 36.820678;
	public static Double LNG = 10.144877;
	public static Integer  RADIUS = 10;
	
	public static void main(String[] args) {
		RestaurantServiceDelegate delegate = new RestaurantServiceDelegate();

		System.out.println(delegate.findByName("cafe"));
				
		System.out.println(delegate.findByDistance(ALT,LNG,10));
	
	}
}
