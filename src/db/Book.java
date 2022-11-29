package db;

public class Book {
	String ISBN;
	String title;
	String Author;
	String Publisher;
	String PublicationYear;
	double SellingPrice;
	String Category;
	int Threshold;
	int Quantity;

	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublicationYear() {
		return PublicationYear;
	}
	public void setPublicationYear(String publicationYear) {
		PublicationYear = publicationYear;
	}
	public double getSellingPrice() {
		return SellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		SellingPrice = sellingPrice;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getThreshold() {
		return Threshold;
	}
	public void setThreshold(int threshold) {
		Threshold = threshold;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
