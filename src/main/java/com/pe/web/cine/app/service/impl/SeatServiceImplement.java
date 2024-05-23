package com.pe.web.cine.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.cine.app.builder.ConvertBuilderRoom;
import com.pe.web.cine.app.dto.request.SeatRequest;
import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.model.SeatResponse;
import com.pe.web.cine.app.repository.SeatRepository;
import com.pe.web.cine.app.service.SeatService;

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
		List<Integer> idsSeat = new ArrayList<>();
		listSeatRequest.forEach(seat->idsSeat.add(seat.getCodSeat()));		
		return Mono.just(null);
	}
	
	private List<SeatResponse> convertBuilderListSeatRespone(List<Seat> listSeat){
		ConvertBuilderRoom convert = new ConvertBuilderRoom();
		return convert.convertToListSeatResponse(listSeat);
	}
	
	

}
