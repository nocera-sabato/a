package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import model.Cart;
import model.ProductModel;
import model.game;

/**
 * Servlet implementation class CreateCart
 */
@WebServlet("/CreateCart")
public class CreateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModel models = new ProductModelDM();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCart() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	response.setContentType("application/json");
    	JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        boolean finded=false;
		int q=1,p=1;
		game product = new game(null, null, null, null, null, 0, null, null, 0, null, 0);
		Cart cart = (Cart)request.getSession().getAttribute("cart");
	
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		String nomeGame =(String) request.getParameter("nome");
		
		List<game> giochi = cart.getProducts();
		if(nomeGame!=null){
			try {
				
				product=models.doRetrieveByKey(nomeGame);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i=0;
			
			if(!giochi.isEmpty()) { //se la lista non è vuota
				while(i<giochi.size()&&(!finded)) {
					
					game o = giochi.get(i);
					if(o.equals(product)) {
						 q =o.getCQ();
						 p = o.getQuantity();
						if(q==p) request.getSession().setAttribute("isFULL", "true");
						if((q<p)) o.setCQ(++q);
						finded=true;
						json.put("result", o.getName());
						json.put("quantity", o.getCQ());
					}
					i++;
				}
				if((!finded)) { //il pootto non è stato trovato allora è prima volta
					product.setCQ(1);
					cart.addProduct(product);
					p=product.getQuantity();
					json.put("result", product.getName());
					json.put("quantity", product.getCQ());
				}
			}
			else { //in caso se la lista non esiste ancora
					product.setCQ(1);
					cart.addProduct(product);
					p=product.getQuantity();
					json.put("result", product.getName());
					json.put("quantity", product.getCQ()); //non uso piu questo parametro
				}
		}
		request.getSession().setAttribute("cart", cart);
        
        json.put("disponibili", p);
        out.print(json.toString());
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
