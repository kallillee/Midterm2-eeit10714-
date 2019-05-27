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


@WebServlet("/SelectCity.do")
public class selectcity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StringBuffer sb = new StringBuffer();
		String city = request.getParameter("city");
		sb.append("<tr><td width='50px'>編號</td><td width='170px'>學校名稱</td><td width='70px'>公/私立</td><td width='80px'>所在縣市</td><td width='350px'>學校地址</td><td width='100px'>學校電話</td><td width='150px'>學校網站</td></tr>");
		Midterm2DAO dao = new Midterm2DAO();
		List<Midterm2Bean> list = new ArrayList<>();
		try {
			list= dao.findCity(city);
			System.out.println(city);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list==null) {
			request.setAttribute("alldata", "");
			request.setAttribute("error", "查無資料!");
			
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
		request.setAttribute("error", "");
		RequestDispatcher rd = request.getRequestDispatcher("/select.jsp");
		rd.forward(request, response);
		return;		
		
	
	}

}
