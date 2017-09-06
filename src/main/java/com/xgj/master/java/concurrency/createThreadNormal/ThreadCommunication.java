package com.xgj.master.java.concurrency.createThreadNormal;

/**
 * 
 * 
 * @ClassName: Chat
 * 
 * @Description: 对话内部类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年7月17日 下午11:54:47
 */
class Chat {

	boolean flag = false;
	/**
	 * 
	
	 * @Title: Question
	
	 * @Description: 同步方法,当其中一个线程获取Question方法时，另外一个线程等待
	 * 				 
	
	 * @param msg
	
	 * @return: void
	 */
	public synchronized void Question(String msg) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		notify();
	}

	public synchronized void Answer(String msg) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(msg);
		flag = false;
		notify();
	}

}

class T1 implements Runnable {
	Chat m;
	String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

	public T1(Chat m1) {
		this.m = m1;
		// 启动线程
		new Thread(this, "Question").start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < s1.length; i++) {
			m.Question(s1[i]);
		}
	}
}

class T2 implements Runnable {
	Chat m;
	String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

	public T2(Chat m2) {
		this.m = m2;
		// 启动线程
		new Thread(this, "Answer").start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < s2.length; i++) {
			m.Answer(s2[i]);
		}
	}
}

/**
 * 

 * @ClassName: ThreadCommunication

 * @Description:测试类

 * @author: Mr.Yang

 * @date: 2017年7月17日 下午11:57:05
 */
public class ThreadCommunication {

	public static void main(String[] args) {
		Chat m = new Chat();
		new T1(m);
		new T2(m);

	}

}
