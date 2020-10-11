package com.pe.web.cine.app.dto.request;

import java.time.LocalDateTime;

import com.pe.web.cine.app.dto.request.CinemaRequest.CinemaRequestBuilder;
import com.pe.web.cine.app.dto.response.Geolocation;

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
public class RoomRequest {
	
	private Integer codCinema;
	private Integer numRow;
	private Integer numSeat;
	private Integer numRoom;

}
