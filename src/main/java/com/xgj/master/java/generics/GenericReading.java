package com.xgj.master.java.generics;

import java.util.Arrays;
import java.util.List;

public class GenericReading {

	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Orange> oranges = Arrays.asList(new Orange());

	static class CovariantReader<T> {
	    T readCovariant(List<? extends T> list) {
	        return list.get(0);
	    }
	}
	static void f2() {
	    CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
	    Fruit f = fruitReader.readCovariant(oranges);
	    Fruit a = fruitReader.readCovariant(apples);
	}
	public static void main(String[] args) {
	    f2();
	}
}
