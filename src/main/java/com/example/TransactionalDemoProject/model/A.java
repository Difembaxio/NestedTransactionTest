package com.example.TransactionalDemoProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "a")
@Data
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
}
