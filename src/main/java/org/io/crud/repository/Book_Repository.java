package org.io.crud.repository;

import org.io.crud.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book_Repository extends JpaRepository<Book, Integer> {
}
