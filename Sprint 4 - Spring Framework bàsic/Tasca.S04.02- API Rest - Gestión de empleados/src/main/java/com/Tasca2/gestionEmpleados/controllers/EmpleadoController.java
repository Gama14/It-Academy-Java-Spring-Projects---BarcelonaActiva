package com.Tasca2.gestionEmpleados.controllers;

import com.Tasca2.gestionEmpleados.DAO.EmpleadoDAO;
import com.Tasca2.gestionEmpleados.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //indica que la clase es controlador
public class EmpleadoController { //sirven para manejar las direciones de url

    @Autowired //permite la inyección de dependencias
    private EmpleadoDAO empleadoDAO;

    // añadimos api para diferenciar el frontend del backend
    @RequestMapping(value = "api/empleados", method = RequestMethod.GET) //declara el request method, en caso de omisión se declara GET por defecto
    public List<Empleado> getEmpleados() {
        return empleadoDAO.getEmpleados();
    }

    @RequestMapping(value = "api/empleados{id}", method = RequestMethod.GET)
    public Empleado getEmpleadosPorId(@PathVariable long id) {
        return empleadoDAO.getEmpleadosPorId(id);
    }

    @RequestMapping(value = "api/empleados/{cargo}", method = RequestMethod.GET)
    public List<Empleado> getEmpleadosPorCargo(@PathVariable String cargo) {
        return empleadoDAO.getEmpleadosPorCargo(cargo);
    }

    @RequestMapping(value = "api/empleados", method = RequestMethod.POST)
    public void registrarEmpleado(@RequestBody Empleado empleado) { //convierte el json que recibe en un empleado
        empleadoDAO.registrarEmpleado(empleado);
    }

    @RequestMapping(value = "api/empleados{id}", method = RequestMethod.PUT)
    public void updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado empleadoUpdate = empleadoDAO.getEmpleadosPorId(id);

        if(empleado.getNombre() != null) { //necesario para evitar error al intentar adjudicar un elemento null que no puede serlo
            empleadoUpdate.setNombre(empleado.getNombre());
        }else if(empleado.getApellido() != null) {
            empleadoUpdate.setApellido(empleado.getApellido());
        }else if(empleado.getCargo() != null) {
            empleadoUpdate.setCargo(empleado.getCargo());
        }else if (empleado.getSalario() != null) {
            empleadoUpdate.setSalario(empleado.getSalario());
        }
        empleadoDAO.updateEmpleado(empleadoUpdate);

    }
    @RequestMapping(value = "api/empleados{id}", method = RequestMethod.DELETE)
    public void deleteEmpleado(@PathVariable Long id) {
       empleadoDAO.eliminar(id);
    }



}
