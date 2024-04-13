package com.example.TransactionalDemoProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "b")
@Data
public class B {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
}