package com.capg.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;

import com.capg.validation.ValidBookingDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@NotBlank(message = "Seat number is mandatory")
	private String seatNumber;
	
	@NotNull(message="Booking date is mandatory")

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	
	@ValidBookingDate
	private LocalDate bookingDate;
	
	@NotNull(message="Booking date is mandatory")
    private String bookingAddress;
	
	@Min(value = 1,message = "Duration should not be more than 1 day")

	private int duration;
	
	@NotBlank(message = "Email is mandatory")
	
	

	private String uemail_Id;

	public Booking() {
		super();
	}

	public Booking(int bookingId, String seatNumber, LocalDate bookingDate, String bookingAddress, int duration,
			String uemail_Id) {
		super();
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.bookingDate = bookingDate;
		this.bookingAddress = bookingAddress;
		this.duration = duration;
		this.uemail_Id = uemail_Id;

	}
	
	

	public int getBookingId() {
		return bookingId;
	}

	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	
	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingAddress() {
		return bookingAddress;
	}

	public void setBookingAddress(String bookingAddress) {
		this.bookingAddress = bookingAddress;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getUemail_Id() {
		return uemail_Id;
	}

	@Required
	public void setUemail_Id(String uemail_Id) {
		this.uemail_Id = uemail_Id;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", seatId=" + seatNumber + ", bookingDate=" + bookingDate
				+ ", bookingAddress=" + bookingAddress + ", duration=" + duration + ", uemail_Id=" + uemail_Id + "]";
	}

}
