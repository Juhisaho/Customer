package com.customer.harjoitus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    private String customerFirstName;
	private String customerLastName;
	private String customerAddress;
	private String customerPostcode;
	private String customerCity;
	private String phone;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;

	

}