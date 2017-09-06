package com.xgj.master.java.concurrency.createThreadNormal.runnable;

import org.apache.log4j.Logger;

public class RunnableImplTest {

	private static Logger logger = Logger.getLogger(RunnableImplTest.class);

	public static void main(String[] args) {

		RunnableImpl r1 = new RunnableImpl("Runnable-Thread");
		r1.start();

		RunnableImpl r2 = new RunnableImpl("Runnable-Thread");
		r2.start();

		try {

			Thread.sleep(1000);

			// 第一个线程停止
			r1.suspend();
			logger.info("R1 is suspending");

			Thread.sleep(1000);

			r1.resume();
			logger.info("R1 is resumed");

			r2.suspend();
			logger.info("R2 is suspending");

			Thread.sleep(1000);

			r2.resume();
			logger.info("R2 is resumed");
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("Main thread Interrupted");
		}

		try {
			logger.info("Waiting for threads to finish.");
			r1.thread.join();
			r2.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("Main thread Interrupted");
		}
		logger.info("Main thread exiting.");
	}

}
