package com.util;

import java.awt.Color;
/**
 * 
 * @ClassName: ColorUtil.java
 * @Description: 更改颜色的功能,通过RBG变化更改颜色
 *
 * @version: v1.0.0
 * @author: 童梦君
 * @date: 2020年11月2日 下午3:40:01 
 *
 * Modification History:
 Modification History:
 * Date            Author          Version            Description
 *----------------------------------------------------------------*
 * 2020年11月2日   童梦君          v1.0.0               修改原因
 */
public class ColorUtil {
	//RGB色彩模式,通过对R(红),G（绿）,B（蓝）这三个颜色通道的变化以及他们的叠加来得到各种颜色
	public static Color blueColor = Color.decode("#3399FF");//蓝色 RGB(51,153,255)
	public static Color grayColor = Color.decode("#999999");//灰色 RGB(153,153,153)
	public static Color backgroundColor = Color.decode("#eeeeee");//背景色 RGB(238,238,238)	
	public static Color warningColor = Color.decode("#FF3333");//警告颜色cRGB(255,51,51)
	/*
	   * 圆环变换 
	 *per表示现在的消费占总消费的百分比
	 */
	public static Color getByPercentage(int per){
		if(per>100)
			per=100;
		int R=51;
		int G=255;
		int B=51;
		float rate = per/100f;//圆环的百分比
		G=(int)((255-51)*rate-51);//颜色变换
		G=255-R+51;
		Color color = new Color(R,G,B);
		return color;
	}
}

