package ecommerce.bussines.abstracts;

import java.util.List;

import ecommerce.entities.concretes.User;

public interface UserService {
	void add(User user);
	void add(String email);
	void update(User user);
	void delete(int userId);
	User get(String email);
	List<User> getAll();


}
//Kullan�c� ��lemleri