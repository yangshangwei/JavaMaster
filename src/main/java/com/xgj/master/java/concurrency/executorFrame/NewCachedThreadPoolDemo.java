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
 * @ClassName: NewCachedThreadPoolDemo
 * 
 * @Description: 1.The pool creates new threads if needed but reuses previously
 *               constructed threads if they are available.
 * 
 *               2.Cached thread pool helps improve the performance of
 *               applications that make many short-lived asynchronous tasks.
 * 
 *               3.Only if no threads are available for reuse will a new thread
 *               be created and added to the pool.
 * 
 *               4.Threads that have not been used for more than sixty seconds
 *               are terminated and removed from the cache. Hence a pool which
 *               has not been used long enough will not consume any resources.
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月3日 下午11:15:05
 */
public class NewCachedThreadPoolDemo {

	@Test
	public void test() {
		// Obtain a cached thread pool
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

		// Create an anonymous Callable<T> object.Override call()
		Callable<String> callable = new Callable<String>() {
			String message = "Callable is done !";

			@Override
			public String call() throws Exception {
				for (int i = 0; i < 10; i++) {
					System.out.println("Callable is doing something");
					Thread.sleep(500); // make it sleep a little
				}
				return message;
			}
		};

		// Create an anonymous instance of Runnable
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						System.out.println("\tRunnable is doing something");
						Thread.sleep(1000);
					}
				} catch (Exception e) {
				}
			}
		};

		// Time to run these
		// Future<> gets parameterized based on how Callable is parameterized
		// Since Runnable is not parameterized, you get a Future <?>
		Future<String> callableFuture = cachedThreadPool.submit(callable);
		Future<?> runnableFuture = cachedThreadPool.submit(runnable);

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

		try {
			// get() waits for the task to finish and then gets the result
			String returnedValue = callableFuture.get();
			System.out.println(returnedValue);
		} catch (InterruptedException e) {
			// thrown if task was interrupted before completion
			e.printStackTrace();
		} catch (ExecutionException e) {
			// thrown if the task threw an execption while executing
			e.printStackTrace();
		}

		// shutdown the pool if needed.
		cachedThreadPool.shutdown();
	}

}
