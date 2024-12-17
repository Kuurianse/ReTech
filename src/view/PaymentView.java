package view;

import java.util.Scanner;

import controller.CartController;
import controller.PaymentController;

public class PaymentView {

	private PaymentController paymentController;
	private Scanner scanner;

	
	public PaymentView(CartController controller) {
		this.paymentController = new PaymentController(controller);
		this.scanner = new Scanner(System.in);
	}
	
	public void choosePaymentMethod() {
		System.out.println("Select Payment Method You're Desired");
		System.out.println("1. Cash On Delivery (COD)");
		System.out.println("2. Credit Card");
		System.out.println("3. Bank Transfer");
		
		this.paymentController.choosePaymentMethod(this.scanner.nextInt());
	}
	
	public void displayCheckout() {
		this.choosePaymentMethod();
		this.paymentController.paymentCheckout();
	}


	
}
