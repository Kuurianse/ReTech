package controller;

import model.Strategy.CODStrategy;
import model.Strategy.CreditCardStrategy;

import java.util.Scanner;

import model.Strategy.BankTransferStrategy;
import model.Strategy.PaymentStrategy;

public class PaymentController {

	private PaymentStrategy paymentStrategy;
	private CartController cartController;
	private Scanner scanner = new Scanner(System.in);
	public PaymentController(CartController cartController) {
		this.cartController = cartController;
	}
	
	public void choosePaymentMethod(int paymentType) {
		 switch (paymentType) {
         case 1:
             this.paymentStrategy = new CODStrategy();
             break;
         case 2:
        	 String cardNumber, CCV, expiryDate;
        	 System.out.println("Enter Card Number");
        	 cardNumber = this.scanner.next();
        	 System.out.println("Enter CCV");
        	 CCV = this.scanner.next();
        	 System.out.println("Enter Expiry Date");
        	 expiryDate = this.scanner.next();
             this.paymentStrategy = new CreditCardStrategy(
                 cardNumber, CCV, expiryDate
             );
             break;
         case 3:
             this.paymentStrategy = new BankTransferStrategy();
             break;
         default:
             throw new IllegalArgumentException("Invalid payment method");
     }
	}
	
	public PaymentStrategy getPaymentStrategy() {
		return this.paymentStrategy;
	}
	
	public boolean paymentCheckout() {
		if(this.cartController.checkCart()) {
			if(!this.paymentStrategy.pay(this.cartController.getCartTotal())) {
				return false;
			}
			
			if(!this.cartController.clearCartItems()) {
				return false;
			}
			
			return true;
			
		}
		
		return false;
		
	}
}
