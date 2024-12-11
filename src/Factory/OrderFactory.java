package Factory;

import model.Order;

public class OrderFactory {

	private Order order;

	public OrderFactory(int id, int userId, double totalPrice, String status) {
	
		this.order = new Order(id, userId, totalPrice, status);
	}
	
	public Order get() {
		return this.order;
	}
	
}
