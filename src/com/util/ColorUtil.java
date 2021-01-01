package com.util;

import java.awt.Color;
/**
 * 
 * @ClassName: ColorUtil.java
 * @Description: ������ɫ�Ĺ���,ͨ��RBG�仯������ɫ
 *
 * @version: v1.0.0
 * @author: ͯ�ξ�
 * @date: 2020��11��2�� ����3:40:01 
 *
 * Modification History:
 Modification History:
 * Date            Author          Version            Description
 *----------------------------------------------------------------*
 * 2020��11��2��   ͯ�ξ�          v1.0.0               �޸�ԭ��
 */
public class ColorUtil {
	//RGBɫ��ģʽ,ͨ����R(��),G���̣�,B��������������ɫͨ���ı仯�Լ����ǵĵ������õ�������ɫ
	public static Color blueColor = Color.decode("#3399FF");//��ɫ RGB(51,153,255)
	public static Color grayColor = Color.decode("#999999");//��ɫ RGB(153,153,153)
	public static Color backgroundColor = Color.decode("#eeeeee");//����ɫ RGB(238,238,238)	
	public static Color warningColor = Color.decode("#FF3333");//������ɫcRGB(255,51,51)
	/*
	   * Բ���任 
	 *per��ʾ���ڵ�����ռ�����ѵİٷֱ�
	 */
	public static Color getByPercentage(int per){
		if(per>100)
			per=100;
		int R=51;
		int G=255;
		int B=51;
		float rate = per/100f;//Բ���İٷֱ�
		G=(int)((255-51)*rate-51);//��ɫ�任
		G=255-R+51;
		Color color = new Color(R,G,B);
		return color;
	}
}

