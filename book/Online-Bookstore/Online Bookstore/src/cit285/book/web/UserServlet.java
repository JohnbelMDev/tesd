package cit285.book.web;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cit285.book.dao.Userdao;
import cit285.book.domain.User;
import cit285.book.service.UserService;


@WebServlet("/userRegister")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    public void init() {
        userService = new UserService();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        //String address = request.getParameter("address");
        //String contact = request.getParameter("contact");
        //
        //User user = new User();
        //user.setFirstname(firstName);
        //user.setLastname(lastName);
        //user.setUsername(username);
        //user.setPassword(password);
        UserService.addUser(firstName,lastName,username,password,email);
        
        try {
           
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("userDetails.jsp");
        
    }
}