package cit285.book.domain;

public class Phone {
private int phoneid;
private int userid;
private String phonenumber;
/**
 * @return the phoneid
 */
public int getPhoneid() {
	return phoneid;
}
/**
 * @param phoneid the phoneid to set
 */
public void setPhoneid(int phoneid) {
	this.phoneid = phoneid;
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
 * @return the phonenumber
 */
public String getPhonenumber() {
	return phonenumber;
}
/**
 * @param phonenumber the phonenumber to set
 */
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
}
