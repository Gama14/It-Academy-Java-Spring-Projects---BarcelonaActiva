package com.Tasca2.gestionEmpleados.DAO;

import com.Tasca2.gestionEmpleados.models.Empleado;

import java.util.List;

public interface EmpleadoDAO { //DATA ACCES OBJECT -->clases que seran la conexion con la base de datos, cada clase corresponderá a una tabla

    List<Empleado> getEmpleados();

    void eliminar(Long id);

    void registrarEmpleado(Empleado empleado);

    void updateEmpleado(Empleado empleado);

    List<Empleado> getEmpleadosPorCargo(String cargo);

    Empleado getEmpleadosPorId(Long id);


}
