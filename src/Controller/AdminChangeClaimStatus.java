package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.UpdateDao;

/**
 * Servlet implementation class AdminChangeClaimStatus
 */
@WebServlet("/AdminChangeClaimStatus")
public class AdminChangeClaimStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangeClaimStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int claimid = Integer.parseInt(request.getParameter("claimid"));
		 System.out.println("claimid : " + claimid);
		UpdateDao updateDao = new UpdateDao();
		if(updateDao.UpdateClaimStatusDao(claimid)) {
			System.out.println("change claimid status: " );
			response.getWriter().print("<script>alert('Update Successfully!');window.location.href='AdminQueryAllClaimsServlet'</script>" );
			
		}else {
			response.getWriter().print("<script>alert('Update failed!');window.location.href='AdminQueryAllClaimsServlet'</script>" );
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
