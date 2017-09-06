package com.xgj.master.java.generics;

/**
 * 

 * @ClassName: Compare

 * @Description: 内部类，泛型类

 * @author: Mr.Yang

 * @date: 2017年8月31日 下午4:01:39

 * @param <K>
 * @param <V>
 */
public class ComPare<K,V> {
	
		private K  key;
		private V value;
		/**
		 * 
		
		 * @Title:ComPare
		
		 * @Description:构造函数
		
		 * @param key
		 * @param value
		 * @return 
		 */
		public  ComPare(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
}
