package com.example.TransactionalDemoProject.repository;

import com.example.TransactionalDemoProject.model.A;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ARepository extends JpaRepository<A,Long> {
}
