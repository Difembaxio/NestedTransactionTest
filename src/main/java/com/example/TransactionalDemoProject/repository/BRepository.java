package com.example.TransactionalDemoProject.repository;

import com.example.TransactionalDemoProject.model.A;
import com.example.TransactionalDemoProject.model.B;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BRepository extends JpaRepository<B,Long> {
}
