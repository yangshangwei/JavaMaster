package com.xgj.master.java.io.fileDemo;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: ListDirectoryWithFilter
 * 
 * @Description: List files that end with "pptx"
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月6日 下午7:50:13
 */
public class ListDirectoryWithFilter {
	/**
	 * 
	 * 
	 * @Title: listDirectoryWithFilter
	 * 
	 * @Description: 遍历某个目录下所有以pptx结尾的文件或者目录
	 * 
	 * @param dir
	 * 
	 * @return: void
	 */
	public void listDirectoryWithFilter(File dir) {
		if (dir.isDirectory()) {
			// List only files that meet the filtering criteria
			// programmed in accept() method of FilenameFilter.
			String[] files = dir.list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String file) {
					return file.endsWith("pptx");
				}
			});// an anonymous inner class as FilenameFilter

			for (String file : files) {
				System.out.println(file);
			}
		}
	}

	@Test
	public void test() {
		listDirectoryWithFilter(new File("D:\\OneDrive\\文档"));
	}

}
