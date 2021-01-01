package com.util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.gui.panel.WorkingPanel;

/**
 * 
 * @ClassName: CenterPanel.java
 * @Description: �������
 *
 * @version: v1.0.0
 * @author: ͯ�ξ�
 * @date: 2020��11��2�� ����3:39:41
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020��11��2�� ͯ�ξ� v1.0.0 �޸�ԭ��
 */
public class CenterPanel extends JPanel {
	/**   
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)  
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private double rate;// ����������
	private JComponent c;// ��ʾ�����
	private boolean strech;// �Ƿ�����
	// ���캯��

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
			// Dimension��Java��һ���࣬��װ��һ�������ĸ߶ȺͿ�ȣ�
			Dimension containerSize = this.getSize();// ��ȡ�� Dimension����Ĵ�С
			Dimension compotentSize = c.getPreferredSize();// ��ȡ�������ѡ��С
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
		// �����¼���Component��������ö�����һ�� Component���򷵻� null
		Component[] cs = getComponents();// ���������ȡ����
		for (Component c : cs) {
			remove(c);// �Ƴ���������е��������
		}

		/**
		 * �ж���Ҫ��ʾ������Ƿ���WorkingPanel �� ����Ҫ��updateDate()���ý�����ʾ�����ݿ�ͬ��
		 */
		add(p);// ��Ҫ��ʾ������ӽ���
		if (p instanceof WorkingPanel) {
			((WorkingPanel) p).updateData();
		}
		this.updateUI();

	}

}
