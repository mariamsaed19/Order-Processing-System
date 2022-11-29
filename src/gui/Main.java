package gui;

import javax.swing.DefaultListModel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static DefaultListModel<CartItem> getSearchResult(){  //TODO : fetch from database
		DefaultListModel<CartItem> searchResults = new DefaultListModel<CartItem>();  //TODO
		/*searchResults.addElement(new CartItem(1, "journy to the center of the earth", 50, "J.K.", "Person", "Science"));
		searchResults.addElement(new CartItem(2, "oliver twist", 60));
		searchResults.addElement(new CartItem(3, "data structures and algorithms", 40));
		searchResults.addElement(new CartItem(4, "the idot brain", 70));
		searchResults.addElement(new CartItem(1, "journy to the center of the earth", 50));
		searchResults.addElement(new CartItem(2, "oliver twist", 60));
		searchResults.addElement(new CartItem(3, "data structures and algorithms", 40));
		searchResults.addElement(new CartItem(4, "the idot brain", 70));
		CartItem special = new CartItem(1, "special story", 50);
		special.setQuantityInCart(15);
		searchResults.addElement(special);
		searchResults.addElement(new CartItem(2, "oliver twist", 60));
		searchResults.addElement(new CartItem(3, "data structures and algorithms", 40));
		searchResults.addElement(new CartItem(4, "the idot brain", 70));
		/*searchResults.addElement(new CartItem(1, "journy to the center of the earth", 50));
		searchResults.addElement(new CartItem(2, "oliver twist", 60));
		searchResults.addElement(new CartItem(3, "data structures and algorithms", 40));
		searchResults.addElement(new CartItem(4, "the idot brain", 70));*/
		return searchResults;
	}

}
