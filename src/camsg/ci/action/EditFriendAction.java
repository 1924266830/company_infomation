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
 * Servlet implementation class EditFriendAction
 */

public class EditFriendAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFriendAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		FriendDao fd=new FriendDaoImpl();
		int id=Integer.valueOf(request.getParameter("f_id"));
		System.out.println(id);
		String name=request.getParameter("f_name");		
		String sex=request.getParameter("f_sex");
		System.out.println(sex);
		String phone=request.getParameter("f_phone");
		String email=request.getParameter("f_email");
		String qq=request.getParameter("f_qq");
		String youbian=request.getParameter("f_youbian");
		Friend friend=fd.getFriendbyID(id);
		friend.setName(name);
		friend.setSex(sex);
		friend.setPhone(phone);
		friend.setEmail(email);
		friend.setQq(qq);
		friend.setYoubian(youbian);
		fd.update(friend);
		
		response.sendRedirect("Maillist.jsp?f_pageNow=1");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
