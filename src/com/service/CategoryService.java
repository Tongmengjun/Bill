package com.service;

import java.util.*;

import com.dao.*;
import com.entity.*;

/**
 * 
 * @ClassName: CategoryService.java
 * @Description: Category面板中功能的实现
 *
 * @version: v1.0.0
 * @author: 童梦君
 * @date: 2020年11月11日 下午9:24:39
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020年11月11日 童梦君 v1.0.0 修改原因
 */

public class CategoryService {
	CategoryDAO categoryDAO = new CategoryDAO();
	RecordDAO recordDAO = new RecordDAO();

	public List<Category> list() {
		// 将Category表中的数据取出来,并将id存入Record中
		List<Category> cs = categoryDAO.list();
		for (Category c : cs) {
			List<Record> rs = recordDAO.list(c.id);
			c.recordNumber = rs.size();
		}
		// 将cs中的数据进行降序排序,Lambda表达式
		Collections.sort(cs, (c1, c2) -> c2.recordNumber - c1.recordNumber);
		return cs;
	}

	public void add(String name) {
		Category c = new Category();
		c.setName(name);
		categoryDAO.add(c);
	}

	public void update(int id, String name) {
		Category c = new Category();
		c.setName(name);
		c.setId(id);
		categoryDAO.update(c);
	}

	public void delete(int id) {
		categoryDAO.delete(id);
	}
}
