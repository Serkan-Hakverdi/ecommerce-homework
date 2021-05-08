package ecommerce.data.Access.concretes;

import java.util.ArrayList;
import java.util.List;

import ecommerce.data.Access.abstracts.UserDao;
import ecommerce.entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	private List<User> users = new ArrayList<User>();

	public InMemoryUserDao() {
		super();
		User user1 = new User(1, "Serkan", "Hakverdi", "serkan@gmail.com", "123456", true);
		User user2 = new User(2, "Ali", "Bolber", "ali@gmail.com", "784204", true);
		User user3 = new User(3, "Arzu", "G�r", "arzu@gmail.com", "941037", true);

		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	@Override
	public void add(User user) {
		System.out.println("Log inmemory: " + user.getePosta());
		users.add(user);

	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);

		userToUpdate.setePosta(user.getePosta());
		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setVerify(user.isVerify());

	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);

		users.remove(userToDelete);

	}

	@Override
	public List<User> getAll() {

		return users;
	}

	@Override
	public User get(String email) {
		User user = users.stream().filter(u -> u.getePosta() == email).findFirst().orElse(null);
		return user;
	}

}
