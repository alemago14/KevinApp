package com.cyseg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyseg.entities.Registro;

@Repository
public interface RegistroRepositorio extends JpaRepository<Registro, Long>{

}
