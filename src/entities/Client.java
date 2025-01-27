package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
	private String name;
	private String email;
	private LocalDate date;
	
	public Client () {
		
	}

	public Client(String name, String email, LocalDate date) {
		
		this.name = name;
		this.email = email;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Client = " + name + " " + date.format(formatter) + " - " + email;
	}
	
	
	
}
