package cit285.book.domain;

import java.sql.Date;

public class Invoice {
private int invoiceid;
private int userid;
private Date invoicedate;
private float totalamount;
private boolean isprocessed;
public int getInvoiceid() {
	return invoiceid;
}
public void setInvoiceid(int invoiceid) {
	this.invoiceid = invoiceid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
/**
 * @return the invoicedate
 */
public Date getInvoicedate() {
	return invoicedate;
}
/**
 * @param invoicedate the invoicedate to set
 */
public void setInvoicedate(Date invoicedate) {
	this.invoicedate = invoicedate;
}
/**
 * @return the totalamount
 */
public float getTotalamount() {
	return totalamount;
}
/**
 * @param totalamount the totalamount to set
 */
public void setTotalamount(float totalamount) {
	this.totalamount = totalamount;
}
/**
 * @return the isprocessed
 */
public boolean isIsprocessed() {
	return isprocessed;
}
/**
 * @param isprocessed the isprocessed to set
 */
public void setIsprocessed(boolean isprocessed) {
	this.isprocessed = isprocessed;
}

	
	
}
