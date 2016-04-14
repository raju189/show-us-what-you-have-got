package com.olms.models;

public enum Gender {
	MALE("Male"), FEMALE("Female"), OTHER("Other");
	private String name;

	private Gender(String name) {
		this.name = name;
	}

	public static Gender getGender(String name) {
		for (Gender gender : values()) {
			if (gender.name.equals(name)) {
				return gender;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
}
