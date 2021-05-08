package ecommerce.data.Access.abstracts;

import java.util.List;

import ecommerce.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(int userId );
	User get(String email);
	List<User> getAll();

}
