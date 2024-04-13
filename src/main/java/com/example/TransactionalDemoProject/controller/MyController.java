package com.example.TransactionalDemoProject.controller;

import com.example.TransactionalDemoProject.service.ServiceA;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {


    private final ServiceA serviceA;

    @PatchMapping("/methodPropRequiredNoTransaction")
    public void methodPropRequiredNoTransaction(){
        serviceA.methodPropRequiredNoTransaction();
    }

    @PatchMapping("/methodPropRequiredTransaction")
    public void methodPropRequiredTransaction(){
        serviceA.methodPropRequiredTransaction();
    }

    @PatchMapping("/methodPropSupports")
    public void methodPropSupports(){
        serviceA.methodPropSupports();
    }

    @PatchMapping("/methodPropSupportsNoTransaction")
    public void methodPropSupportsNoTransaction(){
        serviceA.methodPropSupportsNoTransaction();
    }


    @PatchMapping("/methodPropMandatory")
    public void methodPropMandatory(){
        serviceA.methodPropMandatory();
    }


    @PatchMapping("/methodPropMandatoryNotTransaction")
    public void methodPropMandatoryNotTransaction(){
        serviceA.methodPropMandatoryNotTransaction();
    }

    @PatchMapping("/methodPropNever")
    public void methodPropNever(){
        serviceA.methodPropNever();
    }

    @PatchMapping("/methodPropNeverNotTransaction")
    public void methodPropNeverNotTransaction(){
        serviceA.methodPropNeverNotTransaction();
    }


    @PatchMapping("/methodPropNot_Supported")
    public void methodPropNot_Supported(){
        serviceA.methodPropNot_Supported();
    }

    @PatchMapping("/methodPropNot_SupportedNotTransaction")
    public void methodPropNot_SupportedNotTransaction(){
        serviceA.methodPropNot_SupportedNotTransaction();
    }


    @PatchMapping("/methodPropRequires_New")
    public void methodPropRequires_New(){
        serviceA.methodPropRequires_New();
    }


    @PatchMapping("/methodPropRequires_NewNotTransaction")
    public void methodPropRequires_NewNotTransaction(){
        serviceA.methodPropRequires_NewNotTransaction();
    }

    @PatchMapping("/methodPropNested")
    public void methodPropNested(){
        serviceA.methodPropNested();
    }

    @PatchMapping("/methodPropNestedNotTransaction")
    public void methodPropNestedNotTransaction(){
        serviceA.methodPropNestedNotTransaction();
    }
}
