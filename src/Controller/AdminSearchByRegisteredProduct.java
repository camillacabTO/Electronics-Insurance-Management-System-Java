package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.QueryDao;
import Entity.Customer;
import Entity.Purchase;

/**
 * Servlet implementation class AdminSearchByRegisteredProduct
 */
@WebServlet("/AdminSearchByRegisteredProduct")
public class AdminSearchByRegisteredProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchByRegisteredProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("searchRegisteredProductByUsername");

		QueryDao queryDao = new QueryDao();
		 List<Purchase> listproduct = queryDao.queryRegisteredProduct(username);
		 
		System.out.println("Admin search Registered Product: " + listproduct);
		request.setAttribute("listproduct", listproduct);
		request.getRequestDispatcher("queryRegisteredProductByUsername.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
