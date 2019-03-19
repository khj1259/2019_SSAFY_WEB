package com.ssafy;

public class Book {
	private String num;
	private String title;
	private String kind;
	private String country;
	private String date;
	private String publisher;
	private String name;
	private String price;
	private String summary;
	
	public Book(String num, String title, String kind, String country, String date, String publisher, String name,
			String price, String summary) {
		super();
		this.num = num;
		this.title = title;
		this.kind = kind;
		this.country = country;
		this.date = date;
		this.publisher = publisher;
		this.name = name;
		this.price = price;
		this.summary = summary;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
