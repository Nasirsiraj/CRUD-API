package org.io.crud.repository;

import org.io.crud.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacher_Repository extends JpaRepository<Teacher, Integer> {
}
