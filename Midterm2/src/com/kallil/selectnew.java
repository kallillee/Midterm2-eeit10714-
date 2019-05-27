package com.kallil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Selectnew.do")
public class selectnew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		StringBuffer sb = new StringBuffer();
		List<String> list = new ArrayList<>();
		Midterm2DAO dao = new  Midterm2DAO();
		try {
			list = dao.getCitys();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error getCitys");
		}
		for(String citys:list) {
			sb.append("<option value='"+ citys+"'>"+ citys+"</option>"); 
		}
		
		response.getWriter().print(sb);
	
		
	}

}
