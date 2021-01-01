package com.gui.listener;

import java.awt.event.*;
import javax.swing.JButton;
import com.gui.panel.*;
/**
 * 
 * @ClassName: ToolBarListener.java
 * @Description: Ϊ����������һ�й��������Ӽ��
 *
 * @version: v1.0.0
 * @author: ͯ�ξ�
 * @date: 2020��11��6�� ����11:10:33 
 *
 * Modification History:
 Modification History:
 * Date            Author          Version            Description
 *----------------------------------------------------------------*
 * 2020��11��6��   ͯ�ξ�          v1.0.0               �޸�ԭ��
 */
public class ToolBarListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		MainPanel p = MainPanel.instance;
		JButton b  = (JButton)e.getSource();
		if(b==p.bSpend) {
			p.workingPanel.show(SpendPanel.instance);;
		}else if(b==p.bReport) {
			p.workingPanel.show(ReportPanel.instance);
		}else if(b==p.bCategory) {
			p.workingPanel.show(CategoryPanel.instance);
		}else if(b==p.bRecord) {
			p.workingPanel.show(RecordPanel.instance);
		}else if(b==p.bBackup) {
			p.workingPanel.show(BackupPanel.instance);
		}else if(b==p.bRecover) {
			p.workingPanel.show(RecoverPanel.instance);
		}else if(b==p.bConfig) {
			p.workingPanel.show(ConfigPanel.instance);
		}
	}
}

