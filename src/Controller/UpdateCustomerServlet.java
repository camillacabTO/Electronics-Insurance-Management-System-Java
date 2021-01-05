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

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
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
		String password = request.getParameter("password");
		String cellphoneno = request.getParameter("cellphoneno");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Customer customer = new Customer(username,password,cellphoneno,email,name,address);
	
	
		UpdateDao updateCustomerDao = new UpdateDao();
 

			try {
 
				if(updateCustomerDao.UpdateCustomerDao(username, customer)) {
					response.getWriter().write("update customer successfully");
					request.getRequestDispatcher("QueryAllUserServlet").forward(request, response);
					
				}else {
					response.getWriter().write("update customer failed");
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
