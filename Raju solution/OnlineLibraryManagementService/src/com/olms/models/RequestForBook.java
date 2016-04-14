package com.olms.models;

import java.time.LocalDate;

public class RequestForBook {

	private Book book;

	private User requestTo;

	private User requestBy;

	private LocalDate createdDate;

	private LocalDate statusChanged;
	
	private String discription;

	private RequestType requestType;

	private RequestStatus status;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getRequestTo() {
		return requestTo;
	}

	public void setRequestTo(User requestTo) {
		this.requestTo = requestTo;
	}

	public User getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(User requestBy) {
		this.requestBy = requestBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getStatusChanged() {
		return statusChanged;
	}

	public void setStatusChanged(LocalDate statusChanged) {
		this.statusChanged = statusChanged;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

}
