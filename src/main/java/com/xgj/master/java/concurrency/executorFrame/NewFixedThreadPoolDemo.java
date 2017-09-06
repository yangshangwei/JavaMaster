package com.xgj.master.java.concurrency.executorFrame;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: NewFixedThreadPoolDemo
 * 
 * @Description: NewFixedThreadPool
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月3日 下午9:09:25
 */
public class NewFixedThreadPoolDemo {

	@Test
	public void test() {
		// 通过Executors的静态方法创建一个包含2个固定线程的线程池
		ExecutorService fixPool = Executors.newFixedThreadPool(2);

		// 第一种形式：通过Callable匿名内部类的形式 创建执行对象
		Callable<String> callable = new Callable<String>() {
			String result = "Bussiness deals successfully";

			@Override
			public String call() throws Exception {
				System.out.println("Callable is working");
				Thread.sleep(5 * 1000);
				System.out.println("Callable some bussiness logic is here ");
				return result;
			}
		};

		// 第二种形式:通过Runna匿名内部类的形式 创建执行对象
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Runnable is  working");
					Thread.sleep(5 * 1000);
					System.out.println("Runnable some bussiness logic is here ");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		// 提交两个不同形式创建的任务 （因为创建了2个固定线程的线程池，所以两个都可以提交，如果只有一个线程的话，第二个必须等待
		// 任务数量多于线程数目，那么没有没有执行的任务必须等待，直到有任务完成为止。
		// Future<> gets parameterized based on how Callable is parameterized
		// Since Runnable is not parameterized, you get a Future <?>
		Future<String> callableFuture = fixPool.submit(callable);
		Future<?> runnableFuture = fixPool.submit(runnable);

		// check if tasks are done or not
		if (callableFuture.isDone()) {
			System.out.println("\t\tCallable is done !");
		} else {
			System.out.println("\t\tCallable is not done !");
		}

		if (runnableFuture.isDone()) {
			System.out.println("\t\tRunnable is done !");
		} else {
			System.out.println("\t\tRunnable is not done !");
		}

		// callableFuture有返回值，获取返回值,runnable没有返回值
		try {
			String result = callableFuture.get();
			System.out.println("CallableFuture的返回值为:" + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		// 根据需要决定是否需要关闭线程池
		fixPool.shutdown();
		System.out.println("fixPool shutdown");
	}
}
