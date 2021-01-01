package com.gui.panel;

import java.awt.*;
import javax.swing.*;

import com.gui.listener.ConfigListener;
import com.service.ConfigService;
import com.util.ColorUtil;
import com.util.GuiUtil;

public class ConfigPanel extends JPanel{
//	private static final long serialVersionUID = 1L;
	static {
		GuiUtil.useLNF();
	}

	public static ConfigPanel instance = new ConfigPanel();
	JLabel IBudget = new JLabel("����Ԥ�㣨����");
	public JTextField tfBudget = new JTextField("2000");// ���뱾��Ԥ��
	JLabel IMysql = new JLabel("MySql��װĿ¼");
	public JTextField tfMysqlPath = new JTextField("C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5");// ����mysql��װĿ¼
	JButton bSubmit = new JButton("����");

	public ConfigPanel() {
		GuiUtil.setColor(ColorUtil.grayColor, IBudget, IMysql);
		GuiUtil.setColor(ColorUtil.blueColor, bSubmit);

		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 1, gap, gap));// ����һ��4��1��,���Ϊ40�����񲼾ֹ�����
		pInput.add(IBudget);
		pInput.add(tfBudget);
		pInput.add(IMysql);
		pInput.add(tfMysqlPath);
		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);
		pSubmit.add(bSubmit);
		this.add(pSubmit, BorderLayout.CENTER);
		addListener();
	}

	public void addListener() {
		ConfigListener listener = new ConfigListener();
		bSubmit.addActionListener(listener);
	}

	public void updateData() {
		String budget = new ConfigService().get(ConfigService.budget);
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		tfBudget.setText(budget);
		tfMysqlPath.setText(mysqlPath);
		tfBudget.grabFocus();
	}

	public static void main(String[] args) {
		GuiUtil.showPanel(ConfigPanel.instance);
	}
}

