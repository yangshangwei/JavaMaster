package com.xgj.master.java.generics;

public class GenericMethod2 {

	public static void main(String[] args) {
		// 实例化泛型类
		Point<Integer, Integer> p1 = new Point<Integer, Integer>();
		p1.setX(10);
		p1.setY(20);
		p1.printPoint(p1.getX(), p1.getY());

		Point<Double, String> p2 = new Point<Double, String>();
		p2.setX(25.4);
		p2.setY("字符串");
		p2.printPoint(p2.getX(), p2.getY());
	}
}

/**
 * 
 * 
 * @ClassName: Point
 * 
 * @Description: 定义泛型类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月31日 下午7:59:47
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

	/**
	 * 
	 * 
	 * @Title: printPoint
	 * 
	 * @Description: 定义泛型方法
	 * 
	 * @param x
	 * @param y
	 * 
	 * @return: void
	 */
	public <T1, T2> void printPoint(T1 x, T2 y) {
		T1 m = x;
		T2 n = y;
		System.out.println("This point is：" + m + ", " + n);
	}
}