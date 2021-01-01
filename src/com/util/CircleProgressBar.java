package com.util;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 * 
 * @ClassName: CircleProgressBar.java
 * @Description: 消费一览中的环形进度条
 *
 * @version: v1.0.0
 * @author: 童梦君
 * @date: 2020年11月2日 下午3:38:44
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020年11月2日 童梦君 v1.0.0 修改原因
 */
public class CircleProgressBar extends JPanel {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private int minimumProgress;
	private int maximumProgress;
	private int progress;
	private String progressText;
	private Color backgroundColor;// 背景色
	private Color foregroundColor;// 前景色
	// 初始化

	public CircleProgressBar() {
		minimumProgress = 0;
		maximumProgress = 100;
		progressText = "0%";
	}

	// Graphics类是所有图形上下文的抽象基类，允许应用程序在组件（已经在各种设备上实现）以及闭屏图像上进行绘制。
	public void paint(Graphics g) {
		super.paint(g);
		// 用于在 Java(tm) 平台上呈现二维形状、文本和图像的基础类。
		Graphics2D graphics2d = (Graphics2D) g;
		// KEY_ANTIALIASING：抗锯齿提示键，VALUE_ANTIALIAS_ON：抗锯齿提示值——使用抗锯齿模式完成呈现
		// 抗锯齿设置
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = 0, y = 0, width = 0, height = 0;// 坐标设置
		int fontSize = 0;// 字体大小设置
		if (getWidth() > getHeight()) {
			x = (getWidth() - getHeight()) / 2 + 25;
			y = 25;
			width = getHeight() - 50;
			height = getHeight() - 50;
			fontSize = getWidth() / 8;
		} else {
			x = 25;
			y = (getHeight() - getWidth()) / 2 + 25;
			width = getWidth() - 50;
			height = getWidth() - 50;
			fontSize = getHeight() / 8;
		}

		// Stroke 接口允许 Graphics2D 对象获得一个 Shape，该Shape 是指定 Shape 的装饰轮廓，或该轮廓的风格表示形式。
		// 描绘一个Shape,如同使用一支具有适当大小和形状的画笔描绘其轮廓。画笔着墨的区域是轮廓 Shape 封闭的区域。
		// BasicStroke 类定义针对图形图元轮廓呈现属性的一个基本集合，这些图元使用 Graphics2D 对象呈现，
		// 而该对象的 Stroke 属性设置为此 BasicStroke。
		graphics2d.setStroke(new BasicStroke(20.0f));
		graphics2d.setColor(backgroundColor);
		// 得到的弧由 startAngle 开始，并以当前颜色扩展 arcAngle 度。
		// 角度的 0 度位于 3点钟位置。正值指示逆时针旋转，负值则指示顺时针旋转。
		// 弧的中心是矩形的中心，此矩形的原点为 (x, y)，大小由 width 和 height 参数指定。
		graphics2d.drawArc(x, y, width, height, 0, 360);
		graphics2d.setColor(foregroundColor);
		// 正值指示逆时针旋转，负值则指示顺时针旋转
		graphics2d.drawArc(x, y, width, height, 90,
				-(int) (360 * (progress * 1.0) / (maximumProgress - minimumProgress)));
		graphics2d.setFont(new Font("黑体", Font.BOLD, fontSize));
		// FontMetrics 类定义字体规格对象，该对象封装将在特定屏幕上呈现特定字体的有关信息。
		FontMetrics fontMetrics = graphics2d.getFontMetrics();
		// 返回此 Font 中指定 String 的总 advance width。advance 是字符串基线上最左边的点到最右边的点之间的距离。
		int digitaWidth = fontMetrics.stringWidth(progressText);
		// 确定此 FontMetrics 对象所描述的 Font 的 font ascent。font ascent 是字体基线到大多数字母数字字符顶部的距离。在
		// Font 中，有些字符可能扩展超过 font ascent 线。
		int digitaAscent = fontMetrics.getAscent();
		graphics2d.setColor(foregroundColor);
		// 依照 TextAttribute 类的规范应用指定迭代器的属性，呈现指定迭代器的文本。
		graphics2d.drawString(progressText, getWidth() / 2 - digitaWidth / 2, getHeight() / 2 + digitaAscent / 2);
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		if (progress >= minimumProgress && progress <= maximumProgress) {
			this.progress = progress;
		}
		if (progress > maximumProgress) {
			this.progress = maximumProgress;
		}
		this.progressText = String.valueOf(progress + "%");
		this.repaint();// 更新构件大小
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		this.repaint();
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
		this.repaint();

	}
}
