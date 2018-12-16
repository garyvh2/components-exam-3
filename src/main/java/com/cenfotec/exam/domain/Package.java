package com.cenfotec.exam.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Package {
	@Id
	private String id;
	private Date received;
	private String departureFlight;
	private Courier courier;
	private Invoice invoice;
	private Consignee consignee;
	private Boolean prealerted = false;
	// Constructor
	public Package() {
	}

	// Getters & Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getReceived() {
		return received;
	}

	public void setReceived(Date received) {
		this.received = received;
	}

	public String getDepartureFlight() {
		return departureFlight;
	}

	public void setDepartureFlight(String departureFlight) {
		this.departureFlight = departureFlight;
	}

	public Courier getCourier() {
		return courier;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Consignee getConsignee() {
		return consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}

	public Boolean getPrealerted() {
		return prealerted;
	}

	public void setPrealerted(Boolean prealerted) {
		this.prealerted = prealerted;
	}
	
}