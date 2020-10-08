package com.pe.web.cine.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.cine.app.builder.ConvertBuilderCinema;
import com.pe.web.cine.app.dto.request.CinemaRequest;
import com.pe.web.cine.app.dto.response.CinemaResponse;
import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.repository.CinemaRepository;

import io.reactivex.Observable;
import io.reactivex.Single;

@Service
public class CinemaServiceImplement implements CinemaService{

	@Autowired
	CinemaRepository cinemaRepository;

	@Override
	public Single<List<CinemaResponse>> getAllCinema() {
		// TODO Auto-generated method stub
		return Observable.fromIterable(cinemaRepository.findAll())
				.map(this::invokeCinemaResponseBuilder)
				.toList();
	}

	@Override
	public Single<CinemaResponse> getCinemaResponse(Integer codCinema) {
		// TODO Auto-generated method stub
		return Single.just(cinemaRepository.findById(codCinema)
				.orElse(null))
				.map(this::invokeCinemaResponseBuilder);
	}

	@Override
	public Single<CinemaResponse> addCinema(CinemaRequest cinemaRequest) {
		// TODO Auto-generated method stub
		return Single.just(cinemaRequest)
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
