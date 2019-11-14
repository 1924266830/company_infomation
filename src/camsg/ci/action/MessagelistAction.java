package camsg.ci.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import camsg.ci.Dao.MessageDao;
import camsg.ci.DaoImpl.MessageDaoImpl;
import camsg.ci.entity.Message;
import camsg.ci.entity.User;

/**
 * Servlet implementation class MessagelistAction
 */
@WebServlet("/messagelist.jhtml")
public class MessagelistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessagelistAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("loginer");
		String receiver=user.getUsername();
		MessageDao md=new MessageDaoImpl();
		List<Message> messages=md.acceptMessge(receiver);
		List<Message> messagelist=new ArrayList<>();
		
		int m_pageNow=1;
		if(request.getParameter("m_pageNow")!=null)
		{
			m_pageNow=Integer.parseInt(request.getParameter("m_pageNow"));
			System.out.println("m_pageNow:"+m_pageNow);
		}
		int m_Totalpage=(int)Math.ceil(messages.size()/3.0);
		
		int start=(m_pageNow-1)*3;
		if(m_pageNow<m_Totalpage)
		{
			for(int i=start;i<start+3;i++)
			{
				messagelist.add(messages.get(i));
			}
		}else if(m_pageNow==m_Totalpage){
			for(int i=start;i<messages.size();i++)
			{
				messagelist.add(messages.get(i));
			}
		}
		
		
		request.setAttribute("m_pageNow", m_pageNow);
		request.setAttribute("m_Totalpage", m_Totalpage);
		request.setAttribute("messagelist",messagelist);
		
		request.getRequestDispatcher("Message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
