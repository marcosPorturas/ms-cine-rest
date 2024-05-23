package com.pe.web.cine.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.web.cine.app.dto.request.SeatRequest;
import com.pe.web.cine.app.model.CinemaRequest;
import com.pe.web.cine.app.model.CinemaResponse;
import com.pe.web.cine.app.model.RoomRequest;
import com.pe.web.cine.app.model.RoomResponse;
import com.pe.web.cine.app.model.SeatResponse;
import com.pe.web.cine.app.service.CinemaService;
import com.pe.web.cine.app.service.RoomService;
import com.pe.web.cine.app.service.SeatService;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/cinemas")
public class CinemaController {

	@Autowired
	CinemaService cinemaService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	SeatService seatService;
	
	@GetMapping("/all")
	public Mono<List<CinemaResponse>> getAllCinema(){
		return cinemaService.getAllCinema();
	}
	
	@GetMapping("/{codCinema}")
	public Mono<CinemaResponse> getCinemaResponse(@PathVariable("codCinema") 
	Integer codCinema){
		return cinemaService.getCinemaResponse(codCinema);
	}
	
	@PostMapping("/add")
	public Mono<CinemaResponse> addCinema(@RequestBody CinemaRequest cinemaRequest){
		return cinemaService.addCinema(cinemaRequest);
	}
	
	@PostMapping("/room/add")
	public Mono<RoomResponse> addRoom(@RequestBody RoomRequest roomRequest){
		return roomService.addRoom(roomRequest);
	}
	
	@GetMapping("/room/{codRoom}")
	public Mono<RoomResponse> getRoomResponse(@PathVariable("codRoom")Integer codRoom){
		return roomService.getRoomResponse(codRoom);
	}
	
	@PostMapping("/room/seat")
	public Mono<List<SeatResponse>> updateSeat(@RequestBody List<SeatRequest> listSeatRequest){
		return seatService.updateSeatStatus(listSeatRequest);
	}
}
