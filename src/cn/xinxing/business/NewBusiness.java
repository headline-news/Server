package cn.xinxing.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xinxing.model.News;

public class NewBusiness {
	public static List<News> getAllNews() {
		List<News> list = new ArrayList<News>();
		String sql = null;
		DBHelper db1 = null;
		sql = "select *from new";// SQL
		db1 = new DBHelper(sql);//
		ResultSet ret = null;
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				int id = ret.getInt(1);
				String ip = ret.getString(2);
				News news = new News();
				news.setId(id);
				news.setIP(ip);
				list.add(news);
			} //
			ret.close();
			db1.close();//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //

		return list;
	}
	
	
	/**
	 * @param _id
	 * @return
	 */
	public static Boolean getYesStatus(String _id, String _ip) {
		String sql = null;
		DBHelper db1 = null;
		sql = "select count(*) from new where (id = " + _id +" and ip = '" + _ip +"')";// 
		System.out.println("sql:    "    +    sql);   
		
		db1 = new DBHelper(sql);// 
		ResultSet ret = null;
		int count = 0;
		try {
			ret = db1.pst.executeQuery();
			ret.next();
			count = ret.getInt(1);
			ret.close();
			db1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return count > 0;
	}

	/**
	 * @param _id
	 * @return
	 */
	public static int getYesCount(String _id) {
		String sql = null;
		DBHelper db1 = null;
		sql = "select count(*) from new where (id = " + _id + ");";// 
		System.out.println("sql:    "    +    sql);   
		db1 = new DBHelper(sql);// 
		ResultSet ret = null;
		int count = -1;
		try {
			ret = db1.pst.executeQuery();
			ret.next();
			count = ret.getInt(1);
			ret.close();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return count;
	}
	
	/**
	 * @param _id
	 * @return
	 */
	public static News getNewInfoById(String _id) {
		String sql = null;
		DBHelper db1 = null;
		sql = "select * from new where id =" + _id;// 
		System.out.println("sql:    "    +    sql);   
		db1 = new DBHelper(sql);// 
		ResultSet ret = null;
		News news = new News();
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				int id = ret.getInt(1);
				String ip = ret.getString(2);
				news.setId(id);
				news.setIP(ip);
			} // 
			ret.close();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return news;
	}
	
	public static void addData(String _id, String _ip) {
		String sql = null;
		DBHelper db1 = null;
		sql = "insert into `news_manage`.`new` (`id`, `ip`) VALUES ('" + _id +"', '" + _ip + "')";
		System.out.println("sql:    "    +    sql);   
		System.out.println("SQL:    "    +    sql);   
		//sql = "insert into new (`id`, `ip`) VALUES (4, 999.111)";
		db1 = new DBHelper(sql);
		try {
			int row = db1.pst.executeUpdate();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return;
	}
	
	
	public static void deleteData(String _id, String _ip) {
		String sql = null;
		DBHelper db1 = null;
		sql = "delete from `news_manage`.`new` where id=" + _id + " and ip= '" + _ip + "'";
		System.out.println("SQL:    "    +    sql);   
		//sql = "insert into new (`id`, `ip`) VALUES (4, 999.111)";
		db1 = new DBHelper(sql);
		try {
			int row = db1.pst.executeUpdate();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return;
	}
}




