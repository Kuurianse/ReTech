package Factory;

import model.CartItem;

public class CartItemFactory {

	private CartItem cartItem;
	
	public CartItemFactory(int productId, String productName, int quantity, double price) {
	   this.cartItem = new CartItem(productId, productName, quantity, price);
	}
	  
	public CartItem get() {
		return this.cartItem;
	}
}
