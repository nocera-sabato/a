package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class AccountManage
 */
@WebServlet("/AccountManage")
public class AccountManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String sort = request.getParameter("Sort");
		if(sort==null) sort="role";
		UserController UserC = new UserController();
		Collection<User> utenti = new LinkedList<User>();
		try {
			if(action!=null)
				switch (action) {
					case "delete":
						UserC.doDelete(id);
		             break;
					case "manager":
						UserC.setManager(id);
		             break;
					case "admin":
						UserC.setAdmin(id);
		             break; 
				}
			
			 utenti = UserC.doRetrieveAll("Order by "+sort);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("users", utenti);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AccountManage.jsp");
		  dispatcher.forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/AccountManage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
