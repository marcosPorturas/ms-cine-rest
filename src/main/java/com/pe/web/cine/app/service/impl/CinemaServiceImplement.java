package com.pe.web.cine.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.cine.app.builder.ConvertBuilderCinema;

import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.model.CinemaRequest;
import com.pe.web.cine.app.model.CinemaResponse;
import com.pe.web.cine.app.repository.CinemaRepository;
import com.pe.web.cine.app.service.CinemaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CinemaServiceImplement implements CinemaService{

	@Autowired
	CinemaRepository cinemaRepository;

	@Override
	public Mono<List<CinemaResponse>> getAllCinema() {
		// TODO Auto-generated method stub
		return Flux.fromIterable(cinemaRepository.findAll())
				.map(this::invokeCinemaResponseBuilder)
				.collectList();
				
	}

	@Override
	public Mono<CinemaResponse> getCinemaResponse(Integer codCinema) {
		// TODO Auto-generated method stub
		return Mono.just(cinemaRepository.findById(codCinema)
				.orElse(null))
				.map(this::invokeCinemaResponseBuilder);
	}

	@Override
	public Mono<CinemaResponse> addCinema(CinemaRequest cinemaRequest) {
		// TODO Auto-generated method stub
		return Mono.just(cinemaRequest)
				.map(request -> invokeCinemaEntityBuilder(request))
				.map(entity -> cinemaRepository.save(entity))
				.map(save -> invokeCinemaResponseBuilder(save));
	}
	
	public CinemaResponse invokeCinemaResponseBuilder(Cinema cinema) {
		ConvertBuilderCinema convert = new ConvertBuilderCinema();
		return convert.convertToCinemaResponse(cinema);
	}
	
	public Cinema invokeCinemaEntityBuilder(CinemaRequest cinemaRequest) {
		ConvertBuilderCinema convert = new ConvertBuilderCinema();
		return convert.convertToCinemaEntity(cinemaRequest);
	}
}
