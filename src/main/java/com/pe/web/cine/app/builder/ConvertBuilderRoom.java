package com.pe.web.cine.app.builder;

import java.time.LocalDateTime;
import java.util.List;

import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.entity.Room;
import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.model.InfoCinema;
import com.pe.web.cine.app.model.RoomRequest;
import com.pe.web.cine.app.model.RoomResponse;
import com.pe.web.cine.app.model.SeatResponse;
import com.pe.web.cine.app.utilitario.Constants;
import com.pe.web.cine.app.utilitario.Util;

public class ConvertBuilderRoom {

	public RoomResponse convertToRoomResponse(Room room,List<Seat> listSeat) {
		
	  InfoCinema infoCinema = new InfoCinema();
	  infoCinema.setCodCinema(room.getCinema().getCodCinema());
	  infoCinema.setName(room.getCinema().getName());
	  
	  RoomResponse roomResponse = new RoomResponse();
	  roomResponse.setCodRoom(room.getCodRoom());
	  roomResponse.setCreationDate(Util.convertToStringDate(room.getCreationDate()));
	  roomResponse.setInfoCinema(infoCinema);
	  roomResponse.setNumRoom(room.getNumRoom());
	  roomResponse.setNumRow(room.getNumRow());
	  roomResponse.setNumSeat(room.getNumSeat());
	  roomResponse.setListSeat(convertToListSeatResponse(listSeat));
	  return roomResponse;
	  
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
		return listSeat.stream()
				.map(seat -> convertToSeatResponse(seat))
				.toList();
				
	}
  
  	private SeatResponse convertToSeatResponse(Seat seat) {
	  SeatResponse seatResponse = new SeatResponse();
	  seatResponse.setCodSeat(seat.getCodSeat());
	  seatResponse.setPositionRow(seat.getPositionRow());
	  seatResponse.setPositionColumn(seat.getPositionColumn());
	  seatResponse.setStatusSeat(seat.getStatusSeat()?
				Constants.STRING_DISPONIBLE:Constants.STRING_RESERVADO);
	  return seatResponse;
  	}
	
  	private Cinema convertToCinema(RoomRequest roomRequest) {
		return Cinema.builder()
				.codCinema(roomRequest.getCodCinema())
				.build();
	}
}
