package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ItemBean;

public class ItemDAO2 {
	String url = "jdbc:postgresql:sample";
	String user = "student";
	String pass = "himitu";
		
	public ItemDAO2() throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}
	
	public List<ItemBean> findAll() throws DAOException {
		String sql ="SELECT * FROM item";
		
		try(
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				){
			List<ItemBean> list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(code,name,price);
				list.add(bean);
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	public List<ItemBean> sortPrice(boolean isAscending)throws DAOException{
		String sql;
		if(isAscending)
			sql = "SELECT * FROM item ORDER BY price";
		else
			sql = "SELECT * FROM item ORDER BY price desc";
		try(
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				){
			List<ItemBean> list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(code,name,price);
				list.add(bean);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}
	public int addItem(String name, int price)throws DAOException{
		String sql = "INSERT INTO item(name,price) VALUES(?,?)";
		
		try(
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);){
				st.setString(1, name);
				st.setInt(2, price);
				int rows = st.executeUpdate();
				return rows;}catch (SQLException e) {
					e.printStackTrace();
					throw new DAOException("レコードの操作に失敗しました。");
				}
	}
	public List<ItemBean> findByPrice(int lePrice) throws DAOException {
		String sql ="SELECT * FROM item WHERE price <= ?";
		
		try(
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement st = con.prepareStatement(sql);){
				st.setInt(1, lePrice);
				
				try(
						ResultSet rs = st.executeQuery();){
			List<ItemBean> list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(code,name,price);
				list.add(bean);
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}catch(SQLException e) {
		e.printStackTrace();
		throw new DAOException("レコードの取得に失敗しました。");
	}
	}
	
	public int deleteByPrimaryKey(int key)throws DAOException{
		String sql = "DELETE FROM item WHERE code = ?";
		
		try(
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);){
				st.setInt(1, key);
				int rows = st.executeUpdate();
				return rows;}catch (SQLException e) {
					e.printStackTrace();
					throw new DAOException("レコードの操作に失敗しました。");
				}
	}
	public int modyfiByPrice(int price,int code)throws DAOException{
		String sql = "UPDATE item SET price =? WHERE code = ?";
		
		try(
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);){
				st.setInt(1, price);
				st.setInt(2, code);
				int rows = st.executeUpdate();
				return rows;}catch (SQLException e) {
					e.printStackTrace();
					throw new DAOException("レコードの操作に失敗しました。");
				}
	}
	
	
}
