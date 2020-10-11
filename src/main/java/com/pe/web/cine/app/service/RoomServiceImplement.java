package com.pe.web.cine.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pe.web.cine.app.builder.ConvertBuilderRoom;
import com.pe.web.cine.app.dto.request.RoomRequest;
import com.pe.web.cine.app.dto.response.RoomResponse;
import com.pe.web.cine.app.entity.Room;
import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.repository.RoomRepository;
import com.pe.web.cine.app.repository.SeatRepository;
import com.pe.web.cine.app.utilitario.Constants;

import io.reactivex.Single;


@Service
public class RoomServiceImplement implements RoomService{

	@Autowired
	Gson gson = new Gson();

	Logger logger = LoggerFactory.getLogger(RoomServiceImplement.class);
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	SeatRepository seatRepository;
	
	public RoomResponse addAllSeat(Room room){
		
		List<Seat> listSeat = new ArrayList<>();
		
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
		
		listSeat.forEach(seatRepository::save);
		
		return invokeBuilderRoomResponse(room,listSeat);
	}
	
	public Room invokeBuilderRoom(RoomRequest roomRequest) {
		ConvertBuilderRoom convert = new ConvertBuilderRoom();
		return convert.convertToRoomEntity(roomRequest);
	}
	
	public RoomResponse invokeBuilderRoomResponse(Room room,List<Seat> listSeat) {
		ConvertBuilderRoom convert = new ConvertBuilderRoom();
		return convert.convertToRoomResponse(room,listSeat);
	}
	
	@Override
	public Single<RoomResponse> addRoom(RoomRequest roomRequest) {
		// TODO Auto-generated method stub
		return Single.just(roomRequest)
				.map(this::invokeBuilderRoom)
				.map(roomRepository::save)
				.map(room->roomRepository.findById(room.getCodRoom())
						.orElse(null))
				.map(this::addAllSeat);
	}

	@Override
	public Single<RoomResponse> getRoomResponse(Integer codRoom) {
		// TODO Auto-generated method stub
		
		Single<Room> singleRoom = Single.just(roomRepository.findById(codRoom)
				.orElse(null));
		
		Single<List<Seat>> singleListSeat = Single
				.just(seatRepository.findByCodRoom(codRoom));
		
		return Single.zip(singleRoom,singleListSeat,
				(room,listSeat)->invokeBuilderRoomResponse(room,listSeat));
	}

}
