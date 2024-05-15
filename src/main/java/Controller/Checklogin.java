package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class Checklogin
 */
@WebServlet("/Checklogin")
public class Checklogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserController utenteC = new UserController();

	User utente = new User(null, null, null, 0, null, null, null);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checklogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserController UserC = new UserController();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//String username = "emmy";
		//String password = "admin";
		String redirectPage;
		try {
			utente = (User) checkLogin(username,password);
			if((utente == null)||(username == null)) {
				redirectPage ="/Login.jsp";
			}
			else {
				request.getSession().setAttribute("user", utente);
				request.getSession().setAttribute("role",utente.getRole());
				request.getSession().setAttribute("name",utente.getNome());
				request.getSession().setAttribute("login",utente.getLogin());
				request.getSession().setAttribute("balance",utente.getQuantity());
				redirectPage ="/home.jsp";
			}
		}catch (Exception e){
			System.out.print(e);
			redirectPage ="/Login.jsp";
		}
		response.sendRedirect(request.getContextPath()+redirectPage);
	}

	private User checkLogin(String a, String b) throws SQLException {
		
		utente = utenteC.doRetrieveByKey(a);
		if(utente.getPass().compareTo(b)==0) {
			return utente;
		}
		return null;
		
	}
}
