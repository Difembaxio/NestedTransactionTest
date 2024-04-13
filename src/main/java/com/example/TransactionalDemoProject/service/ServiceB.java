package com.example.TransactionalDemoProject.service;


import com.example.TransactionalDemoProject.model.B;
import com.example.TransactionalDemoProject.repository.BRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Data
@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceB {

    private final BRepository repB;
    @Transactional(propagation = Propagation.REQUIRED)
    public void methodPropRequired() {
        B b = repB.findById(1L).orElseThrow(()-> new RuntimeException("B не найдено"));
        b.setNumber(b.getNumber()+1);
        log.info("Вызван метод methodPropRequired сервиса B. b.number = " + b.getNumber());
        log.info("Вызов метода methodPropRequired сервиса B закончен");

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void methodPropSupports() {
        B b = repB.findById(1L).orElseThrow(()-> new RuntimeException("B не найдено"));
        b.setNumber(b.getNumber()+1);
        log.info("Вызван метод methodPropSupports сервиса B. b.number = " + b.getNumber());
        log.info("Вызов метода methodPropRequired сервиса B закончен");
    }


    @Transactional(propagation = Propagation.MANDATORY)
    public void methodPropMandatory() {
        B b = repB.findById(1L).orElseThrow(()-> new RuntimeException("B не найдено"));
        b.setNumber(b.getNumber()+1);
        log.info("Вызван метод methodPropRequired сервиса B. b.number = " + b.getNumber());
        log.info("Вызов метода methodPropRequired сервиса B закончен");
    }




    @Transactional(propagation = Propagation.NEVER)
    public void methodPropNever() {
        B b = repB.findById(1L).orElseThrow(()-> new RuntimeException("B не найдено"));
        b.setNumber(b.getNumber()+1);
        log.info("Вызван метод methodPropRequired сервиса B. b.number = " + b.getNumber());
        log.info("Вызов метода methodPropRequired сервиса B закончен");
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void methodPropNot_Supported() {
        B b = repB.findById(1L).orElseThrow(()-> new RuntimeException("B не найдено"));
        b.setNumber(b.getNumber()+1);
        log.info("Вызван метод methodPropRequired сервиса B. b.number = " + b.getNumber());
        log.info("Вызов метода methodPropRequired сервиса B закончен");
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodPropRequires_New() {
        B b = repB.findById(1L).orElseThrow(()-> new RuntimeException("B не найдено"));
        b.setNumber(b.getNumber()+1);
        log.info("Вызван метод methodPropRequired сервиса B. b.number = " + b.getNumber());
        log.info("Вызов метода methodPropRequired сервиса B закончен");
    }

    @Transactional(propagation = Propagation.NESTED)
    public void methodPropNested() {
        B b = repB.findById(1L).orElseThrow(()-> new RuntimeException("B не найдено"));
        b.setNumber(b.getNumber()+1);
        log.info("Вызван метод methodPropRequired сервиса B. b.number = " + b.getNumber());
        log.info("Вызов метода methodPropRequired сервиса B закончен");
    }
}