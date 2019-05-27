package com.kallil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Insert.do")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> error = new HashMap<>();
		request.setAttribute("ErrorMsg", error);
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		if (code == null || code.trim().length() == 0) {
			error.put("code", "�п�J�s��.");
		}
		String name = request.getParameter("name");
		if (name == null || name.trim().length() == 0) {
			error.put("name", "�п�J�զW.");
		}
		String pborpv = request.getParameter("pborpv");
		if (pborpv == null || pborpv.trim().length() == 0) {
			error.put("pborpv", "�п�ܤ��p��.");
		}
		String city = request.getParameter("city");
		String addr = request.getParameter("addr");
		if (addr == null || addr.trim().length() == 0) {
			error.put("addr", "�п�J�s��.");
		}
		String phone = request.getParameter("phone");
		if (phone == null || phone.trim().length() == 0) {
			error.put("phone", "�п�J�q��.");
		}
		String web = request.getParameter("web");
		if (web == null || web.trim().length() == 0) {
			error.put("web", "�п�J�Ǯպ���.");
		}
		if (!error.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
			rd.forward(request, response);
			return;
		}
		int i = 0;
		try {
			Midterm2Bean bean = new Midterm2Bean();
			bean.setCode(Integer.parseInt(code));
			bean.setName(name);
			bean.setPborpv(pborpv);
			bean.setCity(city);
			bean.setAddr(addr);
			bean.setPhone(phone);
			bean.setUrl(web);
			Midterm2DAO dao = new Midterm2DAO();
			try {
				 i  = dao.insert(bean);
			} catch (SQLException e) {
				if (e.getMessage().indexOf("���ƪ�������") != -1 
						|| e.getMessage().indexOf("Duplicate entry") != -1) {
						error.put("code", "�b�����ơA�Э��s��J�b��");
					} else {
						error.put("exception", "��Ʈw�s�����~:" + e.getMessage());
					}
					RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
					rd.forward(request, response);
					return;
			}
			request.setAttribute("Bean", bean);			
			RequestDispatcher rd = request.getRequestDispatcher("/insertSuccess.jsp");
			rd.forward(request, response);
			return;
		} catch (NumberFormatException e) {
			error.put("code", "�п�J�Ʀr.");
		}
		
	}

}
