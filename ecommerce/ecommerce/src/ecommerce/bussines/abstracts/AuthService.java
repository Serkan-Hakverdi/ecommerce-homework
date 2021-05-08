package ecommerce.bussines.abstracts;


import ecommerce.entities.concretes.LoginDto;
import ecommerce.entities.concretes.User;

public interface AuthService {
	void register(User user);

	void verify(User user, String token);

	boolean userExists(String email);

	void login(LoginDto dto);
	
	

}
