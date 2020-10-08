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
public class CinemaResponse {

	private Integer codCinema;
	
	private String name;
	
	private String startDateOperation;
	
	private String typeCinema;
	
	private Geolocation geolocation;
	
	
	
}
