package ecommerce;

import ecommerce.bussines.concretes.AuthManager;
import ecommerce.bussines.concretes.UserManager;
import ecommerce.core.AmazonMailManagerAdapter;
import ecommerce.core.GoogleMailManagerAdapter;
import ecommerce.data.Access.concretes.InMemoryUserDao;
import ecommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
//		UserManager userManager = new UserManager(new InMemoryUserDao(), new AmazonMailManagerAdapter());
		User Mert = new User(4,"Mert","Çakmak","mert@gmail.com","147845",true);
//		userManager.add(Mert);
		
		User enes = new User(2, "Hilmi", "Þafak", "hilmi@gmail.com", "784198", false);
//		userManager.update(enes);
		
		
		InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
		GoogleMailManagerAdapter googleMailManagerAdapter = new GoogleMailManagerAdapter();
		AmazonMailManagerAdapter amazonMailManagerAdapter = new AmazonMailManagerAdapter();
		
		
		AuthManager authManager = new AuthManager(new UserManager(new InMemoryUserDao() , new GoogleMailManagerAdapter()));
		//authManager.register(Mert);
		authManager.register(Mert);
		UserManager userManager = new UserManager(new InMemoryUserDao() , new AmazonMailManagerAdapter());
		userManager.getAll();
		
		//userManager.getAll();
	}

}
