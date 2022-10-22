package util;

public class Login {
	private static final String user = "jj";
	private static final String password = "jj";
	
	
	public Login () {
		
	}
	
	public static boolean logar(String userComp, String passwordComp) {
		
		if(user.equals(userComp) && password.equals(passwordComp)) {
			return true;
		}
		else {
			return false;
		}
	}
}
