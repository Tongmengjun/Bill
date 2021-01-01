package com.gui.panel;

import java.awt.BorderLayout;

import javax.swing.*;
import com.gui.listener.ToolBarListener;
import com.util.CenterPanel;
import com.util.GuiUtil;

public class MainPanel extends JPanel {
//	private static final long serialVersionUID = 1L;
	static {
		GuiUtil.useLNF();
	}
	public static MainPanel instance = new MainPanel();
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();// ����һ��
	public JButton bRecord = new JButton();// ��¼
	public JButton bCategory = new JButton();// ���ѷ���
	public JButton bReport = new JButton();// �����ѱ���
	public JButton bConfig = new JButton();// ����
	public JButton bBackup = new JButton();// ����
	public JButton bRecover = new JButton();// �ָ�

	public CenterPanel workingPanel;

	private MainPanel() {
		GuiUtil.setImageIcon(bSpend, "home.png", "����һ��");
		GuiUtil.setImageIcon(bRecord, "record.png", "��һ��");
		GuiUtil.setImageIcon(bCategory, "category2.png", "���ѷ���");
		GuiUtil.setImageIcon(bReport, "report.png", "�����ѱ���");
		GuiUtil.setImageIcon(bConfig, "config.png", "����");
		GuiUtil.setImageIcon(bBackup, "backup.png", "����");
		GuiUtil.setImageIcon(bRecover, "recover.png", "�ָ�");
		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		tb.setFloatable(false);
		workingPanel = new CenterPanel(0.8);
		setLayout(new BorderLayout());
		add(tb, BorderLayout.NORTH);
		add(workingPanel, BorderLayout.CENTER);
		addListener();
	}

	private void addListener() {
		ToolBarListener listener = new ToolBarListener();
		bSpend.addActionListener(listener);
		bRecord.addActionListener(listener);
		bCategory.addActionListener(listener);
		bReport.addActionListener(listener);
		bConfig.addActionListener(listener);
		bBackup.addActionListener(listener);
		bRecover.addActionListener(listener);
	}
}
