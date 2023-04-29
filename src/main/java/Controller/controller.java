package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;

@WebServlet("/")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}
	
	protected void doPro(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String context = request.getContextPath();
		String command = request.getServletPath();
		String site = null;
		
		System.out.println(context+" , "+command);
		
		DAO dao = new DAO();
		
		switch (command) {
		case "/home":
			site = "index.jsp";
			break;
		case "/add":
			site = "add.jsp";
			break;
		case "/insert":
			int result1 = dao.insert(request, response);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			if(result1 == 1) {
				out.println("<script>");
				out.println("alert('접종예약정보가 등록 되었습니다!'); location.href='" + context + "';");
				out.println("</script>");
				out.flush();
			} else {
				out.println("<script>");
				out.println("alert('접종예약 정보가 정상적으로 등록되지 않았습니다!'); location.href='" + context + "';");
				out.println("</script>");
				out.flush();
			}
			
			break;
		case "/search":
			site = "/search.jsp";
			break;
		case "/inquiry":
			site = dao.getSearch(request, response);
			break;
		case "/stats":
			site = dao.giveStatistics(request, response);
			dao.total(request, response);
			break;
			
		}
		
		getServletContext().getRequestDispatcher("/"+site).forward(request, response);
	}
	

}
