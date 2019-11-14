package camsg.ci.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camsg.ci.Dao.UserDao;
import camsg.ci.DaoImpl.UserDaoImpl;
import camsg.ci.entity.User;

/**
 * Servlet implementation class UserlistAction
 */
public class UserlistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserlistAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao ud=new UserDaoImpl();
		List<User> users=ud.getUserList();
		List<User> userlist=new ArrayList<User>();
		int pageNow=1;
		if(request.getParameter("pageNow")!=null)
		{
			pageNow=Integer.parseInt(request.getParameter("pageNow"));
			System.out.println("pageNow:"+pageNow);
		}
		int Totalpage=(int)Math.ceil(users.size()/3.0);
		
		int start=(pageNow-1)*3;
		if(pageNow<Totalpage)
		{
			for(int i=start;i<start+3;i++)
			{
				userlist.add(users.get(i));
			}
		}else if(pageNow==Totalpage){
			for(int i=start;i<users.size();i++)
			{
				userlist.add(users.get(i));
			}
		}
		
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("Totalpage", Totalpage);
		request.setAttribute("userlist",userlist);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
