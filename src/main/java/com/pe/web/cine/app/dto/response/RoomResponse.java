package com.pe.web.cine.app.dto.response;

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
	
	private String cinema;
	
	private String creationDate;
	
	private Integer numRoom;
	
	private Integer numRow;
	
	private Integer numSeat;
	
	
}
