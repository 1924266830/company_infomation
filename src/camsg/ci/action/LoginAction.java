package camsg.ci.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import camsg.ci.DaoImpl.UserDaoImpl;
import camsg.ci.entity.User;
import camsg.ci.service.LoginService;
import camsg.ci.service.LoginServiceImpl;

public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService service = new LoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// �û���
		String username = request.getParameter("username");
		// ����
		String pwd = request.getParameter("password");

		
		if(!service.isNormalCode(request)){
			request.setAttribute("message", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.getUserbyusername(username);
		
		if (user == null || !user.getPassword().equals(pwd)) {
			request.setAttribute("message", "用户名不存在或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			System.out.println("判断能否登录");
			return;
		}
		
		
		HttpSession session=request.getSession();
		session.setAttribute("loginer", user);		
		session.setAttribute("username", user.getUsername());
		
		
		response.sendRedirect("index.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
