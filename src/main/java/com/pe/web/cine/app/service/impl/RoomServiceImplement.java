package com.pe.web.cine.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pe.web.cine.app.builder.ConvertBuilderRoom;

import com.pe.web.cine.app.entity.Room;
import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.model.RoomRequest;
import com.pe.web.cine.app.model.RoomResponse;
import com.pe.web.cine.app.repository.RoomRepository;
import com.pe.web.cine.app.repository.SeatRepository;
import com.pe.web.cine.app.service.RoomService;
import com.pe.web.cine.app.utilitario.Constants;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class RoomServiceImplement implements RoomService{
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	Gson gson;
	
	
	@Override
	public Mono<RoomResponse> addRoom(RoomRequest roomRequest) {
		// TODO Auto-generated method stub
		return Mono.just(roomRequest)
				.map(this::invokeBuilderRoom)
				.map(entity -> roomRepository.save(entity))
				.map(save -> invokeBuilderRoomResponse(save, this.createListSeatEntity(save)));
	}

	@Override
	public Mono<RoomResponse> getRoomResponse(Integer codRoom) {
		// TODO Auto-generated method stub
		
		Mono<Room> singleRoom = Mono.just(roomRepository.findById(codRoom)
				.orElse(null));
		
		Mono<List<Seat>> singleListSeat = Mono
				.just(seatRepository.findByCodRoom(codRoom));
		
		return Mono.zip(singleRoom,singleListSeat,
				(room,listSeat)->invokeBuilderRoomResponse(room,listSeat));
	}
	
	private List<Seat> createListSeatEntity(Room room) {
		List<Seat> listSeat = new ArrayList<>();
		List<Seat> listSeatSave = new ArrayList<>();
		
		log.info("Iniciando metodo de creacion de Butacas");
		
		IntStream.range(1, room.getNumRow()+1)
				.forEach(row->
				IntStream.range(1, room.getNumSeat()+1)
					.forEach(seat->listSeat.add(Seat
							.builder()
							.room(room)
							.positionColumn(seat)
							.positionRow(row)
							.statusSeat(Constants.FLAG_TRUE)
							.build())));
		listSeat.forEach(x -> listSeatSave.add(seatRepository.save(x)));
		return listSeatSave;
		
		
	}
	
	private Room invokeBuilderRoom(RoomRequest roomRequest) {
		ConvertBuilderRoom convert = new ConvertBuilderRoom();
		return convert.convertToRoomEntity(roomRequest);
	}
	
	private RoomResponse invokeBuilderRoomResponse(Room room,List<Seat> listSeat) {
		ConvertBuilderRoom convert = new ConvertBuilderRoom();
		return convert.convertToRoomResponse(room,listSeat);
	}

}
