package cit285.book.domain;

public class LineItem {
private int lineitemid;
private int invoiceid;
private int bookid;
private int quantity;
public int getLineitemid() {
	return lineitemid;
}
public void setLineitemid(int lineitemid) {
	this.lineitemid = lineitemid;
}
public int getInvoiceid() {
	return invoiceid;
}
public void setInvoiceid(int invoiceid) {
	this.invoiceid = invoiceid;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
