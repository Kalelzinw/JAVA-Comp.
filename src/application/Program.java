package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		LocalDateTime date_now = LocalDateTime.now();
		
		System.out.println("Enter cliente data:");
		
		System.out.println("Name:");
		String name = sc.nextLine();
		
		System.out.println("Email:");
		String email = sc.next();
		
		System.out.println("Birth date (DD/MM/YYYY):");
		String birthdate = sc.next();
		LocalDate birth = LocalDate.parse(birthdate,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Client client = new Client(name, email, birth);
		
		System.out.println("Enter order data:");
		String orderstatus = sc.next();
		OrderStatus os1 = OrderStatus.valueOf(orderstatus.toUpperCase());
		
		Order order = new Order(date_now, os1, client);
		
		System.out.println("How many items to this order?");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.printf("Enter #%d item data:", i);
			
			System.out.println("Product name:");
			sc.hasNextLine();
			String product_name = sc.next();
		    
		    System.out.println("Product price:");
		    double product_price = sc.nextDouble();
		    Product product = new Product(product_name, product_price);
		    
		    System.out.println("Quantity");
		    int product_quantity = sc.nextInt();
		    OrderItem orderitem = new OrderItem(product_quantity, product_price, product);
		    
		    
		    order.addItem(orderitem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		
		
		sc.close();
	}

}
