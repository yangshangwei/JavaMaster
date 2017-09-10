package com.xgj.master.java.io.fileDemo.byteStreams;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: ReadWirteTextFileDemo
 * 
 * @Description: In this Demo, we show you how to read from and write to text
 *               (or character) files using classes available in the java.io
 *               package
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月8日 下午8:11:58
 */
public class ReadWirteTextFileDemo {

	@Test
	public void test() {
		try {
			FileOutputStream outputStream = new FileOutputStream("D:/MyFile.txt");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

			bufferedWriter.write("Hello");
			bufferedWriter.newLine();
			bufferedWriter.write("I/O");
			// close stream
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
