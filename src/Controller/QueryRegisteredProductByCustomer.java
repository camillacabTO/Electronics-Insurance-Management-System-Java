package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.QueryRegisteredProductByCustomerDao;
import Entity.Purchase;

/**
 * Servlet implementation class QueryRegisteredProductByCustomer
 */
@WebServlet("/QueryRegisteredProductByCustomer")
public class QueryRegisteredProductByCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryRegisteredProductByCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		QueryRegisteredProductByCustomerDao queryRegisteredProductByCustomerDao = new QueryRegisteredProductByCustomerDao();
		String username = (String)request.getSession().getAttribute("username");
		System.out.println(username);
		List<Purchase> cust_products = null;
				
				
		try {
			 cust_products = queryRegisteredProductByCustomerDao.customerRegisteredProduct(username);
			 System.out.println(cust_products);
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		
		request.setAttribute("cust_products", cust_products);
		request.getRequestDispatcher("CustomerMainPage.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
