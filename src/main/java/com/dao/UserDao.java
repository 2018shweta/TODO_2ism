package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.DBCONNECTION;

public class UserDao {

	public UserBean getUserByUserID(int userId) {
		UserBean user = null;
		try (Connection con = DBCONNECTION.getConnection();
				PreparedStatement psmt = con.prepareStatement("select * from costumertable where userid=?");) {
			psmt.setInt(1, userId);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				user = new UserBean();
				user.setGmail(rs.getString("email"));
				user.setUserlastname(rs.getString("firstname"));
				user.setUserlastname(rs.getString("lastname"));
				user.setGender(rs.getString("gender"));
				user.setPassword(rs.getString("password"));
				user.setQueans("queans");
				user.setUserid(userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public UserBean login(String email, String password) {
		UserBean user = null;
		try {
			Connection con = DBCONNECTION.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select * from costumertable where email = ? and password = ? ");
			pstmt.setString(1, email);
//			System.out.println(email);
			pstmt.setString(2, password);

			// read select
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserid(rs.getInt("userid"));
				user.setUserfirstname(rs.getString("firstname"));
				user.setUsertype(rs.getString("usertype"));
				user.setIsactive(rs.getInt("isactive"));
				//

			}

		} catch (Exception e) {
			System.out.println("SMW in login Dao ");
			e.printStackTrace();
		}

		return user;
	}

	public Boolean duplicate(String gmail, String queans) {

		try {
			Connection con = DBCONNECTION.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from costumertable where email=? and queans=?");
			pstmt.setString(1, gmail);
			pstmt.setString(2, queans);
			System.out.println(gmail);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("SMW in duplicate method Dao ");
			e.printStackTrace();
		}

		return false;

	}

	public UserBean queans(String queans) {
		UserBean user = null;
		try {
			Connection con = DBCONNECTION.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from costumertable where queans=? ");
			pstmt.setString(1, queans);

			// read select
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setQueans(rs.getString("queans"));
				// user.setUserfirstname(rs.getString("firstname"));
				// user.setUsertype(rs.getString("usertype"));
				//

			}

		} catch (Exception e) {
			System.out.println("SMW in queans Dao ");
			e.printStackTrace();
		}

		return user;
	}

	public void insertUser(UserBean userBean) {
		System.out.println("hyinsert");
		try {
			Connection con = DBCONNECTION.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into costumertable (firstname,lastname,email,password,gender,queans,usertype,isactive) values (?,?,?,?,?,?,'customer',?)");
			pstmt.setString(1, userBean.getUserfirstname());
			pstmt.setString(2, userBean.getUserlastname());
			pstmt.setString(3, userBean.getGmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getQueans());
			pstmt.setInt(7, userBean.getIsactive());
			System.out.println(userBean.getIsactive());
			System.out.println("hyinsert");
			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			System.out.println("SMW in insertUser() ");
			e.printStackTrace();
		}

	}

	public Boolean updatepassword(String newpassword, String gmail) {

		try {
			Connection con = DBCONNECTION.getConnection();

			PreparedStatement pstmt = con.prepareStatement("update costumertable set password=? where email=? ");
			pstmt.setString(1, newpassword);
			pstmt.setString(2, gmail);
			System.out.println(newpassword);
			System.out.println(gmail);
			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println("SMW in updatepassword()");
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<UserBean> getAllUsers() {

		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			Connection con = DBCONNECTION.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from costumertable");

			ResultSet rs = pstmt.executeQuery();// select readonly ==>query

			while (rs.next() == true) { // 1st row 2nd row
				int userId = rs.getInt("userid");// db column name
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String usertype = rs.getString("usertype");
				String queans = rs.getString("queans");

				UserBean user = new UserBean();
				user.setUserid(userId);
				user.setUserfirstname(firstName);
				user.setUserlastname(lastName);
				user.setGmail(email);
				user.setPassword(password);
				user.setGender(gender);
				user.setQueans(queans);
				user.setUsertype(usertype);
				users.add(user);
			}
			// go to line num -> 63

			// user1
			// user2

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
			e.printStackTrace();
		}

		return users;
	}

	public Boolean checkGmailDuplication(String gmail) {
		try {
			System.out.println(gmail);
			Connection con = DBCONNECTION.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from costumertable where email=?");
			pstmt.setString(1, gmail);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				return true;
			}

			// go to line num -> 63

		} catch (Exception e) {
			System.out.println("SBM in checkGmailDuplication");
			e.printStackTrace();
		}
		return false;
	}

	public void withoutDuplicateGmailInsert(UserBean userBean) {

		System.out.println("withoutDuplicateGmailInsert method");
		try {
			Connection con = DBCONNECTION.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into costumertable (firstname,lastname,email,password,gender,queans,usertype) values (?,?,?,?,?,?,'customer')");
			pstmt.setString(1, userBean.getUserfirstname());
			pstmt.setString(2, userBean.getUserlastname());
			pstmt.setString(3, userBean.getGmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getQueans());

			System.out.println("withoutDuplicateGmailInsert method");
			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			System.out.println("SMW in insertUser() ");
			e.printStackTrace();
		}

	}

	public int disableUser(int userId) {
		try (Connection con = DBCONNECTION.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("update costumertable set isactive = ? where userid=?");) {
			pstmt.setInt(1, 0);
			pstmt.setInt(2, userId);
			int records = pstmt.executeUpdate();
			return records;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
