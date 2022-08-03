package com.Tasca2.gestionEmpleados.DAO;

import com.Tasca2.gestionEmpleados.models.Empleado;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //hace referencia a la conexion con la base de datos
@Transactional //permite las consultas de SQL a la base de datos
public class EmpleadoDAOImp implements EmpleadoDAO{

    @PersistenceContext
    private EntityManager entityManager; //permite hacer la conexion con la base de datos

    @Override
    public List getEmpleados() {
        String query = "FROM Empleado";
        List<Empleado>resultado= entityManager.createQuery(query).getResultList();
        return resultado;
    }

    @Override
    public List<Empleado> getEmpleadosPorCargo(String cargo) {
        String query = "FROM Empleado where cargo like '%" + cargo + "%'";
        List<Empleado>resultado= entityManager.createQuery(query).getResultList();
        return resultado;
    }

    @Override
    public Empleado getEmpleadosPorId(Long id) {
        Empleado resultado= entityManager.find(Empleado.class, id);
        return resultado;
    }

    @Override
    public void eliminar(Long id) {
        Empleado empleado = entityManager.find(Empleado.class, id);
        entityManager.remove(empleado);
    }

    @Override
    public void registrarEmpleado(Empleado empleado) {
        entityManager.merge(empleado);

    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        entityManager.merge(empleado);


    }
}
