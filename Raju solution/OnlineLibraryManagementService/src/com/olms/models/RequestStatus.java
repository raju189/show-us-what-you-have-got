package com.olms.models;

public enum RequestStatus {
	Approved("Approved"), Rejected("Rejected"), Pending("Pending");

	private String name;

	private RequestStatus(String name) {
		this.name = name;
	}

	public static RequestStatus getRequestStatus(String name) {
		for (RequestStatus status : values()) {
			if (status.name.equals(name)) {
				return status;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
}
