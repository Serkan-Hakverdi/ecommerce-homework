package ecommerce.bussines.concretes;



import ecommerce.bussines.abstracts.AuthService;
import ecommerce.bussines.abstracts.UserService;
import ecommerce.core.utils.Utils;
import ecommerce.entities.concretes.LoginDto;
import ecommerce.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if (userValidate(user) && passwordValidate(user.getPassword()) && userExists(user.getePosta()) == false
				&& Utils.emailValidate(user.getePosta())) {
			userService.add(user);
		} else {
			System.out.println("Kayıt Başarısız");
		}

	}

	@Override
	public void verify(User user, String token) {
		if (user != null && token.length() > 15) {
			User existUser = userService.get(user.getePosta());
			existUser.setVerify(true);

			userService.update(existUser);
			System.out.println("Email Doğrulandı");
		}

		else {
			System.out.println("Email Doğrulanamadı");
		}

	}

	@Override
	public void login(LoginDto dto) {
		User user = userService.get(dto.getEmail());
		if (user != null && user.getPassword().equals(dto.getPassword())) {
			System.out.println("Başarıyla giriş yaptınız.");

		} else {
			System.out.println("Kullanıcı adın veya Şifren Yanlış");
		}

	}

	@Override
	public boolean userExists(String email) {
		
		
		User user = userService.get(email);
		
		if (user == null) {
			return false;

		}
		System.out.println("Email Mevcut!" + email);

		return true;
	}

	public boolean userValidate(User user) {

		if (user != null && !user.getName().isEmpty() && !user.getLastName().isEmpty() && !user.getePosta().isEmpty()
				&& !user.getPassword().isEmpty()) {
			return true;

		}
		System.out.println("Boş Alan Bırakmayınız");
		return false;

	}

	public boolean passwordValidate(String password) {
		if (password.length() >= 6) {
			return true;
		}
		System.out.println("Şifreniz 6 karakterden daha uzun olmalıdır");
		return false;
	}

}
