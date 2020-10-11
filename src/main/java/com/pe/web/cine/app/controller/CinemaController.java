package com.pe.web.cine.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.web.cine.app.dto.request.CinemaRequest;
import com.pe.web.cine.app.dto.request.RoomRequest;
import com.pe.web.cine.app.dto.response.CinemaResponse;
import com.pe.web.cine.app.dto.response.RoomResponse;
import com.pe.web.cine.app.service.CinemaService;
import com.pe.web.cine.app.service.RoomService;

import io.reactivex.Single;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

	@Autowired
	CinemaService cinemaService;
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("/all")
	public Single<List<CinemaResponse>> getAllCinema(){
		return cinemaService.getAllCinema();
	}
	
	@GetMapping("/{codCinema}")
	public Single<CinemaResponse> getCinemaResponse(@PathVariable("codCinema") 
	Integer codCinema){
		return cinemaService.getCinemaResponse(codCinema);
	}
	
	@PostMapping("/add")
	public Single<CinemaResponse> addCinema(@RequestBody CinemaRequest cinemaRequest){
		return cinemaService.addCinema(cinemaRequest);
	}
	
	@PostMapping("/room/add")
	public Single<RoomResponse> addRoom(@RequestBody RoomRequest roomRequest){
		return roomService.addRoom(roomRequest);
	}
}
