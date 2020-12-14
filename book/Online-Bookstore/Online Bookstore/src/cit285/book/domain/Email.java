package cit285.book.domain;

public class Email {
private int emailid;
private int userid;
private String emailaddress;
/**
 * @return the emailaddress
 */
public String getEmailaddress() {
	return emailaddress;
}
/**
 * @param emailaddress the emailaddress to set
 */
public void setEmailaddress(String emailaddress) {
	this.emailaddress = emailaddress;
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
 * @return the emailid
 */
public int getEmailid() {
	return emailid;
}
/**
 * @param emailid the emailid to set
 */
public void setEmailid(int emailid) {
	this.emailid = emailid;
}


}
