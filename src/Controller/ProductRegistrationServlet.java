package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.RegisterProductDao;
import Entity.Customer;
import Entity.Purchase;

/**
 * Servlet implementation class ProductRegistrationServlet
 */
@WebServlet("/ProductRegistrationServlet")
public class ProductRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegistrationServlet() {
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
		String productname = request.getParameter("Productname");
		String serialno = request.getParameter("serialno");
		String purchasedate = request.getParameter("purchasedate");
		 
		System.out.println(username +"--"+productname+"--"+serialno+"--"+purchasedate);
		
		Purchase product = new Purchase(null,username,productname,serialno,purchasedate);

		RegisterProductDao registerProductDao = new RegisterProductDao();
		try {
			if(registerProductDao.isExistCustomer(username)) {
				
				int count = registerProductDao.registerProduct(product);
				
				if(count >0) {

					response.getWriter().print("<script>alert('Product register successfully!');window.location.href='QueryRegisteredProductByCustomer?username="+username+"'</script>" );
					
				}else {
					response.getWriter().print("<script>alert('Product register failed!');window.location.href='QueryRegisteredProductByCustomer?username="+username+"'</script>" );
					 
				}
			}else {
				response.getWriter().print("<script>alert('Customer Not Exist, Please Sign Up and then Registrate Product!');window.location.href='login.jsp'</script>" );
				 
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
