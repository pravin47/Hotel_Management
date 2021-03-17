package com.hotel.management;

public class Customer extends HotelObject {

	public String custType;
	public int DaysStayed;
	public int bill;
	public int rateWeekday;
	public int rateWeekend;

	public Customer(String hotelName, int DaysStayed, int bill) {
		super(hotelName);
		this.DaysStayed = DaysStayed;
		this.bill = bill;
	}

	public void showBill() { // Method for displaying all details

		System.out.println("Hotel Found: " + hotelName);
		System.out.println("Days Stayed: " + DaysStayed);
		System.out.println("Total Bill: " + bill);
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String type, HotelObject hotel) {
		if (type == "regular") {
			this.custType = "Regular";
			this.rateWeekday = hotel.rateWeekdayRegular;
			this.rateWeekendRegular = hotel.rateWeekendRegular;
		} else if (type == "reward") {
			this.custType = "Reward";
			this.rateWeekday = hotel.rateWeekdayReward;
			this.rateWeekendReward = hotel.rateWeekendReward;
		}
	}

	public int getDaysStayed() {
		return DaysStayed;
	}

	public void setDaysStayed(int daysStayed) {
		DaysStayed = daysStayed;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}
}