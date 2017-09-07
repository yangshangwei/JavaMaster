package com.xgj.master.java.io.fileDemo.characterStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: PrintWriterDemo
 * 
 * @Description: PrintWriter is the implementation of Writer class.
 * 
 *               PrintWriter is used to print formatted representation to
 *               text-output-stream.
 * 
 * 
 *               PrintWriter can also be enabled for automatic flush whenever a
 *               newline character is written.
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月7日 下午2:27:13
 */
public class PrintWriterDemo {

	@Test
	public void test() {
		// Write data on console using PrintWriter
		PrintWriter pwConsole = new PrintWriter(System.out);
		pwConsole.write("Data to Write on Console using PrintWriter");
		pwConsole.flush();
		pwConsole.close();

		// Write data in file using PrintWriter
		PrintWriter pwFile = null;
		try {
			pwFile = new PrintWriter(new File("D:/text.txt"));
			pwFile.write("Data to Write in File using PrintWriter");
			pwFile.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pwFile.close();
		}
	}
}
