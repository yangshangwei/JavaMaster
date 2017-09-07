package com.xgj.master.java.io.fileDemo.byteStreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class FileCopyUserBufferPreJDK7 {

	@Test
	public void test() {
		// 利用Spring提供的ResourcePatternResolver操作资源文件 同时支持Ant风格的资源路径表达式
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("com/xgj/master/java/io/fileDemo/SQL.Cookbook.pdf");

		FileInputStream in = null;
		FileOutputStream out = null;

		long startTime, elapsedTime; // for speed benchmarking

		try {

			// Print file length
			File fileIn = resource.getFile();
			System.out.println("File size is " + fileIn.length() / 1024 / 1024 + " MB");

			in = new FileInputStream(fileIn);
			out = new FileOutputStream(new File("D:\\FileCopyUserBufferPreJDK7.pdf"));

			startTime = System.nanoTime();

			// 4K byte-buffer 每次读取4K
			byte[] byteBuf = new byte[4096];

			int numByteRead;
			while ((numByteRead = in.read(byteBuf)) != -1) {
				out.write(byteBuf, 0, numByteRead);
			}
			// cost time
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流 切记
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
