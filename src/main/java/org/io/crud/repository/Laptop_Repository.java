package org.io.crud.repository;

import org.io.crud.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Laptop_Repository extends JpaRepository<Laptop, Integer> {
}
