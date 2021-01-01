package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.util.DBUtil;
import com.entity.Category;

//消费分类DAO
public class CategoryDAO {
	// 获取总数
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection();
				// 获取Statement对象
				Statement s = c.createStatement();) {
			String sql = "select count(*) from 	category";// 返回category表中的总数
			ResultSet rs = s.executeQuery(sql);// 执行sql语句
			while (rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("total:" + total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	// 添加数据
	public void add(Category category) {
		String sql = "insert into category values(null,?)";// ?是占位符，代表数据参数，null为添加空值
		try (Connection c = DBUtil.getConnection();
//				创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库。 				
//				带有 IN 参数或不带有 IN 参数的 SQL 语句都可以被预编译并存储在 PreparedStatement 对象中。然后可以有效地使用此对象来多次执行该语句。
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, category.name);
			ps.execute();
			// 获取执行此 PreparedStatement对象而创建的所有自动生成的键。
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				// rs.getInt(1)表示,从这个结果集的第一行第一列里拿值
				int id = rs.getInt(1);
				category.id = id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 根据id删除数据
	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "delete form category where id =" + id;
			s.execute(sql);// 执行sql语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 更新
	public void update(Category category) {
		String sql = "update category set name = ? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, category.name);
			ps.setInt(2, category.id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 根据id获取对象
	public Category get(int id) {
		Category category = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "select * from category whete id=" + id;
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				category = new Category();
				String name = rs.getString(2);
				category.name = name;
				category.id = id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	
	/*// 查询表中所有(最长为short)
	public List<Category> list() {
		return list(0, Short.MAX_VALUE);
	}*/

	// 分页查询
	/*public List<Category> list(int start, int count) {
		List<Category> categorys = new ArrayList<Category>();
		// select *form category 查询 category表
		// order by id desc 按照id列大小降序排列
		// limit ?,? ‘?’占位符，从?到?
		String sql = "select * from category order by id desc limit ?,?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				category.id = id;
				category.name = name;
				categorys.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorys;
	}*/
	
	public List<Category>list(){
		return list(0,Short.MAX_VALUE);
	}
	
	public List<Category> list(int start,int count){
		List<Category> categorys = new ArrayList<Category>();
		String sql = "select * from category order by id desc limit ?,?";
		try(Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				int id =rs.getInt(1);
				String name = rs.getString(2);
				category.id=id;
				category.name=name;
				categorys.add(category);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorys;
	}
	
}