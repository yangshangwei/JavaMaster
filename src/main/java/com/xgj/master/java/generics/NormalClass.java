package com.xgj.master.java.generics;

import org.junit.Test;

public class NormalClass {

	@Test
	public void test(){

		Point point = new Point();
		point.setX(100); // int -> Integer -> Object
		point.setY(20);

		int x = (Integer) point.getX(); // 必须向下转型
		int y = (Integer) point.getY();

		System.out.println("This point is：" + x + ", " + y);

		point.setX(25.4); // double -> Integer -> Object
		point.setY("字符串");
		
		 // 必须向下转型
		double m = (Double) point.getX();
		
		// 运行期间抛出异常  java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Double
		double n = (Double) point.getY(); 
		
		System.out.println("This point is：" + m + ", " + n);
	}
	
	/**
	 * 
	
	 * @ClassName: Point
	
	 * @Description: 一般内部类
	
	 * @author: Mr.Yang
	
	 * @date: 2017年8月31日 下午8:23:31
	 */
	 class Point {
		Object x = 0;
		Object y = 0;

		public Object getX() {
			return x;
		}

		public void setX(Object x) {
			this.x = x;
		}

		public Object getY() {
			return y;
		}

		public void setY(Object y) {
			this.y = y;
		}

	}
}
