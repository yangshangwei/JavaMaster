package com.xgj.master.java.io.fileDemo.characterStreams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: PrintStreamDemo
 * 
 * @Description: PrintStream is subclass of OutputStream that adds extra
 *               functionality to print different type of data.
 * 
 *               PrintStream never throws IOException.
 * 
 *               PrintStream is automatically flushed when a byte array is
 *               written.
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月7日 下午2:21:01
 */
public class PrintStreamDemo {

	@Test
	public void test() {
		// Write data on console using PrintStream
		PrintStream pConsol = new PrintStream(System.out);
		try {
			pConsol.write("Data to Write on Console using PrintStream".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// flush stream
		pConsol.flush();
		// close stream
		pConsol.close();

		// Write data in file using PrintStream
		PrintStream pFile = null;
		try {
			pFile = new PrintStream("D:\\xgj.txt");
			pFile.write("Data to Write in File using PrintStream".getBytes());
			pFile.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close stream
			if (pFile != null) {
				pFile.close();
			}
		}
	}
}
