package com.pe.web.cine.app.service;

import java.util.List;

import com.pe.web.cine.app.dto.request.CinemaRequest;
import com.pe.web.cine.app.dto.response.CinemaResponse;

import reactor.core.publisher.Mono;

public interface CinemaService {

	Mono<List<CinemaResponse>> getAllCinema();
	Mono<CinemaResponse> getCinemaResponse(Integer codCinema);
	Mono<CinemaResponse> addCinema(CinemaRequest cinemaRequest);
	
}
