package com.pe.web.cine.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.web.cine.app.entity.Seat;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface SeatRepository extends JpaRepository<Seat,Integer>{

	@Query("Select s from Seat s "
			+ "LEFT JOIN Room r ON s.room.codRoom = r.codRoom "
			+ "WHERE r.codRoom = :codRoom "
			+ "ORDER BY r.codRoom")
	List<Seat> findByCodRoom(@Param("codRoom")Integer codRoom);
	
}
