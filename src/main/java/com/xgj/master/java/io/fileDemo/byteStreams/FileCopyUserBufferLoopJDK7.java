package com.xgj.master.java.io.fileDemo.byteStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class FileCopyUserBufferLoopJDK7 {

	@Test
	public void test() {

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("com/xgj/master/java/io/fileDemo/SQL.Cookbook.pdf");

		long startTime = 0, elapsedTime; // for speed benchmarking

		int[] bufSizeKB = { 1, 2, 4, 8, 16, 32, 64, 256, 1024 }; // in KB
		int bufSize; // in bytes

		for (int run = 0; run < bufSizeKB.length; ++run) {
			bufSize = bufSizeKB[run] * 1024;
			try (FileInputStream in = new FileInputStream(resource.getFile());
					FileOutputStream out = new FileOutputStream("D:\\FileCopyUserBufferLoopJDK7.pdf")) {
				startTime = System.nanoTime();
				byte[] byteBuf = new byte[bufSize];
				int numBytesRead;
				while ((numBytesRead = in.read(byteBuf)) != -1) {
					out.write(byteBuf, 0, numBytesRead);
				}
				elapsedTime = System.nanoTime() - startTime;
				System.out.printf("%4dKB: %6.2fmsec%n", bufSizeKB[run], (elapsedTime / 1000000.0));

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
