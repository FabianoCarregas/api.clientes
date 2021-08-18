package com.fabiano.clients;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiano.clients.domain.Address;
import com.fabiano.clients.domain.Category;
import com.fabiano.clients.domain.City;
import com.fabiano.clients.domain.Client;
import com.fabiano.clients.domain.CreditCardPayment;
import com.fabiano.clients.domain.Order;
import com.fabiano.clients.domain.OrderItem;
import com.fabiano.clients.domain.Payment;
import com.fabiano.clients.domain.Product;
import com.fabiano.clients.domain.SlipPayment;
import com.fabiano.clients.domain.State;
import com.fabiano.clients.domain.enums.ClientType;
import com.fabiano.clients.domain.enums.PaymentStatus;
import com.fabiano.clients.repositories.AddressRepository;
import com.fabiano.clients.repositories.CategoryRepository;
import com.fabiano.clients.repositories.CityRepository;
import com.fabiano.clients.repositories.ClientRepository;
import com.fabiano.clients.repositories.OrderItemRepository;
import com.fabiano.clients.repositories.OrderRepository;
import com.fabiano.clients.repositories.PaymentRepository;
import com.fabiano.clients.repositories.ProductRepository;
import com.fabiano.clients.repositories.StateRepository;

@SpringBootApplication
public class ClientsApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category category1 = new Category(null, "Informatic");
		Category category2 = new Category(null, "Office");
		
		Product product1 = new Product(null, "Computer", 2000.00);
		Product product2 = new Product(null, "Printer", 900.00);
		Product product3 = new Product(null, "Mouse", 100.00);
	
		
		category1.getProducts().addAll(Arrays.asList(product1,product2,product3));
		category2.getProducts().addAll(Arrays.asList(product2));
		
		product1.getCategories().addAll(Arrays.asList(category1));
		product2.getCategories().addAll(Arrays.asList(category1, category2));
		product3.getCategories().addAll(Arrays.asList(category1));
		
		categoryRepository.saveAll(Arrays.asList(category1, category2));
		productRepository.saveAll(Arrays.asList(product1, product2, product3));
		
		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "São Paulo");
		
		City city1= new City(null,"Uberlandia", state1);
		City city2= new City(null,"São Paulo", state2);
		City city3= new City(null, "Campinas", state2);
		
		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2, city3));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1,city2,city3));
		
		Client client1 = new Client(null, "João", "joao@gmail", "123123123123", ClientType.PESSOAFISICA);
		
		client1.getPhones().addAll(Arrays.asList("119999999900", "2233445566"));
		
		Address address1 = new Address(null, "Rua Um", "100", "Apto 10", "Jardim", "12123", client1, city1);
		Address address2 = new Address(null, "Rua Dois", "200", "Apto 20", "Jardim", "1233", client1, city2);
		
		client1.getAddress().addAll(Arrays.asList(address1,address2));
		
		clientRepository.saveAll(Arrays.asList(client1));
		addressRepository.saveAll(Arrays.asList(address1,address2));
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Order order1= new Order(null, sdf.parse("18/07/2021 10:32"),client1,address1);
		Order order2= new Order(null, sdf.parse("17/07/2021 10:00"),client1,address2);
		
		Payment payment1 = new CreditCardPayment(null, PaymentStatus.QUITADO, order1, 6);
		order1.setPayment(payment1);
		
		Payment payment2 = new SlipPayment(null, PaymentStatus.PENDENTE, order2, sdf.parse("20/06/2021 00:00"), null);
		order2.setPayment(payment2);
		
		client1.getOrders().addAll(Arrays.asList(order1,order2));
		
		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(payment1,payment2));
		
		OrderItem oItem1 = new OrderItem(order1, product1, 0.0, 1, 2000.0);
		OrderItem oItem2 = new OrderItem(order1, product3, 0.0, 2, 100.0 );
		OrderItem oItem3 = new OrderItem(order2, product2, 100.0, 1, 900.0);
		
		order1.getItens().addAll(Arrays.asList(oItem1, oItem2));
		order2.getItens().addAll(Arrays.asList(oItem3));
		
		product1.getItens().addAll(Arrays.asList(oItem1));
		product2.getItens().addAll(Arrays.asList(oItem3));
		product3.getItens().addAll(Arrays.asList(oItem2));
		
		orderItemRepository.saveAll(Arrays.asList(oItem1, oItem2, oItem3));
	}

}
