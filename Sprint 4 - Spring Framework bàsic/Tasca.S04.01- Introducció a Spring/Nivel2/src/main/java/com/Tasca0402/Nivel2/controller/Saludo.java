package com.Tasca0402.Nivel2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludo {

    @RequestMapping("/")
    public String hola() {
        return "HELLO WORLD!";
    }

    @RequestMapping("/fase2")
    public String holaNombre(String nombre) {
        nombre = "Sara";
        return "Fase 2 ejercicio Gradle. " + nombre;
    }
}