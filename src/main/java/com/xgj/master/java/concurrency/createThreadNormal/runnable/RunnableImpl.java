package com.xgj.master.java.concurrency.createThreadNormal.runnable;

import org.apache.log4j.Logger;

public class RunnableImpl implements Runnable {
	
	private Logger logger = Logger.getLogger(RunnableImpl.class);
	
	public Thread thread;
	private String threadName;
	// 是否挂起
	boolean suspended = false;
	/**
	 * 
	 * 
	 * @Title:RunnableImpl
	 * 
	 * @Description:构造函数
	 */
	public RunnableImpl(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(i);
				// 休眠2S
				Thread.sleep(2000);
				// 锁定线程，当挂起状态为true时,当前线程wait
				synchronized (this) {
					while(suspended){
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("thread is interrupted");
		}
		logger.info("Thread " + threadName + " is existing");
	}

	/**
	 * 
	 * 
	 * @Title: start
	 * 
	 * @Description: 包装下Thread的start方法，启动线程
	 * 
	 * 
	 * @return: void
	 */
	public void start() {
		if (thread == null) {
			logger.info("Thread 【" + threadName + "】is creating");
			thread = new Thread(this, threadName);
			thread.start();
		}

	}
	
	
	/**
	 * 
	
	 * @Title: suspend
	
	 * @Description: 设置suspended为true
	
	
	 * @return: void
	 */
	public void suspend(){
		suspended = true;
	}
	
	/**
	 * 
	
	 * @Title: resume
	
	 * @Description: synchronized关键字确保调用时，另外一个线程处于等待状态
	
	
	 * @return: void
	 */
	 synchronized  void resume() {
	      suspended = false;
	      notify();
	   }
	
	
}
