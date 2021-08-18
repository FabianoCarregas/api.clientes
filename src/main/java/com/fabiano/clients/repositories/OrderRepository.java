package com.fabiano.clients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.clients.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {

}
