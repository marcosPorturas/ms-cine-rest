package com.pe.web.cine.app.service;

import com.pe.web.cine.app.dto.request.RoomRequest;
import com.pe.web.cine.app.dto.response.RoomResponse;

import reactor.core.publisher.Mono;

public interface RoomService {

	Mono<RoomResponse> addRoom(RoomRequest roomRequest);
	
	Mono<RoomResponse> getRoomResponse(Integer codRoom);
}
