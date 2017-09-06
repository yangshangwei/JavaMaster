package com.xgj.master.java.concurrency.executorFrame;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 
 * @ClassName: NewSingleThreadScheduleExectorDemo
 * 
 * @Description: scheduleSingleThreadPool
 *               http://www.codejava.net/java-core/concurrency/java-concurrency-
 *               scheduling-tasks-to-execute-after-a-given-delay-or-periodically
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月3日 下午11:48:47
 */
public class NewSingleThreadScheduleExectorDemo {

	private static String threadNamePrefix = "XiaoGongJiang";

	public static void main(String[] args) {
		// Get the scheduler
		ScheduledExecutorService scheduleSingleThreadPool = Executors
				.newSingleThreadScheduledExecutor(new ThreadFactory() {
					public Thread newThread(Runnable r) {
						return new Thread(r, "Thread-" + threadNamePrefix);
					}
				});

		// Create an anonymous instance of Runnable
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Begin");
					for (int i = 0; i < 3; i++) {
						System.out.println("\tRunnable is doing something");
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		};

		// Get a handle, starting now, with a 2 seconds delay,
		// and run at fixed rate (5 seconds)
		scheduleSingleThreadPool.scheduleAtFixedRate(runnable, 2, 5, TimeUnit.SECONDS);

	}
}
