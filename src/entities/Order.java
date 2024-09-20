package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private LocalDateTime moment;
	private OrderStatus status;
	
	List<OrderItem> order = new ArrayList<>();
	
	private Client client;
	
	public Order () {
		
	}

	public Order(LocalDateTime moment, OrderStatus status,Client client) {
		
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<OrderItem> getOrder() {
		return order;
	}

	public void addItem (OrderItem item) {
		order.add(item);
	}
	
	public void removeItem (OrderItem item) {
		order.remove(item);
	}
	
	public double total () {
		double sum = 0;
		for (OrderItem c : order) {
			sum += c.subTotal();
		}
		return sum;
	}
	
	public String toString () {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(moment.format(formatter) + "\n");
		sb.append("Order Status:");
		sb.append(status + "\n");
		sb.append("Client: " + client);
		sb.append("\nOrder items:");
		for (OrderItem c : order) {
			sb.append(c + "\n");
		}
		sb.append("Total price: \n");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
