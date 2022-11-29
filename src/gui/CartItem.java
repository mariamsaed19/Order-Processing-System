package gui;

public class CartItem {

	private String isbn;
	private String title;
	private double price;
	private String author;
	private String publisher;
	private String category;
	private String year;
	private int threshold;
	private int quantityInCart;
	
	
	public CartItem(String isbn, String title, double price, String author, String publisher, String category) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.quantityInCart = 0;
	}

	public CartItem(String isbn, String title, double price) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = "Author";
		this.publisher = "Publisher";
		this.category = "Category";
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



	public double getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public int getQuantityInCart() {
		return quantityInCart;
	}

	public void setQuantityInCart(int quantityInCart) {
		this.quantityInCart = quantityInCart;
	}

	public String getInfo() {
		return "ISBN number : " + this.isbn
				+ "\nTitle : " + this.title
				+ "\nAuthor : " + this.author
				+ "\nPublisher : " + this.publisher
				+ "\nCategory : " + this.category
				+ "\n\nPrice : " + this.price + "  L.E.";
	}

	@Override
	public String toString() {
		return "  " + this.title;// + "      " + this.price + "  L.E.";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
