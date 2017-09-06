package com.xgj.master.java.concurrency.executorFrame;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 
 * @ClassName: NewScheduledThreadPoolDemo
 * 
 * @Description:三个常用方法 1.schedule(): This allows you to schedule a Callable or a
 *                     Runnable for one-shot execution after a specified delay.
 * 
 *                     2.scheduleAtFixedRate(): This lets you schedule tasks
 *                     that will first execute after a specified delay and then
 *                     will execute again based on the period you specified. If
 *                     you set the initial delay for five seconds and then
 *                     subsequent period to five seconds then your task will
 *                     first execute five seconds after the first submission and
 *                     then will execute periodically every five seconds.
 * 
 *                     3.scheduleWithFixedDelay(): This lets you create tasks
 *                     that will first be executed after the initial delay then
 *                     subsequently with given delay between the termination of
 *                     one execution and commencement of another execution. So
 *                     if you create a task with initial delay of five seconds
 *                     and the subsequent delay of five seconds, the task will
 *                     be executed five seconds after the submission. Once the
 *                     task finishes execution, the scheduler will wait for five
 *                     seconds and then execute the task again.
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月4日 上午12:24:31
 */
public class NewScheduledThreadPoolDemo {

	final static DateFormat fmt = DateFormat.getTimeInstance(DateFormat.LONG);

	public static void main(String[] args) {
		// Create a scheduled thread pool with 5 core threads
		ScheduledThreadPoolExecutor sch = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5);

		// Create a task for one-shot execution using schedule()
		Runnable oneShotTask = new Runnable() {
			@Override
			public void run() {
				System.out.println("\t oneShotTask Execution Time: " + fmt.format(new Date()));
			}
		};

		// Create another task
		Runnable delayTask = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("\t delayTask Execution Time: " + fmt.format(new Date()));
					Thread.sleep(10 * 1000);
					System.out.println("\t delayTask End Time: " + fmt.format(new Date()));
				} catch (Exception e) {

				}
			}
		};

		// And yet another
		Runnable periodicTask = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("\t periodicTask Execution Time: " + fmt.format(new Date()));
					Thread.sleep(10 * 1000);
					System.out.println("\t periodicTask End Time: " + fmt.format(new Date()));
				} catch (Exception e) {

				}
			}
		};

		System.out.println("Submission Time: " + fmt.format(new Date()));
		// ScheduledFuture<?> oneShotFuture = sch.schedule(oneShotTask, 5,
		// TimeUnit.SECONDS);
		// ScheduledFuture<?> delayFuture =
		// sch.scheduleWithFixedDelay(delayTask, 5, 5, TimeUnit.SECONDS);
		ScheduledFuture<?> periodicFuture = sch.scheduleAtFixedRate(periodicTask, 5, 5, TimeUnit.SECONDS);
	}
}
