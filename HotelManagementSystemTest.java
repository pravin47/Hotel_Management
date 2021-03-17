package com.hotel.management;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HotelManagementSystemTest {

	private  HotelManagementSystem  HotelManagementSystem;
	private Customer cust;

	@Before
	public void init() {
		 HotelManagementSystem = new  HotelManagementSystem();
		 HotelManagementSystem.addHotel("Lakewood", 110,90,80,80,3);
		 HotelManagementSystem.addHotel("Bridgewood", 160,50,110,50,4);
		 HotelManagementSystem.addHotel("Ridgewood", 220,150,100,40,5);
	}

	//Testing for creation of 3 hotels
	@Test
	public void whenLakewoodAdded_ShouldReturnTrue()
	{	
		assertTrue( HotelManagementSystem.addHotel("Lakewood", 110,90,80,80,3));
	}

	@Test
	public void whenBridgewoodAdded_ShouldReturnTrue()
	{	
		assertTrue( HotelManagementSystem.addHotel("Bridgewood", 160,50,110,50,4));
	}

	@Test
	public void whenRidgewoodAdded_ShouldReturnTrue()
	{	
		assertTrue( HotelManagementSystem.addHotel("Ridgewood", 220,150,100,40,5));
	}

	//Testing for correct output for staying 1 day
	@Test
	public void whenStayed1Day_CheapestHotelShouldBe_Lakewood()
	{	
		cust= HotelManagementSystem.findCheapestHotel("Regular","12.05.2020", "13.05.2020");
		assertEquals(110, cust.getBill());
	}

	@Test
	public void whenStayed1Day_CheapestHotelShouldCost_110()
	{	
		cust= HotelManagementSystem.findCheapestHotel("Regular","12.05.2020", "13.05.2020");
		assertEquals("Lakewood", cust.getHotelName());
	}

	@Test
	public void whenStayed1DayOnWeekendCheapestHotelShouldBeBridgeWood()
	{	
		cust= HotelManagementSystem.findCheapestHotel("Regular","12.09.2020", "13.09.2020");
		assertEquals("Bridgewood", cust.getHotelName());
	}

	@Test
	public void whenStayed1DayOnWeekendCheapestHotelShouldCost_50()
	{	
		cust= HotelManagementSystem.findCheapestHotel("Regular","12.09.2020", "13.09.2020");
		assertEquals(50, cust.getBill());
	}

	//Rating Testing With DummyHotel
	@Test
	public void whenStayed1DayCheapestHotelShouldBeDummyHotel()
	{	
		 HotelManagementSystem.addHotel("DummyHotel", 110,90,80,80,5);
		cust= HotelManagementSystem.findCheapestHotel("Regular","12.05.2020", "13.05.2020");
		assertEquals("DummyHotel", cust.getHotelName());
	}

	//Checking for best rated hotel
	@Test
	public void whenStayed1DayMaxRatedHotelShouldBeRidgeWood()
	{	
		cust= HotelManagementSystem.bestRatedHotel("Regular","12.05.2020", "13.05.2020");
		assertEquals("Ridgewood", cust.getHotelName());
	}

	//Testing for correct output for staying 1 day as Reward Cust
	
	//Weekday Rate
	@Test
	public void whenStayedWeekdayCheapestHotelShouldCost80()
	{	
		cust= HotelManagementSystem.findCheapestHotel("Reward","12.05.2020", "13.05.2020");
		assertEquals(80, cust.getBill());
	}

	//Weekend Rate
	@Test
	public void whenStayedWeekendCheapestHotelShouldCost80()
	{	
		cust= HotelManagementSystem.findCheapestHotel("Reward","12.09.2020", "13.09.2020");
		assertEquals(80, cust.getBill());
	}
}