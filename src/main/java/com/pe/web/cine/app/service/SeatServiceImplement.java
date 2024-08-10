package com.pe.web.cine.app.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.cine.app.builder.ConvertBuilderRoom;
import com.pe.web.cine.app.dto.request.SeatRequest;
import com.pe.web.cine.app.dto.response.SeatResponse;
import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.repository.SeatRepository;

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
	
	public List<SeatResponse> convertBuilderListSeatRespone(List<Seat> listSeat){
		ConvertBuilderRoom convert = new ConvertBuilderRoom();
		return convert.convertToListSeatResponse(listSeat);
	}

	@Override
	public Mono<List<SeatResponse>> updateSeatStatus(List<SeatRequest> listSeatRequest) {
		// TODO Auto-generated method stub
		List<Integer> idsSeat = new ArrayList<>();
		listSeatRequest.forEach(seat->idsSeat.add(seat.getCodSeat()));		
		
		return Flux.fromIterable(listSeatRequest)
				.map(seatRequest->{
					Seat seat = seatRepository.findById(seatRequest.getCodSeat())
							.orElse(null);
					seat.setStatusSeat(getStatus(seatRequest));
					return seatRepository.save(seat);
				})
				.collectSortedList(Comparator.comparingInt(Seat::getCodSeat))
				.map(this::convertBuilderListSeatRespone);
	}
	
	

}
