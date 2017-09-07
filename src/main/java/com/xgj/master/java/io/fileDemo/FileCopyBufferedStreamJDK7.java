package com.xgj.master.java.io.fileDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class FileCopyBufferedStreamJDK7 {

	@Test
	public void test() {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("com/xgj/master/java/io/fileDemo/SQL.Cookbook.pdf");

		long startTime = 0, elapsedTime; // for speed benchmarking

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resource.getFile()));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\xgj_2.pdf")))) {

			// Check file length
			File fileIn = resource.getFile();
			System.out.println("File size is " + fileIn.length() + " bytes");

			startTime = System.nanoTime();
			int byteRead;
			while ((byteRead = bis.read()) != -1) {
				bos.write(byteRead);
			}
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
