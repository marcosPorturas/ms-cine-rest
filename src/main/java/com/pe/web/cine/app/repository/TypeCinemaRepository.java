package com.pe.web.cine.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.web.cine.app.entity.TypeCinema;

@Repository
@Transactional
public interface TypeCinemaRepository extends JpaRepository<TypeCinema, Integer>{

}
