package camsg.ci.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import camsg.ci.Dao.UserDao;
import camsg.ci.DaoImpl.UserDaoImpl;
import camsg.ci.entity.User;

/**
 * Servlet implementation class RegistAction
 */

public class RegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// �û���
				String username = request.getParameter("r_name");
				// ����
				String pwd = request.getParameter("r_password");
				//ȷ������
				String checkpwd=request.getParameter("r_checkpassword");
				//����
				String email = request.getParameter("r_email");
				//�绰
				String phone = request.getParameter("r_phone");
				//�ʱ�
				String youbian = request.getParameter("r_youbian");
				String province=request.getParameter("province");
				String city=request.getParameter("city");
				String area=request.getParameter("area");
				String place=province+","+city+","+area;
				
				System.out.println("username"+username);
				System.out.println("pwd"+pwd);
				System.out.println("checkpwd"+checkpwd);
				System.out.println("email"+email);
				System.out.println("phone"+phone);
				System.out.println("youbian"+youbian);
				System.out.println("place:"+place);
				//�����ݿ��в����û�
				User user=new User(username,pwd,email,phone,youbian,"",place);
				UserDao ud=new UserDaoImpl();
				ud.insert(user);
				HttpSession session=request.getSession();
				session.setAttribute("loginer", user);
				
				response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
