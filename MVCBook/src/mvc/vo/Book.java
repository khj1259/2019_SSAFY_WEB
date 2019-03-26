package mvc.vo;
//vo(value object) : 값을 저장하기 위한 용도의 객체
public class Book {
	private String isbn;
	private String title;
	private String catalogue;
	private String nation;
	private String date;
	private String publisher;
	private String author;
	private int price;
	private String currency;
	private String description;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String isbn, String title, String catalogue, String nation, String date, String publisher,
			String author, int price, String currency, String description) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.catalogue = catalogue;
		this.nation = nation;
		this.date = date;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.currency = currency;
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
