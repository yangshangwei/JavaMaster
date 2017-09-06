package com.xgj.master.java.concurrency.createThreadNormal.thread;

public class RunnableDemo implements Runnable {
	
	private String threadName;
	private Thread thread;
	
	/**
	 * 
	
	 * @Title:CreateThreadByRunnable
	
	 * @Description:构造函数
	
	 * @param threadName
	 */
	public RunnableDemo(String threadName) {
		this.threadName = threadName;
		System.out.println("Create thread:" + threadName);
	}
	
	

	/**
	 * 
	
	 * @Title: run
	
	 * @Description: 重写Runnable接口中的run方法,业务逻辑存在与该方法中
	
	
	 * @return: void
	 */
	@Override
	public void run() {
		System.out.println("Running " +  threadName );
		try {
			for (int i = 0 ; i < 5 ; i++) {
				System.out.println("ThreadName:" +  threadName + " : " + i);
				// 睡眠0.5秒
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Thread " +  threadName + " interrupted.");
		} 
		System.out.println("Thread " +  threadName + " exiting.");
	}
	
	/**
	 * 
	
	 * @Title: startThread
	
	 * @Description: 如果线程对象为空，创建并启动线程 ,通过调用thread.start()方法启动线程，该方法执行对run()方法的调用.
	
	
	 * @return: void
	 */
	public void startThread(){
		if( thread == null){
			thread = new Thread(this, threadName);
			thread.start();
		}
	}
	
	
}
