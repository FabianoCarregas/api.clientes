package com.fabiano.clients.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiano.clients.domain.Order;
import com.fabiano.clients.repositories.OrderRepository;
import com.fabiano.clients.services.exception.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;

	public Order find(Integer id) {
		Optional<Order>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Order.class.getName()));
	}
	

}
