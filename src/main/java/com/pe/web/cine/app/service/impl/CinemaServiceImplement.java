package com.pe.web.cine.app.service.impl;

import com.google.gson.Gson;
import com.pe.web.cine.app.entity.TypeCinema;
import com.pe.web.cine.app.model.CinemaRequest;
import com.pe.web.cine.app.model.CinemaResponse;
import com.pe.web.cine.app.repository.TypeCinemaRepository;
import com.pe.web.cine.app.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.cine.app.builder.ConvertBuilderCinema;
import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.repository.CinemaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class CinemaServiceImplement implements CinemaService {

	@Autowired
	CinemaRepository cinemaRepository;

	@Autowired
	TypeCinemaRepository typeCinemaRepository;

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
		log.info("[method addCinema init]");
		return Mono.just(cinemaRequest)
				.map(this::invokeCinemaEntityBuilder)
				.map(entity -> cinemaRepository.save(entity))
				.map(save -> {
					CinemaResponse result = invokeCinemaResponseBuilder(save);
					result.setTypeCinema(getTypeCinema(save.getTypeCinema().getCodTypeCinema()));
					return result;
				});
	}

	public String getTypeCinema(int codTypeCinema) {
		return typeCinemaRepository.findById(codTypeCinema)
				.orElse(null).getDescription();
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
