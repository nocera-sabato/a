package Controller;
import model.Cart;
import model.OrdineModel;
import model.ProductModel;
import model.User;
import model.game;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class gameList
 */
@WebServlet("/gameList")
public class gameList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModel models = new ProductModelDM();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gameList() {
        super();
        // TODO Auto-generated constructor stub
    }

    	protected void Processing(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLException{
			
    		Collection<game> products = null;
    		String order =request.getParameter("sort");
    		String admin = request.getParameter("page");
    		String action = request.getParameter("action");
    		String nomeGame = request.getParameter("nomeGame");
    		String typeAction = request.getParameter("type");
    		String ValueMod = request.getParameter("num");
    		
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
    		if(action==null) { //azioni semplici di ordinamento
    			
    			if(admin!=null) { //sort che arriva da AdminPage
        			dispatcher = getServletContext().getRequestDispatcher("/GameManage.jsp");
        			order = "order by "+order;
        		}
        		// order = (String) request.getSession().getAttribute("sort");
      			  try {
      				
      				 if(order!=null) { //order definito
      					 
      					  request.getSession().setAttribute("sort",order);
      					  products = models.SortAll(order);
      					  
      				  }
      				  else products = models.RetrieveAll(); //order generico
      				 
      			} catch (SQLException e) {
      				// TODO Auto-generated catch block
      				e.printStackTrace();
      			}
      			request.getSession().setAttribute("games",products);	  
        		
        		  dispatcher.forward(request, response);
        		}
    		else  { //altrimenti fai o delete o modifica
    			switch(action) {
    			case "delete":
    				 models.doDelete(nomeGame);
    				 products = models.RetrieveAll();
    				 request.getSession().setAttribute("games",products);
    				  dispatcher = getServletContext().getRequestDispatcher("/GameManage.jsp");
    				  dispatcher.forward(request, response);
	             break;
    			case "mod":
    				
   				 models.doUpdate(nomeGame, typeAction, ValueMod);
   				 products = models.RetrieveAll();
   				 request.getSession().setAttribute("games",products);
   				  dispatcher = getServletContext().getRequestDispatcher("/GameManage.jsp");
   				  dispatcher.forward(request, response);
	             break;
    			}
    		}
    		  //request.getSession().setAttribute("cart", cart);
    			  
    			 
    		}
    		
    		
    		
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Processing(request,response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Processing(request,response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
