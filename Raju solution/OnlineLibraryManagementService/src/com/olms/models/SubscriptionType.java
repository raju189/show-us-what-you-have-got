package com.olms.models;

public enum SubscriptionType {
	GOLD("Gold"), SILVER("Silver"), BRONZE("Bronze");

	private String name;

	private SubscriptionType(String name) {
		this.name = name;
	}

	public static SubscriptionType getSubScriptionType(String name) {
		for (SubscriptionType sub : values()) {
			if (name.equals(sub.name)) {
				return sub;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
}
