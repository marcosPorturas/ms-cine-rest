package com.pe.web.cine.app.builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pe.web.cine.app.entity.Cinema;
import com.pe.web.cine.app.entity.Room;
import com.pe.web.cine.app.entity.RoomSeatsParam;
import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.model.InfoCinema;
import com.pe.web.cine.app.model.RoomRequest;
import com.pe.web.cine.app.model.RoomResponse;
import com.pe.web.cine.app.model.SeatResponse;
import com.pe.web.cine.app.utilitario.Constants;
import com.pe.web.cine.app.utilitario.Util;

public class ConvertBuilderRoom {

		public RoomResponse convertToRoomResponse(RoomSeatsParam roomSeatsParam) {
			RoomResponse roomResponse = new RoomResponse();
			roomResponse.setCodRoom(roomSeatsParam.getRoomEntity().getCodRoom());
			roomResponse.setCreationDate(Util
					.convertToStringDate(roomSeatsParam.getRoomEntity().getCreationDate()));
			roomResponse.setNumRoom(roomSeatsParam.getRoomEntity().getNumRoom());
			roomResponse.setNumRow(roomSeatsParam.getRoomEntity().getNumRow());
			roomResponse.setNumSeat(roomSeatsParam.getRoomEntity().getNumSeat());
			roomResponse.setInfoCinema(this.convertToInfoCinema(roomSeatsParam
					.getRoomEntity().getCinema()));
			roomResponse.setListSeat(this.convertToListSeat(roomSeatsParam.getSeatListEntity()));
			return roomResponse;
		}

		public List<SeatResponse> convertToListSeat(List<Seat> seatList) {
			List<SeatResponse> seatResponseList = new ArrayList<>();
			seatList.forEach(seat -> {
				SeatResponse seatResponse = new SeatResponse();
				seatResponse.setCodSeat(seat.getCodSeat());
				seatResponse.setPositionColumn(seat.getPositionColumn());
				seatResponse.setPositionRow(seat.getPositionRow());
				seatResponse.setStatusSeat(seat.getStatusSeat() == true ? Constants.STRING_DISPONIBLE:Constants.STRING_RESERVADO);
				seatResponseList.add(seatResponse);
			});
			return seatResponseList;
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

		public InfoCinema convertToInfoCinema(Cinema cinema) {
			InfoCinema infoCinema = new InfoCinema();
			infoCinema.setCodCinema(cinema.getCodCinema());
			infoCinema.setName(cinema.getName());
			return infoCinema;
		}
}
