package com.kallil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Midterm2DAO {

	private DataSource ds = null;

	public Midterm2DAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Midterm2");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}

	private static final String INSERT_STMT = "INSERT INTO schoolNumOfPeople values(?,?,?,?,?,?,?)";

	public int insert(Midterm2Bean m) throws SQLException {
		int i = 0;
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT_STMT);) {

			PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, m.getCode());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getPborpv());
			pstmt.setString(4, m.getCity());
			pstmt.setString(5, m.getAddr());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getUrl());
			i = pstmt.executeUpdate();
		}
		return i;
	}

	private static final String UPDATE_STMT = "UPDATE  schoolNumOfPeople SET name= ? ,pborpv= ? ,city= ? ,addr= ? ,phone= ? ,url= ? where code=?";

	public boolean update(Midterm2Bean m) throws SQLException {
		int i;
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);) {
			pstmt.setInt(7, m.getCode());
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getPborpv());
			pstmt.setString(3, m.getCity());
			pstmt.setString(4, m.getAddr());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getUrl());
			i = pstmt.executeUpdate();
			pstmt.close();
		}
		if (i == 1)
			return true;
		else
			return false;
	}

	private static final String DELETE_STMT = "DELETE from schoolNumOfPeople WHERE code = ? ";

	public boolean delete(int code) throws SQLException {
		int i;
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);) {
			pstmt.setInt(1, code);

			i = pstmt.executeUpdate();
			pstmt.close();
		}
		if (i == 1)
			return true;
		else
			return false;
	}

	private static final String GET_ONE_STMT = "SELECT code,name,pborpv,city,addr,phone,url FROM schoolNumOfPeople WHERE code = ?  ";

	public Midterm2Bean findOne(int code) throws SQLException {
		Midterm2Bean bean = new Midterm2Bean();

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT)) {
			pstmt.setInt(1, code);
			ResultSet rs = pstmt.executeQuery();
			if (rs == null)
				return null;
			while (rs.next()) {
				bean.setCode(code);
				bean.setName(rs.getString("name"));
				bean.setPborpv(rs.getString("pborpv"));
				bean.setCity(rs.getString("city"));
				bean.setAddr(rs.getString("addr"));
				bean.setPhone(rs.getString("phone"));
				bean.setUrl(rs.getString("url"));
			}
			pstmt.close();
		}
		return bean;
	}

	private static final String GET_ALL_STMT = "SELECT code,name,pborpv,city,addr,phone,url FROM schoolNumOfPeople ORDER BY code";

	public List<Midterm2Bean> findAll() throws SQLException {
		List<Midterm2Bean> mtbs;
		Midterm2Bean mtb ;
		try (Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT)) {
			
			mtbs = new ArrayList<Midterm2Bean>();

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				mtb = new Midterm2Bean();
				mtb.setCode(rs.getInt("code"));
				mtb.setName(rs.getString("name"));
				mtb.setPborpv(rs.getString("pborpv"));
				mtb.setCity(rs.getString("city"));
				mtb.setAddr(rs.getString("addr"));
				mtb.setPhone(rs.getString("phone"));
				mtb.setUrl(rs.getString("url"));
				mtbs.add(mtb);
			}
			pstmt.close();
		}

		return mtbs;
	}
	
	private static final String GET_CITY = "SELECT code,name,pborpv,city,addr,phone,url FROM schoolNumOfPeople WHERE city =?  ";

	public List<Midterm2Bean> findCity(String city) throws SQLException {
		List<Midterm2Bean> mtbs;
		Midterm2Bean mtb ;
		try (Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(GET_CITY)) {
//			String citynew = "%" + city + "%";
			pstmt.setString(1, city);		
			mtbs = new ArrayList<Midterm2Bean>();			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				mtb = new Midterm2Bean();
				mtb.setCode(rs.getInt("code"));
				mtb.setName(rs.getString("name"));
				mtb.setPborpv(rs.getString("pborpv"));
				mtb.setCity(rs.getString("city"));
				mtb.setAddr(rs.getString("addr"));
				mtb.setPhone(rs.getString("phone"));
				mtb.setUrl(rs.getString("url"));
				mtbs.add(mtb);
			}
			pstmt.close();
		}

		return mtbs;
	}
	
	private static final String CITYSTRING = "select DISTINCT city from [schoolNumOfPeople] order by city";
	
	public List<String> getCitys() throws SQLException{
		List<String> citys;
		try (Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(CITYSTRING)) {
		
			citys = new ArrayList<String>();			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				citys.add(rs.getString("city"));
			}
			pstmt.close();
		}

		return citys;
	}

}
