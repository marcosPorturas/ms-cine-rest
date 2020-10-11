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
public class SeatResponse {
	
	private Integer codSeat;
	
	private Integer positionRow;
	
	private Integer positionColumn;
	
	private String statusSeat;

}
