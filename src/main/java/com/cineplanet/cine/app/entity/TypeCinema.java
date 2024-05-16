package com.cineplanet.cine.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_cinema")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeCinema {
	
	@Id
	@Column(name="cod_type_cinema")
	private Integer codTypeCinema;
	
	private String description;

}
