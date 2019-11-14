package camsg.ci.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camsg.ci.Dao.FriendDao;
import camsg.ci.DaoImpl.FriendDaoImpl;
import camsg.ci.entity.Friend;

/**
 * Servlet implementation class AddFriendAction
 */
@WebServlet("/AddFriendAction")
public class AddFriendAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Friend friend=new Friend();
		String name=request.getParameter("fadd_name");		
		String sex=request.getParameter("fadd_sex");
		System.out.println(sex);
		String phone=request.getParameter("fadd_phone");
		String email=request.getParameter("fadd_email");
		String qq=request.getParameter("fadd_qq");
		String youbian=request.getParameter("fadd_youbian");
		
		FriendDao fd=new FriendDaoImpl();

		friend.setName(name);
		friend.setSex(sex);
		friend.setPhone(phone);
		friend.setEmail(email);
		friend.setQq(qq);
		friend.setYoubian(youbian);
		friend.setUsername((String)request.getSession().getAttribute("username"));
		fd.insert(friend);
		
		request.getRequestDispatcher("Maillist.jsp?f_pageNow=1").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
