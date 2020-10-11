package com.pe.web.cine.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_seat")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codSeat;
	
	@ManyToOne
	@JoinColumn(name="cod_room",referencedColumnName="cod_room")
	private Room room;
	
	private Integer positionRow;
	
	private Integer positionColumn;
	
	private Boolean statusSeat;
	
}
