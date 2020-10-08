package com.pe.web.cine.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_type_cinema")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeCinema {
	
	@Id
	@Column(name="cod_type_cinema")
	private Integer codTypeCinema;
	
	private String description;

}
