package com.xgj.master.java.generics;


/**
 * 

 * @ClassName: GenericClass

 * @Description: 泛型类

 * @author: Mr.Yang

 * @date: 2017年8月31日 下午3:35:38

 * @param <T>
 */
public class GenericClass<T> {
	
	// T stands for "Type"
	private T  t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		
		GenericClass<String> string = new GenericClass<String>();
		GenericClass<User> user = new GenericClass<User>();
		
		
	}
	
}
