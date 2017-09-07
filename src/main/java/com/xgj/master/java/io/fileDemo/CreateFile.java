package com.xgj.master.java.io.fileDemo;

import java.io.File;

public class CreateFile {

	public static void main(String[] args) {
		// A file relative to the current working directory
		File file1 = new File("xgj.txt");

		// A file with absolute path D:\workspace\ws-java-base\JavaMaster
		File file2 = new File("D:\\xgj.txt");

		// A file with parent and child
		File parent = new File("D:\\temp");
		File child = new File(parent, "xgj.txt");

		// A directory
		File dir = new File("D:\\temp");
	}

}
