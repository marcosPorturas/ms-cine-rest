package com.pe.web.cine.app.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="tbl_cinema")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cinema {

	@Id
	@Column(name="cod_cinema")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codCinema;
	
	private String name;
	
	private Integer enabled;
	
	private String department;
	
	private String province;
	
	private String district;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime startDateOperation;

	@ManyToOne
	@JoinColumn(name="cod_type_cinema",referencedColumnName="cod_type_cinema")
	private TypeCinema typeCinema;
	
}
