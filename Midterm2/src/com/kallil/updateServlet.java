package com.kallil;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update.do")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int code = 0;
		try {
			code = Integer.parseInt(request.getParameter("code"));
		} catch (NumberFormatException e) {
			request.setAttribute("error", "�L�Ī��s��.");
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
			return;
		}
		Midterm2DAO dao = new Midterm2DAO();
		Midterm2Bean bean = new Midterm2Bean();
		try {
			bean = dao.findOne(code);
		} catch (SQLException e) {
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
			return;
		}
		if (bean.getName() == null) {
			request.setAttribute("error", "�L�Ī��s��.");
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
			return;
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("<tr><td class='tr1'>�s��</td><td width='400px'>" + bean.getCode() + "</td><td class='up';><input type='text' readonly='readonly' value='"+code +"' name='code'></td></tr>");
			sb.append("<tr><td class='tr1'>�ǮզW��</td><td width='400px'>" + bean.getName() + "</td><td><input class='up' type='text' value='"+ bean.getName() +"'name='name' size='15'/></td></tr>");
			sb.append("<tr><td class='tr1'>��/�p��</td><td width='400px'>" + bean.getPborpv() + "</td><td><input class='up' type='text' size='5' value='"+ bean.getPborpv() +"'name='pborpv' /></td></tr>");
			sb.append("<tr><td class='tr1'>�Ҧb����</td><td width='400px'>" + bean.getCity() + "</td><td><input class='up' type='text' value='"+ bean.getCity() +"'name='city' size='10'/></td></tr>");
			sb.append("<tr><td class='tr1'>�a�}</td><td width='400px'>" + bean.getAddr() + "</td><td><input class='up' type='text' value='"+ bean.getAddr() +"'name='addr' size='20'/></td></tr>");
			sb.append("<tr><td class='tr1'>�q��</td><td width='400px'>" + bean.getPhone() + "</td><td><input class='up' type='text' value='"+ bean.getPhone() +"'name='phone' size='15'/></td></tr>");
			sb.append("<tr><td class='tr1'>�Ǯպ���</td><td width='400px'>" + bean.getUrl() + "</td><td><input class='up' type='text' value='"+ bean.getUrl() +"'name='url' size='40'/></td></tr>");
			request.setAttribute("table", sb);
			String st = "<input type='submit' value='�T�w�ק�'  class='butt'  ><button class='butt' type='button' value='����' onclick=\"javascript:location.href='update.jsp'\">����</button>";
			request.setAttribute("button", st);
			request.setAttribute("code", code);
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
			return;
		}

	}
}
