package com.xgj.master.java.concurrency.createThreadNormal.thread;

public class ThreadDemoTest {

	public static void main(String[] args) {
		ThreadDemo threadDemo1 = new ThreadDemo("Thread-1");
		threadDemo1.start();
		
		ThreadDemo threadDemo2 = new ThreadDemo("Thread-2");
		threadDemo2.start();

	}

}
