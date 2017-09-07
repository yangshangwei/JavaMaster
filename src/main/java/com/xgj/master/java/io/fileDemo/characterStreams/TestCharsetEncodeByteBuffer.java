package com.xgj.master.java.io.fileDemo.characterStreams;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.junit.Test;

public class TestCharsetEncodeByteBuffer {

	@Test
	public void test() {
		// "Hi,您好!"
		byte[] bytes = { 0x00, 0x48, 0x00, 0x69, 0x00, 0x2C, 0x60, (byte) 0xA8, 0x59, 0x7D, 0x00, 0x21 };
		// Print UCS-2 in hex codes
		System.out.printf("%10s: ", "UCS-2");

		for (int i = 0; i < bytes.length; ++i) {
			System.out.printf("%02X ", bytes[i]);
		}
		System.out.println();

		Charset charset = Charset.forName("UTF-8");
		// Encode from UCS-2 to UTF-8
		// Create a ByteBuffer by wrapping a byte array
		ByteBuffer bb = ByteBuffer.wrap(bytes);
		// Create a CharBuffer from a view of this ByteBuffer
		CharBuffer cb = bb.asCharBuffer();
		ByteBuffer bbOut = charset.encode(cb);
		// Print hex code
		System.out.printf("%10s: ", charset.name());
		while (bbOut.hasRemaining()) {
			System.out.printf("%02X ", bbOut.get());
		}
		System.out.println();

		// Decode from UTF-8 to UCS-2
		bbOut.rewind();
		CharBuffer cbOut = charset.decode(bbOut);
		System.out.printf("%10s: ", "UCS-2");
		while (cbOut.hasRemaining()) {
			char aChar = cbOut.get();
			// Print char & hex code
			System.out.printf("'%c'[%04X] ", aChar, (int) aChar);
		}
		System.out.println();
	}
}
