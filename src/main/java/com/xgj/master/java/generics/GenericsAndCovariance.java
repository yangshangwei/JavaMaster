package com.xgj.master.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {

	 public static void main(String[] args) {
	        // Wildcards allow covariance:
	        List<? extends Fruit> flist = new ArrayList<Apple>();
	        
	        // The method add(capture#1-of ? extends Fruit) in the type List<capture#1-of ? extends Fruit> 
	        // is not applicable for the arguments   (Apple)
	        
	        // flist.add(new Apple()); 编译报错
	        // flist.add(new Orange());编译报错
	        // flist.add(new Fruit());编译报错
	        // flist.add(new Object());编译报错
	        
	        flist.add(null); // 虽然可以添加null ,但是没有意义
	        // We Know that it returns at least Fruit:
	        Fruit f = flist.get(0);
	    }
}
