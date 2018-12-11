package iconix.appkademyj.util;

public class Login {

	public static int authenticate(final String username, final String password) {
		// hardcoded username and password
		if (username.equals("admin") && password.equals("ICONIX")) {
			return 1;
		}
		
		else if (username.equals("user") && password.equals("academy123")) {
			return 2;
		}
		return 0;
	}
}
