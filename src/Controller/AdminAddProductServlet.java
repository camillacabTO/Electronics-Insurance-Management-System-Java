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
 * Servlet implementation class AdminAddProductServlet
 */
@WebServlet("/AdminAddProductServlet")
public class AdminAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddProductServlet() {
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
	
	
		System.out.println("add product: " + product);
		UpdateDao updateDao = new UpdateDao();
 

			if(updateDao.addInventoryProductDao(product)) {
				response.getWriter().print("<script>alert('Add product successfully!');window.location.href='AdminQueryAllInventoryProductServlet'</script>" );
				 
			}else {
				response.getWriter().print("<script>alert('Add product failed!');window.location.href='AdminQueryAllInventoryProductServlet'</script>" );
				 
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
