package com.olms.models;

public class Book {

	private long id;

	private String title;

	private String author;

	private String isdn;

	private boolean isEbook;

	private int count;

	public Book(String title, String author, String isdn, boolean isEbook) {
		super();
		this.title = title;
		this.author = author;
		this.isdn = isdn;
		this.isEbook = isEbook;
	}

	public Book() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsdn() {
		return isdn;
	}

	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}

	public boolean isEbook() {
		return isEbook;
	}

	public void setEbook(boolean isEbook) {
		this.isEbook = isEbook;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + count;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isEbook ? 1231 : 1237);
		result = prime * result + ((isdn == null) ? 0 : isdn.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isEbook != other.isEbook)
			return false;
		if (isdn == null) {
			if (other.isdn != null)
				return false;
		} else if (!isdn.equals(other.isdn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}