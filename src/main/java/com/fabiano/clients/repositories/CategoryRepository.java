package com.fabiano.clients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabiano.clients.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer> {

}
