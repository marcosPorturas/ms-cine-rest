package com.pe.web.cine.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.cine.app.builder.ConvertBuilderRoom;
import com.pe.web.cine.app.dto.request.RoomRequest;
import com.pe.web.cine.app.dto.response.RoomResponse;
import com.pe.web.cine.app.entity.Room;
import com.pe.web.cine.app.repository.RoomRepository;

import io.reactivex.Single;


@Service
public class RoomServiceImplement implements RoomService{

	@Autowired
	RoomRepository roomRepository;
	
	public Room invokeBuilderRoom(RoomRequest roomRequest) {
		ConvertBuilderRoom convert = new ConvertBuilderRoom();
		return convert.convertToRoomEntity(roomRequest);
	}
	
	public RoomResponse invokeBuilderRoomResponse(Room room) {
		ConvertBuilderRoom convert = new ConvertBuilderRoom();
		return convert.convertToRoomResponse(room);
	}
	
	@Override
	public Single<RoomResponse> addRoom(RoomRequest roomRequest) {
		// TODO Auto-generated method stub
		return Single.just(roomRequest)
				.map(this::invokeBuilderRoom)
				.map(roomRepository::save)
				.map(room->roomRepository.findById(room.getCodRoom())
						.orElse(null))						
				.map(this::invokeBuilderRoomResponse);
	}
	

}
