package cit285.book.service;
import cit285.book.dao.LoginDao;
import cit285.book.domain.Login;

public class LoginService implements LoginServiceAPI {
	static LoginDao loginDao;
	
	public LoginService() {
		loginDao = new LoginDao();
	}
	
	public static int loginUser(String username,String password) {
    Login loginBean = new Login();
    loginBean.setUsername(username);
    loginBean.setPassword(password);
    int x = 0;
	try {
		x = loginDao.validate(loginBean);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return x;
    
	}
	
}
