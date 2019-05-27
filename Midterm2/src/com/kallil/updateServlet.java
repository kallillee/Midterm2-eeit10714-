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
			request.setAttribute("error", "無效的編號.");
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
			request.setAttribute("error", "無效的編號.");
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
			return;
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("<tr><td class='tr1'>編號</td><td width='400px'>" + bean.getCode() + "</td><td class='up';><input type='text' readonly='readonly' value='"+code +"' name='code'></td></tr>");
			sb.append("<tr><td class='tr1'>學校名稱</td><td width='400px'>" + bean.getName() + "</td><td><input class='up' type='text' value='"+ bean.getName() +"'name='name' size='15'/></td></tr>");
			sb.append("<tr><td class='tr1'>公/私立</td><td width='400px'>" + bean.getPborpv() + "</td><td><input class='up' type='text' size='5' value='"+ bean.getPborpv() +"'name='pborpv' /></td></tr>");
			sb.append("<tr><td class='tr1'>所在縣市</td><td width='400px'>" + bean.getCity() + "</td><td><input class='up' type='text' value='"+ bean.getCity() +"'name='city' size='10'/></td></tr>");
			sb.append("<tr><td class='tr1'>地址</td><td width='400px'>" + bean.getAddr() + "</td><td><input class='up' type='text' value='"+ bean.getAddr() +"'name='addr' size='20'/></td></tr>");
			sb.append("<tr><td class='tr1'>電話</td><td width='400px'>" + bean.getPhone() + "</td><td><input class='up' type='text' value='"+ bean.getPhone() +"'name='phone' size='15'/></td></tr>");
			sb.append("<tr><td class='tr1'>學校網站</td><td width='400px'>" + bean.getUrl() + "</td><td><input class='up' type='text' value='"+ bean.getUrl() +"'name='url' size='40'/></td></tr>");
			request.setAttribute("table", sb);
			String st = "<input type='submit' value='確定修改'  class='butt'  ><button class='butt' type='button' value='取消' onclick=\"javascript:location.href='update.jsp'\">取消</button>";
			request.setAttribute("button", st);
			request.setAttribute("code", code);
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
			return;
		}

	}
}
