package com.gui.panel;

import javax.swing.JPanel;

public abstract class WorkingPanel extends JPanel {
	

	/**   
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)  
	 * 
	 */
	
//	private static final long serialVersionUID = 1L;

	/**
	 * ��Ľ��汣�ֺ����ݿ��ͬ��
	 */
	public abstract void updateData();

	/**
	 * Ϊ�������Ӽ�����
	 */
	public abstract void addListener();
}
