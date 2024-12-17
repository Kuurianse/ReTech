package model.Strategy;

public class CODStrategy implements PaymentStrategy {

	
	@Override
	public boolean pay(double amount) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please Pay " + amount + " To Courier Later");
		return true;
	}

}
