package com.xgj.master.java.concurrency.createThreadNormal.thread;

public class ThreadDemo extends Thread {

	private Thread t;
	private String threadName;
	
	/**
	 * 
	
	 * @Title:ThreadDemo
	
	 * @Description:构造函数，实例化一个带有ThreadName的线程
	
	 * @param threadName
	 */
	public ThreadDemo(String threadName) {
		this.threadName = threadName;
		System.out.println("Creating " + threadName);
	}

	
	/**
	 * 
	
	 * @Title: run
	
	 * @Description: 业务逻辑存在与该方法中
	
	
	 * @return: void
	 */
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread: " + threadName + ", " + i);
				// 睡眠0.5秒
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}
	
	/**
	 * 
	
	 * @Title: startThread
	
	 * @Description: 如果线程对象为空，创建并启动线程 ,通过调用thread.start()方法启动线程，该方法执行对run()方法的调用.
	
	
	 * @return: void
	 */
	public void startThread() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
