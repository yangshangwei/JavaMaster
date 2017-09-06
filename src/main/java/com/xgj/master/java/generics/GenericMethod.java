package com.xgj.master.java.generics;


/**
 * 

 * @ClassName: GenericMethod

 * @Description: 泛型方法演示

 * @author: Mr.Yang

 * @date: 2017年8月31日 下午3:54:23
 */
public class GenericMethod {
	/**
	 * 
	
	 * @Title: cofer
	
	 * @Description: 泛型方法
	
	 * @param c1
	 * @param c2
	 * @return
	
	 * @return: boolean
	 */
	public static <K,V> boolean cofer(ComPare<K,V> c1, ComPare<K,V> c2){
		return c1.getKey().equals(c2.getKey()) && c1.getValue().equals(c2.getValue());
	}
	
	// 泛型方法的调用
	public static void main(String[] args) {
		
		ComPare<Integer,String> c1 = new ComPare<>(1, "dog");
		
		ComPare<Integer, String> c2 = new ComPare<>(2, "cat");
		
		boolean different = GenericMethod.<Integer,String>cofer(c1, c2);
		
		System.out.println("c1 compares c2,and the result is  " + different);
		
		
	    // 在Java1.7/1.8可以利用type inference，让Java自动推导出相应的类型参数
		boolean different2 = GenericMethod.cofer(c1, c2);
		
		System.out.println("自动推导 c1 compares c2,and the result is  " + different2);
	}
}
