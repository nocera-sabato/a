package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductModel;
import model.User;
import model.game;

/**
 * Servlet implementation class GameManage
 */
@WebServlet("/GameManage")
public class GameManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModel models = new ProductModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Collection<game> products = null;
		  try {
			 products = models.RetrieveAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  request.setAttribute("games",products);
	  
	  //request.getSession().setAttribute("cart", cart);
		  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GameManage.jsp");
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
