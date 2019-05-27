package com.kallil;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete.do")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int code=0;
		try {
			code = Integer.parseInt(request.getParameter("code"));
		} catch (NumberFormatException e) {
			request.setAttribute("error", "無效的編號.");
			RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
			rd.forward(request, response);
			return;
		}
		Midterm2DAO dao = new Midterm2DAO();
		Midterm2Bean bean = new Midterm2Bean();
		try {
			bean = dao.findOne(code);
		} catch (SQLException e) {
			request.setAttribute("error",e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
			rd.forward(request, response);
			return;
		}
		if(bean.getName()==null) {
			request.setAttribute("error", "無效的編號.");
			RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
			rd.forward(request, response);
			return;
		}else {
			StringBuffer sb = new StringBuffer();
			sb.append("<tr><td width='100px' class='tr1'>編號</td><td width='400px'>" + bean.getCode() +"</td></tr>");
			sb.append("<tr><td width='100px' class='tr1'>學校名稱</td><td width='400px'>" + bean.getName() +"</td></tr>");
			sb.append("<tr><td width='100px' class='tr1'>公/私立</td><td width='400px'>" + bean.getPborpv() +"</td></tr>");
			sb.append("<tr><td width='100px' class='tr1'>所在縣市</td><td width='400px'>" + bean.getCity() +"</td></tr>");
			sb.append("<tr><td width='100px' class='tr1'>地址</td><td width='400px'>" + bean.getAddr() +"</td></tr>");
			sb.append("<tr><td width='100px' class='tr1'>電話</td><td width='400px'>" + bean.getPhone() +"</td></tr>");
			sb.append("<tr><td width='100px' class='tr1'>學校網站</td><td width='400px'>" + bean.getUrl() +"</td></tr>");
			String bt = "<button type='button' value='確定刪除'  class='butt' onclick=\"javascript:location.href='check.do?code="+code+"'\">確定刪除</button><button type='button' value='取消' class='butt' onclick=\"javascript:location.href='delete.jsp'\">取消</button>";
			request.setAttribute("table", sb);
			request.setAttribute("button",bt);
			RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

}
