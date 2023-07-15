package com.pe.web.cine.app.service;

import java.util.List;

import com.pe.web.cine.app.dto.request.SeatRequest;
import com.pe.web.cine.app.dto.response.SeatResponse;
import reactor.core.publisher.Mono;

public interface SeatService {
	
	Mono<List<SeatResponse>> updateSeatStatus(List<SeatRequest> listSeatRequest);

}
