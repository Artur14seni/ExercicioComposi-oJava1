package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.ReservationStatus;

public class Reservation {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date checkIn;
	private Date checkOut;
	private ReservationStatus status;
	private Client client;
	private List <Room> rooms = new ArrayList<>();
	
	
	public Reservation() {
	}

	public Reservation(Date checkIn, Date checkOut, ReservationStatus status, Client client) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.status = status;
		this.client = client;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Room> getRooms() {
		return rooms;
	}
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public void removeRoom(Room room) {
		rooms.remove(room);
	}
	
	public double totalPrice() {
		double soma = 0;
		for(Room x: rooms) {
			soma += x.getPricePerNight();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ");
		sb.append(client.getName()+"\n");
		sb.append("Email: ");
		sb.append(client.getEmail() + "\n");
		sb.append("Status: ");
		sb.append(status+"\n");
		sb.append("Date checkIn: ");
		sb.append(sdf.format(checkIn) +"\n");
		sb.append("Date checkOut: ");
		sb.append(sdf.format(checkOut) + "\n");
		sb.append("Relatorios de quartos: \n");
		
		for(Room x: rooms) {
			sb.append(x +"\n");
		}
		
		sb.append("Total reservation: ");
		sb.append(String.format("%.2f", totalPrice()));
		
		return sb.toString();
	}
	
}
