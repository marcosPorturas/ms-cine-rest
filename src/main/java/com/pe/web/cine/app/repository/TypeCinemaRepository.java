package com.pe.web.cine.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.web.cine.app.entity.TypeCinema;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TypeCinemaRepository extends JpaRepository<TypeCinema, Integer>{

}
