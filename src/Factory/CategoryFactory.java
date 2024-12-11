package Factory;

import model.Category;

public class CategoryFactory {

	private Category category;
	
	public CategoryFactory(int id, String name) {
		this.category = new Category(id, name);
		// TODO Auto-generated constructor stub
	}
	
	public CategoryFactory(String name) {
		this.category = new Category(name);
		// TODO Auto-generated constructor stub
	}
	
	public Category get() {
		return this.category;
	}
}