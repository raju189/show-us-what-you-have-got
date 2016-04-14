package com.olms.models;

public enum ApprovedStatus {
	Open("Open"),Close("Close");
	
	private String name;

	private ApprovedStatus(String name) {
		this.name = name;
	}

	public static ApprovedStatus getApprovedStatus(String name) {
		for (ApprovedStatus status : values()) {
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
