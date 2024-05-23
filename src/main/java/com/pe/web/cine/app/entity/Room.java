package com.pe.web.cine.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	@Column(name="cod_room")
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
