package Factory;

import model.User;

public class UserFactory {

	private User user;
	
	public UserFactory(int id, String name, String email, String password, String role) {
	   this.user = new User(id, name, email, password, role);
	}
	
	public UserFactory(String name, String email, String password, String role) {
        this.user = new User(name, email, password, role);
    }
	 
	public User get() {
		return this.user;
	}
}
