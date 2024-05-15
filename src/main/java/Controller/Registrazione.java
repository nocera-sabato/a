package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserController UserC = new UserController();
	User newUser = new User(null, null, null, 0, null, null, null);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String nome = (String) request.getAttribute("nome");
		String email = request.getParameter("email");
		
	
			try {
				newUser = UserC.doRetrieveByKey(email);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
		  if(newUser.getLogin()== null) {
		  
		  
		  newUser.setLogin(request.getParameter("email"));
		  newUser.setPass(request.getParameter("pass")); 
		  newUser.setRole("user");
		  newUser.setBalance(50);
		  newUser.setNome(request.getParameter("nome"));
		  newUser.setCognome(request.getParameter("cognome"));
		  newUser.setDataNascita(request.getParameter("data"));
		  
		  
		  
		  try { UserC.doSave(newUser);
		  } catch (SQLException e) { // TODO
		   }
		  
		  RequestDispatcher dispatcher =
		  getServletContext().getRequestDispatcher("/home.jsp");
		  dispatcher.forward(request, response);
		  } else{
		  
		  response.addHeader("ErrorRegister", "Try another login!");
		  response.sendRedirect("registration.jsp"); }
		 
		
		
	}

}
