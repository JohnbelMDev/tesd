package cit285.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cit285.book.dao.BookDao;
import cit285.book.dao.Userdao;
import cit285.book.domain.Book;
import cit285.book.domain.User;
import cit285.book.service.BookService;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	BookService bookService;
	private static final long serialVersionUID = 1L;
       

	public void init() {
        bookService = new BookService();
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {

		        String isbn = request.getParameter("isbn");
		        String title = request.getParameter("title");
		        String editor = request.getParameter("editor");
		        String edition = request.getParameter("edition");
		        String year = request.getParameter("year");
		        String authorFirstName = request.getParameter("authorFirstName");
		        String authorLastName = request.getParameter("authorLastName");


		        try {
		            bookService.addBookToDb(isbn, title, editor, edition, year, authorFirstName, authorLastName);
		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        response.sendRedirect("userDetails.jsp");
		        
		    }

}
