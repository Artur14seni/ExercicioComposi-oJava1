package entities;

public class Room {

	private String number;
	private double pricePerNight;
	
	public Room() {}
	
	public Room(String number, double pricePerNight) {
		this.number = number;
		this.pricePerNight = pricePerNight;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	public String toString() {
		return 
		"room: "+
		number+
		", price per night: "+
		pricePerNight;
	}
	
	
}
