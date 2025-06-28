package com.devsuperior.aula;

import com.devsuperior.aula.entities.Order;
import com.devsuperior.aula.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AulaApplication implements CommandLineRunner {
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	Order orderOne = new Order(1034, 150.00, 20.0);
		double total = orderService.total(orderOne);
		System.out.printf("Pedido código %d%n", orderOne.getCode());
		System.out.printf("Valor total: R$ %.2f%n", total);

var orderTwo = new Order(2282, 800.00, 10.0);

		System.out.printf("Pedido código %d%n", orderTwo.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(orderTwo));

		Order orderThree = new Order(1309, 95.90, 0.0);
				System.out.printf("Pedido código %d%n", orderThree.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(orderThree));
	}
}
