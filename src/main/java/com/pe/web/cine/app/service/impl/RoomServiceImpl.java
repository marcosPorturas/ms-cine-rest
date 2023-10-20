package com.pe.web.cine.app.service.impl;

import com.pe.web.cine.app.builder.ConvertBuilderRoom;
import com.pe.web.cine.app.entity.Room;
import com.pe.web.cine.app.entity.RoomSeatsParam;
import com.pe.web.cine.app.entity.Seat;
import com.pe.web.cine.app.model.RoomRequest;
import com.pe.web.cine.app.model.RoomResponse;
import com.pe.web.cine.app.repository.RoomRepository;
import com.pe.web.cine.app.repository.SeatRepository;
import com.pe.web.cine.app.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    SeatRepository seatRepository;

    @Override
    public Mono<RoomResponse> addRoom(RoomRequest roomRequest) {
        return Mono.just(convertToRoomEntity(roomRequest))
                .map(entity -> roomRepository.save(entity))
                .map(saveEntity -> {
                    List<Seat> seatList = seatRepository
                            .saveAll(this.addSeatIntoRoom(saveEntity));
                    RoomSeatsParam roomSeatsParam = new RoomSeatsParam();
                    roomSeatsParam.setRoomEntity(saveEntity);
                    roomSeatsParam.setSeatListEntity(seatList);
                    return roomSeatsParam;
                })
                .map(this::convertToRoomResponse);
    }

    @Override
    public Mono<RoomResponse> getRoomResponse(Integer codRoom) {
        return Mono.just(roomRepository.findById(codRoom).orElse(null))
                .map(roomEntity ->{
                    List<Seat> seatList = seatRepository.findByCodRoom(roomEntity.getCodRoom());
                    RoomSeatsParam roomSeatsParam = new RoomSeatsParam();
                    roomSeatsParam.setRoomEntity(roomEntity);
                    roomSeatsParam.setSeatListEntity(seatList);
                    return roomSeatsParam;
                })
                .map(this::convertToRoomResponse);
    }

    private List<Seat> addSeatIntoRoom(Room room) {
        int rowAdd = room.getNumRow();
        int seatAdd = room.getNumSeat();
        List<Seat> seatList = new ArrayList<>();
        IntStream.range(1,rowAdd+1)
                .forEach(rowElement -> IntStream.range(1,seatAdd+1)
                        .forEach(seatElement -> {
                            Seat seatEntity = new Seat();
                            seatEntity.setPositionRow(rowElement);
                            seatEntity.setPositionColumn(seatElement);
                            seatEntity.setRoom(room);
                            seatEntity.setStatusSeat(true);
                            seatList.add(seatEntity);
                        }));
        return seatList;
    }

    public RoomResponse convertToRoomResponse(RoomSeatsParam roomSeatParam) {
        ConvertBuilderRoom builderRoom =  new ConvertBuilderRoom();
        return builderRoom.convertToRoomResponse(roomSeatParam);
    }

    public Room convertToRoomEntity(RoomRequest roomRequest) {
        ConvertBuilderRoom builderRoom = new ConvertBuilderRoom();
        return builderRoom.convertToRoomEntity(roomRequest);
    }

}
