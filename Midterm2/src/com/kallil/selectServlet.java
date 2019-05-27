package com.kallil;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Select.do")
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StringBuffer sb = new StringBuffer();
		sb.append("<tr><td width='50px'>�s��</td><td width='170px'>�ǮզW��</td><td width='70px'>��/�p��</td><td width='80px'>�Ҧb����</td><td width='350px'>�Ǯզa�}</td><td width='100px'>�Ǯչq��</td><td width='150px'>�Ǯպ���</td></tr>");
		Midterm2DAO dao = new Midterm2DAO();
		List<Midterm2Bean> list = new ArrayList<>();
		try {
			list= dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Midterm2Bean bean:list) {
			sb.append("<tr>");
			sb.append("<td>"+ bean.getCode()+"</td>");
			sb.append("<td>"+ bean.getName()+"</td>");
			sb.append("<td>"+ bean.getPborpv()+"</td>");
			sb.append("<td>"+ bean.getCity()+"</td>");
			sb.append("<td>"+ bean.getAddr()+"</td>");
			sb.append("<td>"+ bean.getPhone()+"</td>");
			sb.append("<td>"+ bean.getUrl().trim()+"</td>");
			sb.append("</tr>");
		}
		request.setAttribute("alldata", sb);
		RequestDispatcher rd = request.getRequestDispatcher("/select.jsp");
		rd.forward(request, response);
		return;		
		
	}

}

