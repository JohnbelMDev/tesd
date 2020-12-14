package cit285.book.service;

import cit285.book.dao.Userdao;
import cit285.book.domain.Email;
import cit285.book.domain.User;

public class UserService implements UserServiceAPI {
	static Userdao userDao;
	public UserService() {
		userDao = new Userdao();
	}
	
	public static void addUser(String firstName, String lastName, 
			String username,String password, String email) {
    User user = new User();
    Email userEmail = new Email();
    user.setFirstname(firstName);
    user.setLastname(lastName);
    user.setUsername(username);
    user.setPassword(password);
    userEmail.setEmailaddress(email);
    
    try {
        userDao.registerEmployee(user, userEmail);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
	}
	
}
