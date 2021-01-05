package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.AddCustomerDao;
import DBHelper.UpdateDao;
import Entity.Customer;
import Entity.Product;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		
		String productname = request.getParameter("productname");
		String category = request.getParameter("category");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
 
		
		Product product = new Product(productname,quantity,category);
	
	
		UpdateDao updateProductDao = new UpdateDao();
 

			try {
 
				if(updateProductDao.UpdateInventoryProductDao(productname, product) ) {
					response.getWriter().write("update inventory successfully");
					request.getRequestDispatcher("AdminQueryAllInventoryProductServlet").forward(request, response);
					
				}else {
					response.getWriter().write("update inventory failed");
				}
			} catch ( Exception e) {
 
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
