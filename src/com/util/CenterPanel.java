package com.util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.gui.panel.WorkingPanel;

/**
 * 
 * @ClassName: CenterPanel.java
 * @Description: 居中面板
 *
 * @version: v1.0.0
 * @author: 童梦君
 * @date: 2020年11月2日 下午3:39:41
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020年11月2日 童梦君 v1.0.0 修改原因
 */
public class CenterPanel extends JPanel {
	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private double rate;// 面板拉伸比例
	private JComponent c;// 显示的组件
	private boolean strech;// 是否拉伸
	// 构造函数

	public CenterPanel(double rate, boolean strech) {
		this.setLayout(null);
		this.rate = rate;
		this.strech = strech;
	}

	public CenterPanel(double rate) {
		this(rate, true);
	}

	public void repaint() {
		if (null != c) {
			// Dimension是Java的一个类，封装了一个构件的高度和宽度，
			Dimension containerSize = this.getSize();// 获取此 Dimension对象的大小
			Dimension compotentSize = c.getPreferredSize();// 获取组件的首选大小
			if (strech) {
				c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
			} else {
				c.setSize(compotentSize);
			}
			c.setLocation(containerSize.width / 2 - c.getSize().width / 2,
					containerSize.height / 2 - c.getSize().height / 2);
		}
		super.repaint();
	}

	public void show(JComponent p) {
		this.c = p;
		// 发起事件的Component对象，如果该对象不是一个 Component，则返回 null
		Component[] cs = getComponents();// 将所有组件取出来
		for (Component c : cs) {
			remove(c);// 移除现在面板中的所有组件
		}

		/**
		 * 判断需要显示的面板是否是WorkingPanel 是 则需要用updateDate()来让界面显示和数据库同步
		 */
		add(p);// 将要显示的组件加进来
		if (p instanceof WorkingPanel) {
			((WorkingPanel) p).updateData();
		}
		this.updateUI();

	}

}
