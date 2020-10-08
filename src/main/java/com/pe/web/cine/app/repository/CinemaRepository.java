package com.pe.web.cine.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.web.cine.app.entity.Cinema;

@Repository
@Transactional
public interface CinemaRepository extends JpaRepository<Cinema, Integer>{

}
