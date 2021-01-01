package com.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import com.gui.page.SpendPage;
import com.service.SpendService;
import com.util.CircleProgressBar;
import com.util.ColorUtil;
import com.util.GuiUtil;

/*public class SpendPanel extends JPanel {
	static {
		GuiUtil.useLNF();
	}
//	private static final long serialVersionUID = 1L;
	public static SpendPanel instance = new SpendPanel();
	public JLabel lMonthSpend = new JLabel("��������");
	public JLabel lTodaySpend = new JLabel("��������");
	public JLabel lAvgSpendPerDay = new JLabel("�վ�����");
	public JLabel lMonthLeft = new JLabel("����ʣ��");
	public JLabel lDayAvgAvailable = new JLabel("�վ�����");
	public JLabel lMonthLeftDay = new JLabel("������ĩ");

	// Ĭ��SpendPanel����
	public JLabel vMonthSpend = new JLabel("2300");
	public JLabel vTodaySpend = new JLabel("25");
	public JLabel vAvgSpendPerDay = new JLabel("120");
	public JLabel vMonthAvailable = new JLabel("2084");
	public JLabel vDayAvgAvailable = new JLabel("389");
	public JLabel vMonthLeftDay = new JLabel("15");

	CircleProgressBar bar;

	public SpendPanel() {
		this.setLayout(new BorderLayout());
		bar = new CircleProgressBar();
		bar.setBackground(ColorUtil.blueColor);
		GuiUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
				lMonthLeftDay);
		GuiUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
		vMonthSpend.setFont(new Font("΢���ź�", Font.BOLD, 23));
		vTodaySpend.setFont(new Font("΢���ź�", Font.BOLD, 23));
		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
	}
	
	private JPanel center() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(west(), BorderLayout.WEST);
		p.add(center2(), BorderLayout.CENTER);
		return p;
	}
	
	// �ұ�����Ϊ���ν�����
	private JComponent center2() {
		return bar;
	}

	// �ұ�����Ϊ��������,�������ѵ�����
	private JPanel west() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		p.add(lMonthSpend);
		p.add(vMonthSpend);
		p.add(lTodaySpend);
		p.add(vTodaySpend);
		return p;
	}

	// ��������Ϊ�վ����ѡ�����ʣ�ࡢ�վ����á�������ĩ����
	private JPanel south() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 4));
		p.add(lAvgSpendPerDay);
		p.add(lMonthLeft);
		p.add(lDayAvgAvailable);
		p.add(lMonthLeftDay);
		p.add(vAvgSpendPerDay);
		p.add(vMonthAvailable);
		p.add(vDayAvgAvailable);
		p.add(vMonthLeftDay);
		return p;
	}

	public void updateData() {
		// TODO Auto-generated method stub
		SpendPage spend = new SpendService().getSpendPage();
		vMonthSpend.setText(spend.monthSpend);
		vTodaySpend.setText(spend.todaySpend);
		vAvgSpendPerDay.setText(spend.avgSpendPerDay);
		vMonthAvailable.setText(spend.monthAvailable);
		vDayAvgAvailable.setText(spend.dayAvgAvailable);
		vMonthLeftDay.setText(spend.monthLeftDay);
		bar.setProgress(spend.usagePercentage);
		if (spend.isOverSpend) {
			vMonthAvailable.setForeground(ColorUtil.warningColor);
			vMonthSpend.setForeground(ColorUtil.warningColor);
			vTodaySpend.setForeground(ColorUtil.warningColor);
		} else {
			vMonthAvailable.setForeground(ColorUtil.grayColor);
			vMonthSpend.setForeground(ColorUtil.blueColor);
			vTodaySpend.setForeground(Color.blue);
		}
		bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
		addListener();
	}

	public void addListener() {

	}

	public static void main(String[] args) {
		GuiUtil.showPanel(SpendPanel.instance);
	}

}*/
public class SpendPanel extends WorkingPanel {
    static{
        GuiUtil.useLNF();
    }
    public static SpendPanel instance = new SpendPanel();

    public JLabel IMonthSpend=new JLabel("��������");
    public JLabel ITodaySpend=new JLabel("��������");
    public JLabel IAvgSpendPerDay=new JLabel("�վ�����");
    public JLabel IMonthLeft=new JLabel("����ʣ��");
    public JLabel lDayAvgAvailable=new JLabel("�վ�����");
    public JLabel lMonthLeftDay = new JLabel("������ĩ");

    public JLabel vMonthSpend = new JLabel("��");
    public JLabel vTodaySpend = new JLabel("��");
    public JLabel vAvgSpendPerDay = new JLabel("��");
    public JLabel vMonthAvailable = new JLabel("��");
    public JLabel vDayAvgAvailable = new JLabel("��");
    public JLabel vMonthLeftDay = new JLabel("");

    CircleProgressBar bar;

    public SpendPanel(){
        this.setLayout(new BorderLayout());
        bar=new CircleProgressBar();
        bar.setBackgroundColor(ColorUtil.blueColor);
        GuiUtil.setColor(ColorUtil.grayColor,IMonthSpend, ITodaySpend, IAvgSpendPerDay, IMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GuiUtil.setColor(ColorUtil.blueColor,vMonthSpend, vTodaySpend);
        vMonthSpend.setFont(new Font("΢���ź�",Font.BOLD,23));
        vTodaySpend.setFont(new Font("΢���ź�",Font.BOLD,23));
        this.add(center(),BorderLayout.CENTER);
        this.add(south(),BorderLayout.SOUTH);
    }

    private JPanel center(){
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(),BorderLayout.WEST);
        p.add(center2(),BorderLayout.CENTER);
        return p;
    }

    private Component center2(){
        return bar;
    }

    private JPanel west(){
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(4,1));
        p.add(IMonthSpend);
        p.add(vMonthSpend);
        p.add(ITodaySpend);
        p.add(vTodaySpend);
        return p;
    }

    private JPanel south(){
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(2,4));
        p.add(IAvgSpendPerDay);
        p.add(IMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);
        return p;
    }

    public void updateData() {
        SpendPage spend = new SpendService().getSpendPage();
        vMonthSpend.setText(spend.monthSpend);
        vTodaySpend.setText(spend.todaySpend);
        vAvgSpendPerDay.setText(spend.avgSpendPerDay);
        vMonthAvailable.setText(spend.monthAvailable);
        vDayAvgAvailable.setText(spend.dayAvgAvailable);
        vMonthLeftDay.setText(spend.monthLeftDay);

        bar.setProgress(spend.usagePercentage);
        if (spend.isOverSpend) {
            vMonthAvailable.setForeground(ColorUtil.warningColor);
            vMonthSpend.setForeground(ColorUtil.warningColor);
            vTodaySpend.setForeground(ColorUtil.warningColor);

        } else {
            vMonthAvailable.setForeground(ColorUtil.grayColor);
            vMonthSpend.setForeground(ColorUtil.blueColor);
            vTodaySpend.setForeground(ColorUtil.blueColor);
        }
        bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
        addListener();
    }

    public void addListener() {

    }
    public static void main(String[] args){
        GuiUtil.showPanel(SpendPanel.instance);
    }


}

