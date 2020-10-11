package com.pe.web.cine.app.dto.request;

import java.time.LocalDateTime;

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
public class CinemaRequest {

	private String name;
	
	private LocalDateTime startDateOperation;
	
	private Integer typeCinema;
	
	private Geolocation geolocation; 
	
}
