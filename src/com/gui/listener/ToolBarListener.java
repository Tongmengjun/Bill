package com.gui.listener;

import java.awt.event.*;
import javax.swing.JButton;
import com.gui.panel.*;
/**
 * 
 * @ClassName: ToolBarListener.java
 * @Description: 为面板最上面的一行工具面板添加监控
 *
 * @version: v1.0.0
 * @author: 童梦君
 * @date: 2020年11月6日 上午11:10:33 
 *
 * Modification History:
 Modification History:
 * Date            Author          Version            Description
 *----------------------------------------------------------------*
 * 2020年11月6日   童梦君          v1.0.0               修改原因
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

