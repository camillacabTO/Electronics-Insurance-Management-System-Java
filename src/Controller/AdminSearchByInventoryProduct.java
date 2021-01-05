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
import Entity.Product;
import Entity.Purchase;

/**
 * Servlet implementation class AdminSearchByRegisteredProduct
 */
@WebServlet("/AdminSearchByInventoryProduct")
public class AdminSearchByInventoryProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchByInventoryProduct() {
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
		
		String searchInventoryProduct = request.getParameter("searchInventoryProduct");

		QueryDao queryDao = new QueryDao();
		 Product productByProductname = queryDao.queryInventoryProductByProductname(searchInventoryProduct);
		 
		 	 
		 
		System.out.println("Admin search inventory Product: " + productByProductname);
		request.setAttribute("searchInventoryProduct", productByProductname);
		request.getRequestDispatcher("queryInventoryProductByAdmin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
