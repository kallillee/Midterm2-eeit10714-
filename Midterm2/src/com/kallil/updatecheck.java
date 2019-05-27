package com.kallil;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Updatecheck.do")
public class updatecheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		int codeInt = Integer.parseInt(code);
		Midterm2DAO dao = new Midterm2DAO();
		Midterm2Bean beanold = new Midterm2Bean();
		Midterm2Bean beannew = new Midterm2Bean();
		try {
			beanold = dao.findOne(codeInt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (beanold.getName() == null) {
			request.setAttribute("error", "½Ð¤Å§ó°Ê½s½X.");
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
			return;
		}
		String newname = request.getParameter("name");
		String newpborpv = request.getParameter("pborpv");
		String newcity = request.getParameter("city");
		String newaddr = request.getParameter("addr");
		String newphone = request.getParameter("phone");
		String newurl = request.getParameter("url");
		beannew.setCode(codeInt);
		beannew.setName(newname);
		beannew.setPborpv(newpborpv);
		beannew.setCity(newcity);
		beannew.setAddr(newaddr);
		beannew.setPhone(newphone);
		beannew.setUrl(newurl);

		try {
			dao.update(beannew);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("beanold", beanold);
		request.setAttribute("beannew", beannew);
		RequestDispatcher rd = request.getRequestDispatcher("/updates.jsp");
		rd.forward(request, response);
		return;
	}

}
