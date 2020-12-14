package cit285.book.domain;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class User implements Serializable {

private int userid;
private String firstname;
private String lastname;
private String username;
private String password;
private Email email;
private static final long serialVersionUID = 1L;



/**
 * @return the firstname
 */
public String getFirstname() {
	return firstname;
}

/**
 * @param firstname the firstname to set
 */
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
/**
 * @return the lastname
 */
public String getLastname() {
	return lastname;
}
/**
 * @param lastname the lastname to set
 */
public void setLastname(String lastname) {
	this.lastname = lastname;
}
/*
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}

/**
 * @return the username
 */
public String getUsername() {
	return username;
}

/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}

/**
 * @return the userid
 */
public int getUserid() {
	return userid;
}

/**
 * @param userid the userid to set
 */
public void setUserid(int userid) {
	this.userid = userid;
}

/**
 * @return the email
 */
public Email getEmail() {
	return email;
}

/**
 * @param email the email to set
 */
public void setEmail(Email email) {
	this.email = email;
}


}
