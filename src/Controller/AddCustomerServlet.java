package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.AddCustomerDao;
import DBHelper.QueryDao;
import Entity.Customer;
import Entity.Product;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
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
	
	
		AddCustomerDao addCustomerDao = new AddCustomerDao();
 

			try {
				int add = addCustomerDao.add(customer);
				if(add > 0) {
					response.getWriter().print("<script>alert('register successfully!');window.location.href='login.jsp'</script>" );
					 
				}else {
					response.getWriter().print("<script>alert('register failed!');window.location.href='login.jsp'</script>" );
					 
				}
			} catch (SQLException e) {
 
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
