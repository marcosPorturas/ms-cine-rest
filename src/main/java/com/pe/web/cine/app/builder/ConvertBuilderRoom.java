package com.pe.web.cine.app.builder;

import java.time.LocalDateTime;

import com.pe.web.cine.app.dto.request.RoomRequest;
import com.pe.web.cine.app.dto.response.RoomResponse;
import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.entity.Room;
import com.pe.web.cine.app.utilitario.Constants;
import com.pe.web.cine.app.utilitario.Util;

public class ConvertBuilderRoom {

	public RoomResponse convertToRoomResponse(Room room) {
		return RoomResponse.builder()
				.codRoom(room.getCodRoom())
				.creationDate(Util.convertToStringDate(room.getCreationDate()))
				.cinema(room.getCinema().getName())
				.numRoom(room.getNumRoom())
				.numRow(room.getNumRow())
				.numSeat(room.getNumSeat())
				.build();
	}
	
	public Room convertToRoomEntity(RoomRequest roomRequest) {
		return Room.builder()
				.creationDate(LocalDateTime.now())
				.cinema(convertToCinema(roomRequest))
				.enabled(Constants.ENABLED)
				.numRoom(roomRequest.getNumRoom())
				.numRow(roomRequest.getNumRow())
				.numSeat(roomRequest.getNumSeat())
				.build();
	}
	
	public Cinema convertToCinema(RoomRequest roomRequest) {
		return Cinema.builder()
				.codCinema(roomRequest.getCodCinema())
				.build();
	}
}
