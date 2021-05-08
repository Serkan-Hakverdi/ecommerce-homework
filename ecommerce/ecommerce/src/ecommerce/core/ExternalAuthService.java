package ecommerce.core;

import ecommerce.entities.concretes.LoginDto;
//import ecommerce.entities.concretes.User;

public interface ExternalAuthService {
	void register(String email);

	boolean userExists(String email);

	void login(LoginDto dto);

}
