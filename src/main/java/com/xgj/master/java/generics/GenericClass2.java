package com.xgj.master.java.generics;

import org.junit.Test;

public class GenericClass2 {

	@Test
	public void test() {
		Point<Integer, Integer> point = new Point<Integer, Integer>();
		point.setX(200);
		point.setY(400);

		Integer x = point.getX();
		Integer y = point.getY();

		System.out.println("This point is：" + x + ", " + y);

		Point<Double, String> point2 = new Point<Double, String>();
		point2.setX(25.4);
		point2.setY("字符串");
		double m = point2.getX();
		String n = point2.getY();
		System.out.println("This point is：" + m + ", " + n);
	}

	/**
	 * 
	 * 
	 * @ClassName: Point
	 * 
	 * @Description: 泛型类， T1 T2仅表示类型
	 * 
	 * @author: Mr.Yang
	 * 
	 * @date: 2017年8月31日 下午8:20:26
	 * 
	 * @param <T1>
	 * @param <T2>
	 */
	class Point<T1, T2> {
		T1 x;
		T2 y;

		public T1 getX() {
			return x;
		}

		public void setX(T1 x) {
			this.x = x;
		}

		public T2 getY() {
			return y;
		}

		public void setY(T2 y) {
			this.y = y;
		}

	}
}
