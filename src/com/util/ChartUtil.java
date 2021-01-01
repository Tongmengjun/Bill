package com.util;

import java.awt.*;
import javax.swing.*;

import java.util.List;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import com.entity.Record;

import com.service.ReportService;

/**
 * 
 * @ClassName: ChartUtil.java
 * @Description: 月消费报表柱状图
 *
 * @version: v1.0.0
 * @author: 童梦君
 * @date: 2020年11月3日 下午3:51:57
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020年11月3日 童梦君 v1.0.0 修改原因
 */
public class ChartUtil {
	// 显示柱状图下面的多少号
	private static String[] sampleLabels(List<Record> rs) {
		String[] sampleLables = new String[rs.size()];
		for (int i = 0; i < sampleLables.length; i++) {
			if (0 == i % 5) {
				sampleLables[i] = String.valueOf(i + 1 + "日");// 每隔5天显示日期
			}
		}
		return sampleLables;
	}

	// 显示消费数据
	private static double[] sampleValues(List<Record> rs) {
		double[] result = new double[rs.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = rs.get(i).spend;
		}
		return result;
	}

	// 样本中的最大值
	public static int max(double[] sampleValues) {
		int max = 0;
		for (double v : sampleValues) {
			if (v > max)
				max = (int) v;
		}
		return max;
	}
	
	public static Image getImage(List<Record> rs, int width, int height) {
		// 根据消费记录的到消费样本数
		double[] sampleValues = sampleValues(rs);
		// 根据消费日期得到图表下面的日期
		String[] sampleLabels = sampleLabels(rs);
		// 样本中的最大值
		int max = max(sampleValues);
		// 数据颜色
		Color[] sampleColors = new Color[] { ColorUtil.blueColor };
		// 柱状图
		BarChart chart = new BarChart();
		// 设置样本数量
		chart.setSampleCount(sampleValues.length);
		// 设置样本数据
		chart.setSampleValues(0, sampleValues);
		// 设置样本文字
		chart.setSampleLabels(sampleLabels);
		// 设置样本颜色
		chart.setSampleColors(sampleColors);
		// 设置取值范围(柱状图的上限范围)
		chart.setRange(0, max * 1.2);
		// 显示背景横线
		chart.setValueLinesOn(true);
		// 显示文字
		chart.setSampleLabelsOn(true);
		// 把文字显示在下方
		chart.setSampleLabelStyle(Chart.BELOW);
		// 样本值的文字
		chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
		// 显示图例说明
		chart.setLegendOn(true);
		// 放在图左边
		chart.setLegendPosition(Chart.LEFT);
		// 图例说明中的文字
		chart.setLegendLabels(new String[] { "月消费报表" });
		// 图例说明中的字体
		chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
		// 下方文字的字体
		chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
		// 图表中间背景
		chart.setChartBackground(Color.white);
		// 图标整体背景
		chart.setBackground(ColorUtil.backgroundColor);
		// 把图表转化为Image类型
		Image im = chart.getImage(width, height);
		return im;
	}

	/*
	 * 设置默认数据 private static double [] sampleValues() { double [] result = new
	 * double[30]; for(int i = 0 ;i<result.length;i++) {
	 * result[i]=(int)(Math.random()*300); } return result; } //设置默认的图标下方文字 private
	 * static String [] sampleLables() { String [] sampleLables=new String[30];
	 * for(int i = 0;i<sampleLables.length;i++) { if(i%5==0) {
	 * sampleLables[i]=String.valueOf(i+1+"日"); } } return sampleLables; }
	 * 
	 * //设置默认图表 private static Image getImage(int width,int height){ //模拟样本数据 double
	 * [] sampleValues = sampleValues(); //下方显示的文字 String [] sampleLables =
	 * sampleLables(); //样本中的最大值 int max = max(sampleValues); //数据颜色 Color[]
	 * sampleColors = new Color[] {ColorUtil.blueColor}; //柱状图 BarChart chart = new
	 * BarChart(); //设置样本数量 chart.setSampleCount(sampleValues.length); //设置样本数据
	 * chart.setSampleValues(0, sampleValues); //设置样本文字
	 * chart.setSampleLabels(sampleLables); //设置样本颜色
	 * chart.setSampleColors(sampleColors); //设置取值范围(柱状图的上限范围) chart.setRange(0,
	 * max*1.2); //显示背景横线 chart.setValueLinesOn(true); //显示文字
	 * chart.setSampleLabelsOn(true); //把文字显示在下方
	 * chart.setSampleLabelStyle(Chart.BELOW); //样本值的文字
	 * chart.setFont("rangLabelFont",new Font("Arial",Font.BOLD,12)); //显示图例说明
	 * chart.setLegendOn(true); //放在图左边 chart.setLegendPosition(Chart.LEFT);
	 * //图例说明中的文字 chart.setLegendLabels(new String [] {"月消费报表"}); //图例说明中的字体
	 * chart.setFont("legentFont",new Font("Dialog",Font.BOLD,13)); //下方文字的字体
	 * chart.setFont("sampleLabelFont",new Font("Dialog",Font.BOLD,13)); //图表中间背景
	 * chart.setChartBackground(Color.white); //图标整体背景
	 * chart.setBackground(ColorUtil.backgroundColor); //把图表转化为Image类型 Image
	 * im=chart.getImage(width,height); return im; }
	 */
}
