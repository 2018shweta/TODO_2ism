package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpSession;

import com.bean.TaskBean;
import com.bean.UserBean;
import com.util.DBCONNECTION;

public class TaskDao {

	public void insertlist(TaskBean taskBean, int userId) {
		try {
			Connection con = DBCONNECTION.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"insert into tasktable (taskname,description,status,priority,date,userid) values (?,?,?,?,?,?)");

			pstmt.setString(1, taskBean.getTaskname());
			pstmt.setString(2, taskBean.getDescription());
			pstmt.setString(3, taskBean.getStatus());
			pstmt.setString(4, taskBean.getPriority());
			pstmt.setString(5, taskBean.getDate());
			pstmt.setInt(6, userId);

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW TaskDao :: insertlist()");
			e.printStackTrace();
		}
	}

	public static ArrayList<TaskBean> getAllTask(int userId) {

		System.out.println("shweta");
		ArrayList<TaskBean> tasks = new ArrayList<>();

		try {
			Connection con = DBCONNECTION.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from tasktable where userid=?");
			System.out.println("shweta");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("shweta");
				TaskBean t = new TaskBean();
				t.setTaskid(rs.getInt("taskid"));
				t.setTaskname(rs.getString("taskname"));
				t.setDescription(rs.getString("description"));
				t.setStatus(rs.getString("status"));
				t.setPriority(rs.getString("priority"));
				t.setDate(rs.getString("date"));
				t.setUserid(userId);
				tasks.add(t);
				System.out.println(t);
			}
		} catch (Exception e) {
			System.out.println("Smw in taskDao::getAllTask()");
			e.printStackTrace();
		}
		return tasks;
	}

	public boolean deleteTask(int taskid) {

		try {
			Connection con = DBCONNECTION.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from tasktable where taskid=?");
			pstmt.setInt(1, taskid);
			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println("SMW in taskDao:deleteTask()");
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateTask(TaskBean task) {
		System.out.println("enter updatetask method");
		boolean flag = false;
		try (Connection con = DBCONNECTION.getConnection();
				PreparedStatement psmt = con.prepareStatement(
						"update tasktable set taskname = ?, description=?,status=?,priority=?,date=? where taskid=?");) {
			System.out.println("enter updatetask method");
			psmt.setString(1, task.getTaskname());
			System.out.println(task.getTaskname());
			psmt.setString(2, task.getDescription());
			psmt.setString(3, task.getStatus());
			psmt.setString(4, task.getPriority());
			System.out.println("dao" + task.getPriority());
			psmt.setString(5, task.getDate());
			psmt.setInt(6, task.getTaskid());
			System.out.println("taskid" + task.getTaskid());// ahiya a zero batave
			int updateCount = psmt.executeUpdate();
			System.out.println("count" + updateCount);
			if (updateCount == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public TaskBean getTaskByTaskid(int taskid) {
		TaskBean task = null;
		try (Connection con = DBCONNECTION.getConnection();
				PreparedStatement psmt = con.prepareStatement("select * from tasktable where taskid=?");) {
			psmt.setInt(1, taskid);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				task = new TaskBean();
				task.setTaskname(rs.getString("taskname"));
				task.setDescription(rs.getString("description"));
				task.setStatus(rs.getString("status"));
				task.setPriority(rs.getString("priority"));
				task.setDate(rs.getString("date"));
				task.setTaskid(rs.getInt("taskid"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}

	public Boolean taskDone(int taskid) {
		Boolean flag = false;
		try (Connection con = DBCONNECTION.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update tasktable set status=? where taskid=?")) {
			pstmt.setString(1, "done");
			pstmt.setInt(2, taskid);
			int updateDone = pstmt.executeUpdate();

			if (updateDone == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("SWM:taskDao :taskDone in error ");
			e.printStackTrace();
		}
		return flag;
	}

	public int countPercentage(int userid) {

		ArrayList<TaskBean> tasks = getAllTask(userid);
		try {

			int done = 0;
			int total = tasks.size();
			for (TaskBean task : tasks) {
				if (task.getStatus().equals("done")) {
					done += 1;
				}
			}
			int persentage = (done * 100) / total;
			return persentage;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
