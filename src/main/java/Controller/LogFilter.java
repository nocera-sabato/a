package Controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/LogFilter")
public class LogFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LogFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest hrequest = (HttpServletRequest) request;
		  HttpServletResponse hresponse = (HttpServletResponse) response;
		  //response.setContentType("text/html"); 
		  HttpSession session=hrequest.getSession(false);
		  User u = (User) hrequest.getSession().getAttribute("user");
		 // User u = (User) session.getAttribute("user");
		  if(!(u != null))
			  { 
			  //if((u.getLogin()== null))
			  hresponse.sendRedirect("home.jsp");
			  //else chain.doFilter(request, response);
			  }
		  else  chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
