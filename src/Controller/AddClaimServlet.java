package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.AddClaimDAO;
import DBHelper.QueryDao;
import Entity.Purchase;


@WebServlet("/AddClaimServlet")
public class AddClaimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
        PrintWriter printer = response.getWriter();
        String out = "<!DOCTYPE html><html lang=\"en\"><body>";
		
		String purchaseid = request.getParameter("purchaseid");
		String dateofclaim = request.getParameter("dateofclaim");
		String description = request.getParameter("description");
		String username = request.getParameter("username");
		
		QueryDao queryDao = new QueryDao();
		Purchase purchase = queryDao.queryPurchaseByID(purchaseid);
		int claimsAvailable =  purchase.getAvailableclaims();
		
		if(claimsAvailable > 0) {
			
			--claimsAvailable;
			
	    	AddClaimDAO claimDAO = new AddClaimDAO();
	    	int count = claimDAO.doAdd(username, purchaseid, dateofclaim, description);
	    	
	    	if (count > 0) {
	    		out += "<h2>Claim Added Successfully</h2>";
	    		queryDao.updateClaimsAvailable(purchaseid, claimsAvailable);
	    		System.out.println("Claims available now: " + claimsAvailable);
	    		
	    	} else {
	    		out += "<h2>Claim registrion failed</h2>";
	    	}
	    	
	    	out+="<br><br><a href=\"QueryRegisteredProductByCustomer\">Go Back</a><br>";
	    	out += "</body></html>";
	    	printer.println(out);
			
		} else {
			out += "<h4>Oops! You have used all the claims available in this purchase.</h4>";
			out+="<br><br><a href=\"QueryRegisteredProductByCustomer\">Go Back</a><br>";
	    	out += "</body></html>";
	    	printer.println(out);
		}
		
		
		
		
		
		

	}

}
