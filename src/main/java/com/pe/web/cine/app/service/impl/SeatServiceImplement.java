package com.pe.web.cine.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.model.SeatRequest;
import com.pe.web.cine.app.model.SeatResponse;
import com.pe.web.cine.app.repository.SeatRepository;
import com.pe.web.cine.app.service.SeatService;
import com.pe.web.cine.app.utilitario.Constants;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class SeatServiceImplement implements SeatService{
	
	@Autowired
	SeatRepository seatRepository;
	
	public Boolean getStatus(SeatRequest seatRequest) {
		Boolean status = false;
		if(seatRequest.getStatusSeat().equals("1"))status = true;
		return status;
	}

	@Override
	public Mono<List<SeatResponse>> updateSeatStatus(List<SeatRequest> listSeatRequest) {
		// TODO Auto-generated method stub	
		return Flux.fromIterable(listSeatRequest)
				.map(seat -> {
					Seat obj = seatRepository.findById(seat.getCodSeat()).orElseThrow();
					obj.setStatusSeat(seat.getStatusSeat().equals("1")?true:false);
					return obj;	
				})
				.map(find -> {
					Seat obj = seatRepository.save(find);
					return obj;
				})
				.map(save -> convertToSeatResponse(save))
				.collectList();
				
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
	
	

}
