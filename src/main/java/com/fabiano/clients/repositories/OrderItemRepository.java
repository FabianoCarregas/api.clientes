package com.fabiano.clients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.clients.domain.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository <OrderItem, Integer> {

}
