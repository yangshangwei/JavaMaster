package com.xgj.master.java.generics;


public class CountGreater {
	
	public static <T extends Comparable<T>>  int  countGreaterThan(T[] array, T element){
		int count = 0 ;
		// 遍历数组
		for (T t : array) {
			if (t.comparable(element) > 0) { 
				++count;
			}
		}
		return count;
	}
	
}
