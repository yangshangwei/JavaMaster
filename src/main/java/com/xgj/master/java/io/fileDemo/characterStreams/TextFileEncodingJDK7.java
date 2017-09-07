package com.xgj.master.java.io.fileDemo.characterStreams;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: TextFileEncodingJDK7
 * 
 * @Description: Write texts to file using OutputStreamWriter specifying its
 *               charset encoding.
 * 
 *               Read byte-by-byte using FileInputStream.
 * 
 *               Read char-by-char using InputStreamReader specifying its
 *               charset encoding.
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月7日 下午1:35:15
 */
public class TextFileEncodingJDK7 {
	@Test
	public void test() {
		String message = "Hi,您好!"; // with non-ASCII chars
		// Java internally stores char in UCS-2/UTF-16
		// Print the characters stored with Hex codes
		for (int i = 0; i < message.length(); ++i) {
			char aChar = message.charAt(i);
			System.out.printf("[%d]'%c'(%04X) ", (i + 1), aChar, (int) aChar);
		}
		System.out.println();

		// Try these charsets for encoding text file
		String[] csStrs = { "UTF-8", "UTF-16BE", "UTF-16LE", "UTF-16", "GB2312", "GBK", "BIG5" };
		String outFileExt = "-out.txt"; // Output filenames are
										// "charset-out.txt"

		// Write text file in the specified file encoding charset
		for (int i = 0; i < csStrs.length; ++i) {
			// Buffered for efficiency
			try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(csStrs[i] + outFileExt),
					csStrs[i]); BufferedWriter bufOut = new BufferedWriter(out)) {

				// Print file encoding charset // efficiency
				System.out.println(out.getEncoding());

				bufOut.write(message);
				bufOut.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		// Read raw bytes from various encoded files
		// to check how the characters were encoded.
		for (int i = 0; i < csStrs.length; ++i) {
			// Buffered for efficiency
			try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(csStrs[i] + outFileExt))) {
				// Print file encoding charset
				System.out.printf("%10s", csStrs[i]);
				int inByte;
				while ((inByte = in.read()) != -1) {
					// Print Hex codes
					System.out.printf("%02X ", inByte);
				}
				System.out.println();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		// Read text file with character-stream specifying its encoding.
		// The char will be translated from its file encoding charset to
		// Java internal UCS-2.
		for (int i = 0; i < csStrs.length; ++i) {
			// Buffered for efficiency
			try (InputStreamReader in = new InputStreamReader(new FileInputStream(csStrs[i] + outFileExt), csStrs[i]);
					BufferedReader bufIn = new BufferedReader(in)) {
				// print file encoding charset
				System.out.println(in.getEncoding());
				int inChar;
				int count = 0;
				while ((inChar = in.read()) != -1) {
					++count;
					System.out.printf("[%d]'%c'(%04X) ", count, (char) inChar, inChar);
				}
				System.out.println();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
