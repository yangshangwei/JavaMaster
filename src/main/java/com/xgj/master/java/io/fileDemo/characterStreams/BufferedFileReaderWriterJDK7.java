package com.xgj.master.java.io.fileDemo.characterStreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: BufferedFileReaderWriterJDK7
 * 
 * @Description: Demo of BufferedFileReader and BufferedWriter in JDK7.
 * 
 *               Write a text message to an output file, then read it back.
 * 
 *               NOTE: FileReader/FileWriter uses the default charset for file
 *               encoding .
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月7日 上午11:36:56
 */
public class BufferedFileReaderWriterJDK7 {

	@Test
	public void test() {

		String fileName = "D:\\xgj2.txt";
		// 2 lines of texts
		String message = "Character Streams!\nCharacter Stream Operation!\n";

		// Print the default charset
		System.out.println(Charset.defaultCharset());
		System.out.println(System.getProperty("file.encoding"));

		// JDK7中的写法
		// write content to file
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)))) {
			bw.write(message);
			bw.flush();// flush
		} catch (IOException e) {
			e.printStackTrace();
		}

		// read content from file
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			String inLine;
			// BufferedReader provides a new method readLine(), which reads a
			// line and returns a String , if null means end of charcterStreams
			while ((inLine = br.readLine()) != null) {
				System.out.println(inLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
