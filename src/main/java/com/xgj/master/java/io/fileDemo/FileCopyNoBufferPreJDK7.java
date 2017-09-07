package com.xgj.master.java.io.fileDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 
 * 
 * @ClassName: FileCopyNoBuffer
 * 
 * @Description: FileCopyNoBuffer
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月6日 下午10:53:17
 */
public class FileCopyNoBufferPreJDK7 { // Pre-JDK 7

	@Test
	public void test() {
		// 利用Spring提供的Resource/ResourceLoader接口操作资源文件
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourcePatternResolver
				.getResource("classpath:com/xgj/master/java/io/fileDemo/SQL.Cookbook.pdf");

		FileInputStream in = null;
		FileOutputStream out = null;
		long startTime, elapsedTime; // for speed benchmarking

		try {
			// Print file length
			File fileIn = resource.getFile();
			System.out.println("File size is " + fileIn.length() / 1024 / 1024 + " MB");

			in = new FileInputStream(fileIn);
			out = new FileOutputStream(new File("D:\\NoBufferPreJDK7.pdf"));

			startTime = System.nanoTime();

			int byteRead;
			// Read a raw byte, returns an int of 0 to 255.
			while ((byteRead = in.read()) != -1) {
				// Write the least-significant byte of int, drop the upper 3
				// bytes
				out.write(byteRead);
			}
			// cost time
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// JDK7之前的写法，在finally中关闭流
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
