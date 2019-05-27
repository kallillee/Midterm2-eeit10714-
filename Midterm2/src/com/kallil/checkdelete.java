package com.kallil;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkdelete
 */
@WebServlet("/check.do")
public class checkdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		int codeInt =Integer.parseInt(code);
		Midterm2DAO dao=new Midterm2DAO();
		boolean b = false;
		try {
			b = dao.delete(codeInt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(b) {
			System.out.println("成功");
			request.setAttribute("check", codeInt);
			RequestDispatcher rd = request.getRequestDispatcher("/deletes.jsp");
			rd.forward(request, response);
			return;
		}else {
			System.out.println("失敗");
			request.setAttribute("error", "刪除編號"+codeInt+"資料失敗.");
			RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
			rd.forward(request, response);
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
