package com.xgj.master.java.io.fileDemo.characterStreams;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.junit.Test;

public class TestCharsetEncodeDecode {

	@Test
	public void test() {
		// Try these charsets for encoding
		String[] charsetNames = { "US-ASCII", "ISO-8859-1", "UTF-8", "UTF-16", "UTF-16BE", "UTF-16LE", "GBK", "BIG5" };

		String message = "Hi,您好!"; // Unicode message to be encoded
		// Print UCS-2 in hex codes
		System.out.printf("%10s: ", "UCS-2");
		for (int i = 0; i < message.length(); ++i) {
			System.out.printf("%04X ", (int) message.charAt(i));
		}
		System.out.println();

		for (String charsetName : charsetNames) {
			// Get a Charset instance given the charset name string
			Charset charset = Charset.forName(charsetName);
			System.out.printf("%10s: ", charset.name());

			// Encode the Unicode UCS-2 characters into a byte sequence in this
			// charset.
			ByteBuffer bb = charset.encode(message);
			while (bb.hasRemaining()) {
				System.out.printf("%02X ", bb.get()); // Print hex code
			}
			System.out.println();
			bb.rewind();
		}
	}
}
