package com.xgj.master.java.io.fileDemo.byteStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class FileCopyBufferedStreamPreJDK7 {

	@Test
	public void test() {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("com/xgj/master/java/io/fileDemo/SQL.Cookbook.pdf");

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		long startTime = 0, elapsedTime; // for speed benchmarking

		try {
			bis = new BufferedInputStream(new FileInputStream(resource.getFile()));
			bos = new BufferedOutputStream(new FileOutputStream("D:\\artisan.pdf"));

			startTime = System.nanoTime();

			int byteRead;
			// Read byte-by-byte from buffer
			while ((byteRead = bis.read()) != -1) {
				bos.write(byteRead);
			}
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // always close the streams
			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
