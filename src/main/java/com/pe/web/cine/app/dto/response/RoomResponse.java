package com.pe.web.cine.app.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {

	private Integer codRoom;
	
	private InfoCinema infoCinema;
	
	private String creationDate;
	
	private Integer numRoom;
	
	private Integer numRow;
	
	private Integer numSeat;
	
	private List<SeatResponse> listSeat;
	
	
}
