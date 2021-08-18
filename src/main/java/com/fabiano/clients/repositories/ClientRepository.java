package com.fabiano.clients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.clients.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client, Integer> {

}
