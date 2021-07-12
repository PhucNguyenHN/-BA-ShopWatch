package com.shopwatch.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int price;
	private String images;
	
	@ManyToOne
	@JoinColumn(name = "id_brand")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "id_type")
	private TypeWatch typeWatch;
	
	@ManyToOne
	@JoinColumn(name = "id_gender")
	private GenderWatch genderWatch;
	
	private boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:MI:SS")
	private Date create_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:MI:SS")
	private Date update_at;
}
