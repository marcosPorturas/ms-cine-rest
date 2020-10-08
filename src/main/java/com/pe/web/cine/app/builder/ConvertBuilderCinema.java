package com.pe.web.cine.app.builder;

import java.time.LocalDateTime;

import com.pe.web.cine.app.dto.request.CinemaRequest;
import com.pe.web.cine.app.dto.response.CinemaResponse;
import com.pe.web.cine.app.dto.response.Geolocation;
import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.entity.TypeCinema;
import com.pe.web.cine.app.utilitario.Constants;
import com.pe.web.cine.app.utilitario.Util;

public class ConvertBuilderCinema {

	public Cinema convertToCinemaEntity(CinemaRequest cinemaRequest) {
		return Cinema.builder()
				.name(cinemaRequest.getName())
				.enabled(Constants.ENABLED)
				.startDateOperation(cinemaRequest.getStartDateOperation())
				.creationDate(LocalDateTime.now())
				.department(cinemaRequest.getGeolocation().getDepartment())
				.province(cinemaRequest.getGeolocation().getProvince())
				.district(cinemaRequest.getGeolocation().getDistrict())
				.typeCinema(convertToTypeCinema(cinemaRequest))
				.build();
		
	}
	
	public CinemaResponse convertToCinemaResponse(Cinema cinema) {
		return CinemaResponse.builder()
				.codCinema(cinema.getCodCinema())
				.name(cinema.getName())
				.startDateOperation(Util.convertToStringDate(cinema.getStartDateOperation()))
				.typeCinema(cinema.getTypeCinema().getDescription())
				.geolocation(convertToGeolocation(cinema))
				.build();
	}
	
	public Geolocation convertToGeolocation(Cinema cinema) {
		return Geolocation.builder()
				.department(cinema.getDepartment())
				.province(cinema.getProvince())
				.district(cinema.getDistrict())
				.build();
	}
	
	public TypeCinema convertToTypeCinema(CinemaRequest cinemaRequest) {
		return TypeCinema.builder()
				.codTypeCinema(cinemaRequest.getTypeCinema())
				.build();
	}
}
