package ecommerce.bussines.concretes;

import java.util.List;

import ecommerce.bussines.abstracts.UserService;
import ecommerce.core.EmailService;
import ecommerce.data.Access.abstracts.UserDao;
import ecommerce.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private EmailService emailService;
	

	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		
	}
	
	@Override
	public void add(User user) {
		if(userValidate(user)) {
			userDao.add(user);
			System.out.println("Log: " + user.getePosta());
			emailService.send(user.getePosta(), "Kayýt oldunuz ");		}
		
	}

	@Override
	public void add(String email) {
		//if(!email.isEmpty()) {
			User user = new User();
			user.setePosta(email);
			userDao.add(user);
			System.out.println("Log: " + user.getePosta());
			emailService.send(user.getePosta(), "Kayýt oldunuz ");
		}

	//}

	@Override
	public void update(User user) {
		if (userValidate(user)) {
			userDao.update(user);
		}

	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);

	}

	@Override
	public List<User> getAll() {
		for (User user : userDao.getAll()) {
			System.out.println(user.getePosta() +" " + user.getFullName());
		}

		return userDao.getAll();
	}

	@Override
	public User get(String email) {

		return userDao.get(email);
	}

	public boolean userValidate(User user) {
		if (user.getName().length() >= 2 && user.getLastName().length() >= 2) {
			return true;

		}
		System.out.println("Adýnýz ve Soyadýnýz en az 2 karakter olmalýdýr.");
		return false;

	}





}
