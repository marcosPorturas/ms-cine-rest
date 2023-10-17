package com.pe.web.cine.app.builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.entity.Room;
import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.model.RoomRequest;
import com.pe.web.cine.app.model.RoomResponse;
import com.pe.web.cine.app.model.SeatResponse;
import com.pe.web.cine.app.utilitario.Constants;
import com.pe.web.cine.app.utilitario.Util;

public class ConvertBuilderRoom {

	public RoomResponse convertToRoomResponse(Room room, List<Seat> listSeat) {
		return null;
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
	
	public List<SeatResponse> convertToListSeatResponse(List<Seat> listSeat){
		return null;
	}
	
	public Cinema convertToCinema(RoomRequest roomRequest) {
		return Cinema.builder()
				.codCinema(roomRequest.getCodCinema())
				.build();
	}
}
