package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.QueryDao;
import Entity.Claim;
import Entity.Product;

/**
 * Servlet implementation class AdminQueryAllClaimsServlet
 */
@WebServlet("/AdminQueryAllClaimsServlet")
public class AdminQueryAllClaimsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQueryAllClaimsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryDao queryDao = new QueryDao();
		List<Claim>  claims = queryDao.queryAllClaims();
		
		request.setAttribute("claims", claims);
//		request.getRequestDispatcher("queryInventoryProducts.jsp").forward(request, response);
		request.getRequestDispatcher("show_All_Claims.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
