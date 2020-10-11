package com.pe.web.cine.app.builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.pe.web.cine.app.dto.request.RoomRequest;
import com.pe.web.cine.app.dto.response.RoomResponse;
import com.pe.web.cine.app.dto.response.SeatResponse;
import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.entity.Room;
import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.utilitario.Constants;
import com.pe.web.cine.app.utilitario.Util;

public class ConvertBuilderRoom {

	public RoomResponse convertToRoomResponse(Room room,List<Seat> listSeat) {
		return RoomResponse.builder()
				.codRoom(room.getCodRoom())
				.creationDate(Util.convertToStringDate(room.getCreationDate()))
				.cinema(room.getCinema().getName())
				.numRoom(room.getNumRoom())
				.numRow(room.getNumRow())
				.numSeat(room.getNumSeat())
				.listSeat(convertToListSeatResponse(listSeat))
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
	
	public List<SeatResponse> convertToListSeatResponse(List<Seat> listSeat){
		return listSeat.stream().map(seat->
						SeatResponse.builder()
						.codSeat(seat.getCodSeat())
						.positionRow(seat.getPositionRow())
						.positionColumn(seat.getPositionColumn())
						.statusSeat(seat.getStatusSeat()?
								Constants.STRING_DISPONIBLE:Constants.STRING_RESERVADO)
						.build())
				.collect(Collectors.toList());
	}
	
	public Cinema convertToCinema(RoomRequest roomRequest) {
		return Cinema.builder()
				.codCinema(roomRequest.getCodCinema())
				.build();
	}
}
