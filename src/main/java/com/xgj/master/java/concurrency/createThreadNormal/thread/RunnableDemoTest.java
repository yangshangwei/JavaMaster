package com.xgj.master.java.concurrency.createThreadNormal.thread;

public class RunnableDemoTest {

	public static void main(String[] args) {
		
		RunnableDemo thread1 = new RunnableDemo("thread-1");
		thread1.startThread();
		
		
		RunnableDemo thread2 = new RunnableDemo("thread-2");
		thread2.startThread();
		
	
	}

}
