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
import model.OrdineModel;
import model.ProductModel;
import model.User;
import model.game;

/**
 * Servlet implementation class Ordini
 */
@WebServlet("/Ordini")
public class Ordini extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModel models = new ProductModelDM();
	static OrdineModel OrderModel = new OrdineController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ordini() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		String sort = request.getParameter("sort");
		String sort2 = request.getParameter("sort2");  //un parametro aggiuntivo per la 2 data
		String tipoAzione = request.getParameter("type"); //mega parametro 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/orders.jsp"); //set per default pagina di admin
		if(request.getSession().getAttribute("Account")!=null) {
			request.getSession().setAttribute("Account", null); //reset attribut per poterlo aggiornare
			sort = (String) request.getSession().getAttribute("sortUser");
			dispatcher = getServletContext().getRequestDispatcher("/Account.jsp");
		}
		Collection<Ordine> products = null;
		  try {
			  if(sort != null) {
				  if(tipoAzione!=null) products = OrderModel.RetrieveAllOrders(sort,tipoAzione,sort2);
				  else products = OrderModel.SortAll(sort); //carica tutto facendo semplice where utente = sort
			  }
			  else if(user.getRole().compareTo("admin")==0)products = OrderModel.RetrieveAllOrders(); //disponibile solo per admin carica tutti i record
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  request.setAttribute("orders",products);
		  if(products==null) request.setAttribute("ordini", "vuoti"); //imposto parametro che mi dice che ordini sono null perche utente non ha comperato
	  //request.getSession().setAttribute("cart", cart);
		  
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
