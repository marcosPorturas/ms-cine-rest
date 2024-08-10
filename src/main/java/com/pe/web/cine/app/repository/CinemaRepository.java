package com.pe.web.cine.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.web.cine.app.entity.Cinema;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CinemaRepository extends JpaRepository<Cinema, Integer>{

}
