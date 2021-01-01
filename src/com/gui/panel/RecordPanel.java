package com.gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.*;
import org.jdesktop.swingx.JXDatePicker;
import com.entity.Category;
import com.gui.listener.RecordListener;
import com.gui.model.CategoryComboBoxModel;
import com.service.CategoryService;
import com.util.ColorUtil;
import com.util.GuiUtil;

public class RecordPanel extends WorkingPanel {
//	private static final long serialVersionUID = 1L;
	static {
		GuiUtil.useLNF();
	}
	public static RecordPanel instance = new RecordPanel();
	JLabel lSpend = new JLabel("���ѣ���))");
	JLabel lCategory = new JLabel("����");
	JLabel lComment = new JLabel("��ע");
	JLabel lDate = new JLabel("����");

	public JTextField tfSpend = new JTextField("0");// ���뻨��

	public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);// �������ѷ���
	public JTextField tfComment = new JTextField();// ���뱸ע
	public JXDatePicker datepick = new JXDatePicker(new Date());// ��������

	JButton bSubmit = new JButton("��һ��");

	public RecordPanel() {
		// ����Ϊ��ɫ
		GuiUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
		GuiUtil.setColor(ColorUtil.blueColor, bSubmit);// Ϊ"��һ��"��ť����Ϊ��ɫ
		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 2, gap, gap));
		pInput.add(lSpend);
		pInput.add(tfSpend);
		pInput.add(lCategory);
		pInput.add(cbCategory);
		pInput.add(lComment);
		pInput.add(tfComment);
		pInput.add(lDate);
		pInput.add(datepick);
		pSubmit.add(bSubmit);

		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);
		this.add(pSubmit, BorderLayout.CENTER);
		addListener();
	}

	public Category getSelectedCategory() {
		return (Category) cbCategory.getSelectedItem();
	}

	public void updateData() {
		// ���¸�ֵcbModel�е�cs����
		cbModel.cs = new CategoryService().list();
		// ������Ⱦ
		cbCategory.updateUI();
		resetInput();
		tfSpend.grabFocus();
	}

	private void resetInput() {
		tfSpend.setText("0");
		tfComment.setText("");
		if (0 != cbModel.cs.size()) {
			cbCategory.setSelectedIndex(0);
		}
		datepick.setDate(new Date());
	}

	public void addListener() {
		RecordListener listener = new RecordListener();
		bSubmit.addActionListener(listener);
	}

	public static void main(String[] args) {
		GuiUtil.showPanel(RecordPanel.instance);
	}
}

