package model.Strategy;

public class BankTransferStrategy implements PaymentStrategy {

	private String VirtualAccount = "AMBA182XCV66X";
	
	public BankTransferStrategy() {
	
	}
	@Override
	public boolean pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Please Pay Through This Virtual Account " + this.VirtualAccount);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
