package com.service;

import java.util.*;

import com.dao.*;
import com.entity.*;

/**
 * 
 * @ClassName: CategoryService.java
 * @Description: Category����й��ܵ�ʵ��
 *
 * @version: v1.0.0
 * @author: ͯ�ξ�
 * @date: 2020��11��11�� ����9:24:39
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020��11��11�� ͯ�ξ� v1.0.0 �޸�ԭ��
 */

public class CategoryService {
	CategoryDAO categoryDAO = new CategoryDAO();
	RecordDAO recordDAO = new RecordDAO();

	public List<Category> list() {
		// ��Category���е�����ȡ����,����id����Record��
		List<Category> cs = categoryDAO.list();
		for (Category c : cs) {
			List<Record> rs = recordDAO.list(c.id);
			c.recordNumber = rs.size();
		}
		// ��cs�е����ݽ��н�������,Lambda���ʽ
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
