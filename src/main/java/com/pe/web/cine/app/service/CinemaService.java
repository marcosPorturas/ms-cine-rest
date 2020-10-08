package com.pe.web.cine.app.service;

import java.util.List;

import com.pe.web.cine.app.dto.request.CinemaRequest;
import com.pe.web.cine.app.dto.response.CinemaResponse;

import io.reactivex.Single;

public interface CinemaService {

	
	Single<List<CinemaResponse>> getAllCinema();
	
	Single<CinemaResponse> getCinemaResponse(Integer codCinema);
	
	Single<CinemaResponse> addCinema(CinemaRequest cinemaRequest);
}
