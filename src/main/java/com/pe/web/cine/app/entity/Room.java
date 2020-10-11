package com.pe.web.cine.app.entity;

import java.time.LocalDateTime;

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
@Table(name="tbl_room")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codRoom;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime updateDate;
	
	private Integer enabled;
	
	@ManyToOne
	@JoinColumn(name="cod_cinema",referencedColumnName="cod_cinema")
	private Cinema cinema;
	
	private Integer numRoom;
	
	private Integer numRow;
	
	private Integer numSeat;
	
}
