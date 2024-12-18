package com.ssk.HibernateDemo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "student_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	@Column(length = 50)
	private String street;
	@Column(length = 50)
	private String city;
	@Column(name = "is_open")
	private boolean isOpen;
	@Transient
	private double x;
	@Column(name="added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	@Lob
	private byte[] image;
}
