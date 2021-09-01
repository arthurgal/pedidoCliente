package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do Cliente");
		System.out.print("Nome:");
		String nome = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento (DD/MM/YYYY):");
		Date dataDeNascimento = sdf.parse(sc.next());
		
		
		
		Client cliente = new Client (nome, email, dataDeNascimento);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order ordem = new Order (new Date(), status, cliente);
		
		System.out.println("Quantos itens para cadastrar?");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #" + n + " item data:");
			System.out.print("Nome: ");
			String nomeProduto = sc.next();
			
			System.out.print("Preço: ");
			double priceProduto = sc.nextDouble();
			
			System.out.print("Quantidade: ");
			int quantidadeProduto = sc.nextInt();
			
			Product produto = new Product (nomeProduto, priceProduto);
			OrderItem orderItem = new OrderItem (quantidadeProduto, priceProduto, produto);
			
			ordem.addItem(orderItem);
		}
		
		System.out.println(ordem);
		sc.close();
		
		

	}

}
