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
 * @ClassName: FileCopyNoBufferJDK7
 * 
 * @Description: FileCopyNoBufferJDK7
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月6日 下午11:02:50
 */
public class FileCopyNoBufferJDK7 {

	@Test
	public void test() {
		// 利用Spring提供的ResourcePatternResolver操作资源文件 同时支持Ant风格的资源路径表达式
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourcePatternResolver.getResource("classpath:com/xgj/master/java/io/fileDemo/281015.jpg");

		System.out.println(resource.getFilename());

		long startTime, elapsedTime; // for speed benchmarking

		// DK 1.7引入了一种新的try-with-resources语法，
		// 它会在try或catch之后自动关闭所有打开的资源，如下所示。
		// 这样的代码看起来更加的优雅。
		try (FileInputStream in = new FileInputStream(resource.getFile());
				FileOutputStream out = new FileOutputStream(new File("D:\\test.jpg"))) {
			// Print file length
			File fileIn = resource.getFile();
			System.out.println("File size is " + fileIn.length() + " bytes");

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
		}

	}
}
