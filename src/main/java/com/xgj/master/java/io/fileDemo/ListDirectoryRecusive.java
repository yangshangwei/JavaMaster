package com.xgj.master.java.io.fileDemo;

import java.io.File;

/**
 * 
 * 
 * @ClassName: ListDirectoryRecusive
 * 
 * @Description: Recursively list the contents of a directory
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月6日 下午6:27:01
 */
public class ListDirectoryRecusive {

	public static void main(String[] args) {
		File dir = new File("D:\\OneDrive");
		listDirectoryRecusive(dir);
	}

	/**
	 * 
	 * 
	 * @Title: listDirectoryRecusive
	 * 
	 * @Description: 遍历目录下的内容(包括子孙目录)
	 * 
	 * @param dir
	 * 
	 * @return: void
	 */
	public static void listDirectoryRecusive(File dir) {
		if (dir.isDirectory()) {
			File[] items = dir.listFiles();
			for (File item : items) {
				System.out.println(item.getAbsolutePath());
				// Recursive call 如果目录下还有目录
				if (item.isDirectory()) {
					listDirectoryRecusive(item);
				}
			}
		}
	}
}
