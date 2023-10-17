package com.pe.web.cine.app.controller;

import com.pe.web.cine.app.api.CinemasApi;
import com.pe.web.cine.app.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pe.web.cine.app.service.CinemaService;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class CinemaController implements CinemasApi {

	@Autowired
	CinemaService cinemaService;

	@Override
	public Mono<ResponseEntity<CinemaResponse>> _addCinema(CinemaRequest cinemaRequest, ServerWebExchange exchange) {
		return cinemaService.addCinema(cinemaRequest)
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK));
	}

	@Override
	public Mono<ResponseEntity<RoomResponse>> _addRoomToCinema(RoomRequest roomRequest, ServerWebExchange exchange) {
		return null;
	}

	@Override
	public Mono<ResponseEntity<CinemaResponse>> _findCinema(Integer codCinema, ServerWebExchange exchange) {
		return cinemaService.getCinemaResponse(codCinema)
				.map(result -> new ResponseEntity<>(result,HttpStatus.OK));
	}

	@Override
	public Mono<ResponseEntity<Flux<CinemaResponse>>> _findCinemasAll(ServerWebExchange exchange) {
		return Mono.just(new ResponseEntity<>(cinemaService.getAllCinema(),HttpStatus.OK));
	}

	@Override
	public Mono<ResponseEntity<RoomResponse>> _getInfoRoom(Integer codRoom, ServerWebExchange exchange) {
		return null;
	}

	@Override
	public Mono<ResponseEntity<SeatResponse>> _updateInfoStatusSeatIntoRoom(ServerWebExchange exchange) {
		return null;
	}
}
