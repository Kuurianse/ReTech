package Factory;

import model.Product;

public class ProductFactory {

	private Product product;

	public ProductFactory(int id, String name, String description, double price, int stock, int categoryId) {
		
		this.product = new Product(id, name, description, price, stock, categoryId);
	}
	
	  public ProductFactory(int id, String name, String description, double price, int stock) {
	        this.product = new Product(id, name, description, price, stock);
	    }

	    // Constructor untuk produk baru (tanpa ID)
	    public ProductFactory(String name, String description, double price, int stock) {
	        this.product = new Product(name, description, price, stock);
	    }
	
	public Product get() {
		return this.product;
	}
	
	
}
