package camsg.ci.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camsg.ci.Dao.UserDao;
import camsg.ci.DaoImpl.UserDaoImpl;
import camsg.ci.entity.User;

/**
 * Servlet implementation class RegistCheckAction
 */

public class RegistCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistCheckAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置网页编译格式！！
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		//
			UserDao ud=new UserDaoImpl();
			String username=request.getParameter("username");
			User user=ud.getUserbyusername(username);
			System.out.println(user);
			if(user!=null)
			{
				
				response.getWriter().write("用户已存在");
				
			}
			else
			{
				response.getWriter().write("用户名可以注册");
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
