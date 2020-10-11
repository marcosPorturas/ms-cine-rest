package com.pe.web.cine.app.service;

import com.pe.web.cine.app.dto.request.RoomRequest;
import com.pe.web.cine.app.dto.response.RoomResponse;

import io.reactivex.Single;

public interface RoomService {

	Single<RoomResponse> addRoom(RoomRequest roomRequest);
	
	Single<RoomResponse> getRoomResponse(Integer codRoom);
}
