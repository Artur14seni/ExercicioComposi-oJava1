package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Reservation;
import entities.Room;
import enums.ReservationStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat horario = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		
		System.out.println("Digite aqui dados do Cliente: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.next();
		
		System.out.print("Data de aniversario: ");
		Date aniversario = date.parse(sc.next());

		Client client = new Client(nome, email, aniversario);
		
		System.out.println();
		
		System.out.print("Status da reserva: ");
		ReservationStatus rs = ReservationStatus.valueOf(sc.next());
		
		sc.nextLine();
		
		System.out.print("Horario do CheckIn: ");
		Date diaEntrada = horario.parse(sc.nextLine());
		
		System.out.print("Horario do CheckOut: ");
		Date diaSaida = horario.parse(sc.nextLine());
		
		Reservation reservation = new Reservation(diaEntrada, diaSaida, rs, client);
		
		System.out.print("Quantos quartos você gostaria: ");
		int numQuarto = sc.nextInt();
		
		for(int i = 0; i < numQuarto; i++) {
			
			System.out.print("numero do quarto: ");
			String quarto = sc.next(); 
			
			System.out.print("Preço por noite: ");
			double preco = sc.nextDouble();
			
			Room room = new Room(quarto, preco);
			
			reservation.addRoom(room);
		}
		
		System.out.println();
		
		System.out.println("Dados da reserva: ");
		
		System.out.println(reservation);
		
		
		
		
		sc.close();
	}

}
