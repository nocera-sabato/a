package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.Ordine;
import model.ProductModel;
import model.User;
import model.game;

/**
 * Servlet implementation class Paga
 */
@WebServlet("/Paga")
public class ModuloPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static OrdineController models = new OrdineController();
	static ProductModel Gamemodels = new ProductModelDM();
	static UserController utente = new UserController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuloPagamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		float somma= 0f;
		Ordine NewOne = new Ordine();
		int fattura = ((int)(1000+Math.random() * 9999));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		 User user = (User) request.getSession().getAttribute("user");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		List<game> prodcart = cart.getProducts(); 
		Iterator<?> it = prodcart.iterator();
			while(it.hasNext()) {
				
				game g1 = (game) it.next();
				 
				if(g1.getCQ()>0) {
					somma= somma+(g1.getPrice()*g1.getCQ()+(g1.getPrice()*g1.getCQ())/100*g1.getIva());
					NewOne.setGame(g1.getName());
					NewOne.setNomeUtente(user.getLogin());
					NewOne.setFattura(user.getLogin()+toString().valueOf(fattura));
					NewOne.setDate(dtf.format(now));
					NewOne.setIva(g1.getIva());
					NewOne.setQuant(g1.getCQ());
					NewOne.setTotale(g1.getPrice()*g1.getCQ());
					try {
						utente.UserBuy(user.getLogin(), (user.getQuantity()-somma));
						models.doSave(NewOne);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					user.setBalance(user.getQuantity()-somma);
					//cart.deleteProduct(g1);
					//deleted(request, response,g1.getName(),false);
				}// if
				}// while
			request.getSession().setAttribute("cart", null);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			  dispatcher.forward(request, response);
	
	}
	
	private void deleted(HttpServletRequest request, HttpServletResponse response,String nome,boolean v) throws ServletException, IOException, SQLException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//List<game> prodcart = cart.getProducts();
		game g1 = Gamemodels.doRetrieveByKey(nome);
		cart.deleteProduct(g1);
		request.getSession().setAttribute("cart", cart);
		if(v==true) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MyCart.jsp");
			  dispatcher.forward(request, response);
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String NomeDelete = request.getParameter("delete");
		if(NomeDelete!=null) {
			
			try {
				deleted(request,response,NomeDelete,true);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			try {
				payment(request,response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
