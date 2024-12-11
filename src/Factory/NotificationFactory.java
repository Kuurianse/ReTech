package Factory;

import model.Notification;

public class NotificationFactory {

	private Notification notification;
	
	public NotificationFactory(String message) {
		this.notification = new Notification(message);
	}
	
	public Notification get() {
		return this.notification;
	}
}
