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
 * Servlet implementation class SearchFriendAction
 */

public class SearchFriendAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFriendAction() {
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
		String search_content=request.getParameter("search_content");
		System.out.println("search_content:"+search_content);
		ArrayList<Friend> search_friends=new ArrayList<Friend>(); 
		ArrayList<Friend> search_friendlist=new ArrayList<Friend>(); 
		int sf_pageNow=1;
		int sf_Totalpage=1;
		if(friends.size()>0&&search_content!=""&&search_content!=null)
		{
			for(int i=0;i<friends.size();i++)
			{
				if(friends.get(i).getName().indexOf(search_content)>=0)
					search_friends.add(friends.get(i));
			}
			
			System.out.println("");
			if(request.getParameter("sf_pageNow")!=null)
			{
				sf_pageNow=Integer.parseInt(request.getParameter("sf_pageNow"));
				System.out.println("sf_pageNow:"+sf_pageNow);
			}			
			
			
		}	
		
		/*request.setAttribute("sf_pageNow",sf_pageNow);
		System.out.println("sf_pageNow:"+sf_pageNow);
		request.setAttribute("sf_Totalpage", sf_Totalpage);
		System.out.println("sf_Totalpage:"+sf_Totalpage);*/
		request.setAttribute("search_friendlist",search_friends);
		System.out.println("search_friendlist:"+search_friendlist.size());
		request.setAttribute("search_content", search_content);
		
		request.getRequestDispatcher("Maillist.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
