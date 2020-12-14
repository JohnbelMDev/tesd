package cit285.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.book.dao.LoginDao;
import cit285.book.domain.Login;
import cit285.book.service.LoginService;
import cit285.book.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginService loginService;

    public void init() {
        loginService = new LoginService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	int x=0;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        x= LoginService.loginUser(username, password);
        System.out.println(x);
        
        if (x==1) {
    	    HttpSession session = request.getSession();
    	    session.setAttribute("username",username);
    	    getServletContext().getRequestDispatcher("/WEB-INF/jsp/loginsuccess.jsp").forward(request, response);
    	} else if (x==2) {
        System.out.println("It's an admin");
    	} else {
    	    HttpSession session = request.getSession();
    	    session.setAttribute("user", username);
    		getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    	}
        
    }
}