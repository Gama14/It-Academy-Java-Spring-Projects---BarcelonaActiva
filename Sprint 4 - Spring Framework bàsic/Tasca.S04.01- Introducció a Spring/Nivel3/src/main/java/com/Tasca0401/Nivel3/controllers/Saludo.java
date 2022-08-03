package com.Tasca0401.Nivel3.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludo {

    @RequestMapping("/")
    public String hola() {
        return "Hola Sara!.";
    }

    @RequestMapping("/nivel3")
    public String holaNombre(String nombre) {
        nombre = "Sara";
        return "Nivel 3 Maven. " + nombre;
    }
}