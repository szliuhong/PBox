import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CryptServlet extends HttpServlet {

	public CryptServlet() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String key= req.getParameter("key");
		String appName = req.getParameter("appName");
		String pwd= req.getParameter("pwd");
		
		 try{
			byte[] pwd2= AESUtils.encrypt(pwd.getBytes(),key.getBytes());
			
		 }catch(Exception e){
			 
		 }
		req.getRequestDispatcher("prisonerSearchN.jsp").forward(req, resp);
		
	}

}
