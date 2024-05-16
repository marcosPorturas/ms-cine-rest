package com.cineplanet.cine.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_type_cinema",referencedColumnName="cod_type_cinema")
	private TypeCinema typeCinema;

}
