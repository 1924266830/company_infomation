package camsg.ci.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camsg.ci.Dao.FriendDao;
import camsg.ci.DaoImpl.FriendDaoImpl;
import camsg.ci.entity.Friend;

/**
 * Servlet implementation class FriendListAction
 */

public class FriendListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=(String) request.getSession().getAttribute("username");
		FriendDao ud=new FriendDaoImpl();
		List<Friend> friends=ud.getFriendList(username);
		List<Friend> friendlist=new ArrayList<Friend>();
		int f_pageNow=1;
		if(request.getParameter("f_pageNow")!=null)
		{
			f_pageNow=Integer.parseInt(request.getParameter("f_pageNow"));
			System.out.println("f_pageNow:"+f_pageNow);
		}
		int f_Totalpage=(int)Math.ceil(friends.size()/3.0);
		
		int start=(f_pageNow-1)*3;
		if(f_pageNow<f_Totalpage)
		{
			for(int i=start;i<start+3;i++)
			{
				friendlist.add(friends.get(i));
			}
		}else if(f_pageNow==f_Totalpage){
			for(int i=start;i<friends.size();i++)
			{
				friendlist.add(friends.get(i));
			}
		}
		
		request.setAttribute("f_pageNow", f_pageNow);
		request.setAttribute("f_Totalpage", f_Totalpage);
		request.setAttribute("friendlist",friendlist);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
