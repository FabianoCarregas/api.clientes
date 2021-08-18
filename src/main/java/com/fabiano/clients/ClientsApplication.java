package com.fabiano.clients;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiano.clients.domain.Address;
import com.fabiano.clients.domain.Category;
import com.fabiano.clients.domain.City;
import com.fabiano.clients.domain.Client;
import com.fabiano.clients.domain.Product;
import com.fabiano.clients.domain.State;
import com.fabiano.clients.domain.enums.ClientType;
import com.fabiano.clients.repositories.AddressRepository;
import com.fabiano.clients.repositories.CategoryRepository;
import com.fabiano.clients.repositories.CityRepository;
import com.fabiano.clients.repositories.ClientRepository;
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
	
	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informatic");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 900.00);
		Product p3 = new Product(null, "Mouse", 100.00);
	
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");
		
		City c1= new City(null,"Uberlandia", st1);
		City c2= new City(null,"São Paulo", st2);
		City c3= new City(null, "Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Client cli1 = new Client(null, "João", "joao@gmail", "123123123123", ClientType.PESSOAFISICA);
		
		cli1.getPhones().addAll(Arrays.asList("119999999900", "2233445566"));
		
		Address a1 = new Address(null, "Rua Um", "100", "Apto 10", "Jardim", "12123", cli1, c1);
		Address a2 = new Address(null, "Rua Dois", "200", "Apto 20", "Jardim", "1233", cli1, c2);
		
		cli1.getAddress().addAll(Arrays.asList(a1,a2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1,a2));
		
		
		
		
		
	
		
		
		
	}

}
