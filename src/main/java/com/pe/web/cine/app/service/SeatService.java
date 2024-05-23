package com.pe.web.cine.app.service;

import java.util.List;

import com.pe.web.cine.app.model.SeatRequest;
import com.pe.web.cine.app.model.SeatResponse;

import reactor.core.publisher.Mono;

public interface SeatService {
	
	Mono<List<SeatResponse>> updateSeatStatus(List<SeatRequest> listSeatRequest);

}
