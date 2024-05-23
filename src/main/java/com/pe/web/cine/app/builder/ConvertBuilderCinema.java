package com.pe.web.cine.app.builder;

import java.time.LocalDateTime;

import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.entity.TypeCinema;
import com.pe.web.cine.app.model.CinemaRequest;
import com.pe.web.cine.app.model.CinemaResponse;
import com.pe.web.cine.app.model.Geolocation;
import com.pe.web.cine.app.utilitario.Constants;
import com.pe.web.cine.app.utilitario.Util;

public class ConvertBuilderCinema {

	public Cinema convertToCinemaEntity(CinemaRequest cinemaRequest) {
		return Cinema.builder()
				.name(cinemaRequest.getName())
				.enabled(Constants.ENABLED)
				.startDateOperation(LocalDateTime.parse(cinemaRequest.getStartDateOperation()))
				.creationDate(LocalDateTime.now())
				.department(cinemaRequest.getGeolocation().getDepartment())
				.province(cinemaRequest.getGeolocation().getProvince())
				.district(cinemaRequest.getGeolocation().getDistrict())
				.typeCinema(convertToTypeCinema(cinemaRequest))
				.build();
		
	}
	
	public CinemaResponse convertToCinemaResponse(Cinema cinema) {
		CinemaResponse cinemaResponse = new CinemaResponse();
		cinemaResponse.setCodCinema(cinema.getCodCinema());
		cinemaResponse.setName(cinema.getName());
		cinemaResponse.setStartDateOperation(Util.convertToStringDate(cinema.getStartDateOperation()));
		cinemaResponse.setTypeCinema(cinema.getTypeCinema().getDescription());
		cinemaResponse.setGeolocation(convertToGeolocation(cinema));
		return cinemaResponse;
	}
	
	public Geolocation convertToGeolocation(Cinema cinema) {
		Geolocation geolocation = new Geolocation();
		geolocation.setDepartment(cinema.getDepartment());
		geolocation.setProvince(cinema.getProvince());
		geolocation.setDistrict(cinema.getDistrict());
		return geolocation;
	}
	
	public TypeCinema convertToTypeCinema(CinemaRequest cinemaRequest) {
		return TypeCinema.builder()
				.codTypeCinema(cinemaRequest.getTypeCinema())
				.build();
	}
}
