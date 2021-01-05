package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.QueryDao;
import Entity.Product;
import Entity.Purchase;

/**
 * Servlet implementation class AdminQueryAllInventoryProductServlet
 */
@WebServlet("/AdminQueryAllInventoryProductServlet")
public class AdminQueryAllInventoryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQueryAllInventoryProductServlet() {
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
		
		
		QueryDao queryDao = new QueryDao();
		List<Product> inventoryProducts = queryDao.queryInventoryProduct();
		 
		 
		System.out.println("inventoryProducts: " + inventoryProducts);
		request.setAttribute("inventoryProducts", inventoryProducts);
		request.getRequestDispatcher("queryInventoryProducts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
