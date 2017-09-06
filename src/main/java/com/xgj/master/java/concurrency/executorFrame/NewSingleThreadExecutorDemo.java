package com.xgj.master.java.concurrency.executorFrame;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: NewSingleThreadExecutorDemo
 * 
 * @Description: newSingleThreadExecutor() returns ExecutorService with one
 *               thread pool size. ExecutorService uses single thread to execute
 *               the task. Other task will wait in queue. If thread is
 *               terminated or interrupted, a new thread will be created.
 *               ExecutorService guarantees to finish the task if not shutdown
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月3日 下午9:57:56
 */
public class NewSingleThreadExecutorDemo {

	@Test
	public void test() throws InterruptedException, ExecutionException {
		// creates thread pool with one thread
		ExecutorService newSingleThreadPool = Executors.newSingleThreadExecutor();

		// callable thread starts to execute
		Future<Integer> callableFuture = newSingleThreadPool
				.submit(new NewSingleThreadExecutorDemo().new CallableThread());

		// gets value of callable thread
		int callval = callableFuture.get();
		System.out.println("Callable:" + callval);

		// checks for thread termination
		boolean isTerminated = newSingleThreadPool.isTerminated();
		System.out.println("newSingleThreadPool  isTerminated :" + isTerminated);

		// waits for termination for 10 seconds only
		newSingleThreadPool.awaitTermination(10, TimeUnit.SECONDS);
		newSingleThreadPool.shutdownNow();
		System.out.println("newSingleThreadPool shutdownNow ");
	}

	/**
	 * 
	 * 
	 * @ClassName: CallableThread
	 * 
	 * @Description: 内部类, Callable泛型类的入参假设为Integer
	 * 
	 * @author: Mr.Yang
	 * 
	 * @date: 2017年9月3日 下午11:05:25
	 */
	class CallableThread implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int cnt = 0;
			for (; cnt < 5; cnt++) {
				Thread.sleep(5 * 1000);
				System.out.println("call:" + cnt);
			}
			return cnt;
		}

	}

}
