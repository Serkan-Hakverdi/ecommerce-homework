package ecommerce.core;

import ecommerce.bussines.abstracts.UserService;
import ecommerce.entities.concretes.LoginDto;
import ecommerce.entities.concretes.User;

public class GoogleAuthManagerAdapter implements ExternalAuthService {
	
	private UserService userService;
	
	public  GoogleAuthManagerAdapter(UserService userService) {
		super();
		this.userService=userService;
		
	}
	
	@Override
	public void register(String email) {
		if(userExists(email)==false) {
			userService.add(email);
		}
		else {
			User user = userService.get(email);
			
			LoginDto dto = new LoginDto();
			dto.setEmail(user.getePosta());
			dto.setPassword(user.getPassword());
			
			login(dto);
			
		
		}
		
		
		
	}

	@Override
	public boolean userExists(String email) {
		if (userService.get(email) != null) {
			return true;

		}
		return false;
	}

	@Override
	public void login(LoginDto dto) {
		if(dto != null && dto.getEmail().equals(dto.getPassword())) {
			System.out.println("Baþarýyla Giriþ yaptýnýz");
		}
		else {
			System.out.println("Kullancý adý veya þifren yanlýþ");
		}
	}

}
