package cit285.book.service;

import cit285.book.dao.BookDao;
import cit285.book.domain.Author;
import cit285.book.domain.Book;

public class BookService implements BookServiceAPI {

static BookDao bookDao;

public BookService() {
	bookDao = new BookDao();
}

public static void addBookToDb(String isbn, String title, 
	String editor, String edition, String year, 
	String authorFirstName, String authorLastName) {
		
	Author author = new Author();
	author.setAuthorfirstname(authorFirstName);
	author.setAuthorlastname(authorLastName);

	Book book = new Book();
	book.setIsbn(isbn);
	book.setTitle(title);
	book.setEditor(editor);
	book.setEdition(edition);
	book.setYear(Integer.parseInt(year));
	book.setAuthor(author);
		
		try {
			bookDao.addBook(book, author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
