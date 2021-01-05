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
import Entity.Purchase;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdatePurchaseServlet")
public class UpdatePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePurchaseServlet() {
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
 
		String username = request.getParameter("username");
		String productname = request.getParameter("productname");
		String serialno = request.getParameter("serialno");
		String purchasedate = request.getParameter("purchasedate");
		int availableclaims = Integer.parseInt( request.getParameter("availableclaims"));
		String purchaseid = request.getParameter("purchaseid");
 
		
		Purchase purchase = new Purchase(purchaseid, username, productname, serialno, purchasedate, availableclaims);
	
	
		UpdateDao updatePurchaseDao = new UpdateDao();
 

			try {
 
				if(updatePurchaseDao.UpdateRegisteredProductDao(purchaseid, purchase)) {
					response.getWriter().write("update  Purchased Product successfully");
					request.getRequestDispatcher("QueryAllProductServlet").forward(request, response);
					
				}else {
					response.getWriter().write("update Purchased Product failed");
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
