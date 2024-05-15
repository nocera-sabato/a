package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ordine;

/**
 * Servlet implementation class OrdiniUser
 */
@WebServlet("/OrdiniUser")
public class OrdiniUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdiniUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sort = request.getParameter("sort");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/orders.jsp");
		
		if(response.getHeader("nomeUtente")!=null) {
			sort = response.getHeader("nomeUtente");
			dispatcher = getServletContext().getRequestDispatcher("/Account.jsp");
		}
		
		/*
		 * Collection<Ordine> products = null; try { if(sort != null) products =
		 * models.RetrieveAllOrders(sort); else products = models.RetrieveAllOrders(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } request.setAttribute("orders",products);
		 * if(products.isEmpty()) response.setHeader("NoOrders",
		 * "nessun ordine trovato"); //request.getSession().setAttribute("cart", cart);
		 */
	  dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
