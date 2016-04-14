package com.olms.models;

public class User {

	private long id;
	private String userName;
	private SubscriptionType subScription = SubscriptionType.BRONZE;
	private String phone;
	private String password;
	private String email;
	private boolean isMember;
	
	private String firstName;
	private String midleName;
	private String surName;
	private int age;
	
	private String city;
	private String country;
	private int bookCount;
	private int ebookCount;
	private Gender gender;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public SubscriptionType getSubScription() {
		return subScription;
	}

	public void setSubScription(SubscriptionType subScription) {
		this.subScription = subScription;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidleName() {
		return midleName;
	}

	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public int getEbookCount() {
		return ebookCount;
	}

	public void setEbookCount(int ebookCount) {
		this.ebookCount = ebookCount;
	}

	

	public User(String name, String password, String email, boolean isMember) {
		super();
		this.userName = name;
		this.password = password;
		this.email = email;
		this.isMember = isMember;
	}

	public User(String userName, SubscriptionType subScription, String firstName, String midleName, String surName, int age,
			String phone, String city, String country, int bookCount, int ebookCount, String password, String email,
			boolean isMember,Gender gender) {
		super();
		this.userName = userName;
		this.subScription = subScription;
		this.firstName = firstName;
		this.midleName = midleName;
		this.surName = surName;
		this.age = age;
		this.phone = phone;
		this.city = city;
		this.country = country;
		this.bookCount = bookCount;
		this.ebookCount = ebookCount;
		this.password = password;
		this.email = email;
		this.isMember = isMember;
		this.gender = gender;
	}

	
	public User(String userName, SubscriptionType subScription, String phone, int bookCount, int ebookCount, String password,
			String email, boolean isMember) {
		super();
		this.userName = userName;
		this.subScription = subScription;
		this.phone = phone;
		this.bookCount = bookCount;
		this.ebookCount = ebookCount;
		this.password = password;
		this.email = email;
		this.isMember = isMember;
	}

	public User() {
		super();
		id = 0;
		init();
	}

	private void init() {
		setSubScription(subScription);
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
