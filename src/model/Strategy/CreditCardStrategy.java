package model.Strategy;

public class CreditCardStrategy implements PaymentStrategy {

	
	private String cardNumber;
	private String cvv;
	private String expiryDate;

	public CreditCardStrategy(String cardNumber, String cvv, String expiryDate) {
	    this.cardNumber = cardNumber;
	    this.cvv = cvv;
	    this.expiryDate = expiryDate;
	}

	    public boolean pay(double amount) {
	    	System.out.println("Awaiting Payment Confirmation");
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println("Paying " + amount + " via Credit Card");

	 return true; 
	    }
	
}
