package com.pe.web.cine.app.service.impl;

import com.pe.web.cine.app.model.CinemaRequest;
import com.pe.web.cine.app.model.CinemaResponse;
import com.pe.web.cine.app.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.cine.app.builder.ConvertBuilderCinema;
import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.repository.CinemaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CinemaServiceImplement implements CinemaService {

	@Autowired
	CinemaRepository cinemaRepository;

	@Override
	public Flux<CinemaResponse> getAllCinema() {
		// TODO Auto-generated method stub
		return Flux.fromIterable(cinemaRepository.findAll())
				.map(this::invokeCinemaResponseBuilder);
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
				.map(this::invokeCinemaEntityBuilder)
				.map(cinemaRepository::save)
				.map(cinema->cinemaRepository.findById(cinema.getCodCinema())
						.orElse(null))
				.map(this::invokeCinemaResponseBuilder);
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
