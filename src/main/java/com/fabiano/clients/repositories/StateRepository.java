package com.fabiano.clients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.clients.domain.State;

@Repository
public interface StateRepository extends JpaRepository <State, Integer> {

}
