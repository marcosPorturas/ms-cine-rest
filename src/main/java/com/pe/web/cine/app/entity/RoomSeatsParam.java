package com.pe.web.cine.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomSeatsParam {

    private Room roomEntity;
    private List<Seat> seatListEntity;

}
