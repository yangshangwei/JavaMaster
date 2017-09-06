package com.xgj.master.java.generics;

public class GenericInterfaceDemo {
	public static void main(String arsg[]) {
		Info<String> obj = new InfoImp<String>("xiaogongjiang");
		System.out.println("Length Of String: " + obj.getVar().length());
	}
}

/**
 * 
 * 
 * @ClassName: Info
 * 
 * @Description: 定义泛型接口
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月31日 下午8:06:06
 * 
 * @param <T>
 */
interface Info<T> {
	public T getVar();
}

/**
 * 
 * 
 * @ClassName: InfoImp
 * 
 * @Description: 泛型接口实现类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月31日 下午8:06:13
 * 
 * @param <T>
 */
class InfoImp<T> implements Info<T> {

	private T var;

	/**
	 * 
	 * 
	 * @Title:InfoImp
	 * 
	 * 				定义泛型构造方法
	 * 
	 * @param var
	 */
	public InfoImp(T var) {
		this.setVar(var);
	}

	public void setVar(T var) {
		this.var = var;
	}

	public T getVar() {
		return this.var;
	}
}
