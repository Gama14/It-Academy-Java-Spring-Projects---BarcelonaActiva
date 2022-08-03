package cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.repository;

import cat.itacademy.barcelonactiva.garcia.sara.s05.t01.n01.model.Sucursal;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Long> {



}
