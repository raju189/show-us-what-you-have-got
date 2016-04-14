package com.olms.models;

import java.time.LocalDate;

public class ApprovedRequest {

	private Book book;
	
	private User approvedTo;
	
	private RequestForBook request;
	
	private User approvedBy;
	
	private LocalDate approvedDate;
	
	private LocalDate  dueDate;
	
	private boolean isRenewal;
	
	private ApprovedStatus  status;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getApprovedTo() {
		return approvedTo;
	}

	public void setApprovedTo(User approvedTo) {
		this.approvedTo = approvedTo;
	}

	public RequestForBook getRequest() {
		return request;
	}

	public void setRequest(RequestForBook request) {
		this.request = request;
	}

	public User getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	public LocalDate getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDate approvedDate) {
		this.approvedDate = approvedDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isRenewal() {
		return isRenewal;
	}

	public void setRenewal(boolean isRenewal) {
		this.isRenewal = isRenewal;
	}

	public ApprovedStatus getStatus() {
		return status;
	}

	public void setStatus(ApprovedStatus status) {
		this.status = status;
	}
}
