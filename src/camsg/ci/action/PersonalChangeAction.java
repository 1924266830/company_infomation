package camsg.ci.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camsg.ci.DaoImpl.UserDaoImpl;
import camsg.ci.entity.User;

/**
 * Servlet implementation class PersonalChangeAction
 */

public class PersonalChangeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalChangeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDaoImpl ud = new UserDaoImpl();
		User user =ud.getUserbyusername((String)request.getSession().getAttribute("username"));
		String email=request.getParameter("personal_email");
		String phone=request.getParameter("personal_phone");
		String youbian=request.getParameter("personal_youbian");
		
		user.setEmail(email);
		user.setPhone(phone);
		user.setYoubian(youbian);		
		ud.update(user);
		
		request.getRequestDispatcher("personalChange.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
