package com.gui.panel;

import javax.swing.JPanel;

public abstract class WorkingPanel extends JPanel {
	

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	 * 
	 */
	
//	private static final long serialVersionUID = 1L;

	/**
	 * 活动的界面保持和数据库的同步
	 */
	public abstract void updateData();

	/**
	 * 为活动界面添加监听器
	 */
	public abstract void addListener();
}
