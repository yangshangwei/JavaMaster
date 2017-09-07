package com.xgj.master.java.io.fileDemo.characterStreams;

import java.nio.charset.Charset;

import org.junit.Test;

public class TestCharset {

	@Test
	public void test() {
		// print the default charst
		System.out.println("The default charset is " + Charset.defaultCharset());
		System.out.println("The default charset is " + System.getProperty("file.encoding"));

		// Print the list of available Charsets in name=Charset
		System.out.println("The available charsets are:");
		System.out.println(Charset.availableCharsets());

		// Check if the given charset name is supported
		System.out.println(Charset.isSupported("UTF-8")); // true
		System.out.println(Charset.isSupported("UTF8")); // true
		System.out.println(Charset.isSupported("UTF_8")); // false

		// Get an instance of a Charset
		Charset charset = Charset.forName("UTF8");
		// Print this Charset name
		System.out.println(charset.name()); // "UTF-8"
		// Print all the other aliases
		System.out.println(charset.aliases()); // [UTF8, unicolor-1-1-utf-8]
	}

}
