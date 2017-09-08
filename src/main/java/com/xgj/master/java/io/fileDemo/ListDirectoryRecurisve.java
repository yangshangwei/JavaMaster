package com.xgj.master.java.io.fileDemo;

import java.io.File;

public class ListDirectoryRecurisve {
	public void listDirectory(String dirPath, int level) {
		File dir = new File(dirPath);
		File[] firstLevelFiles = dir.listFiles();
		if (firstLevelFiles != null && firstLevelFiles.length > 0) {
			for (File aFile : firstLevelFiles) {
				for (int i = 0; i < level; i++) {
					System.out.print("\t");
				}
				if (aFile.isDirectory()) {
					System.out.println("[" + aFile.getName() + "]");
					listDirectory(aFile.getAbsolutePath(), level + 1);
				} else {
					System.out.println(aFile.getName());
				}
			}
		}
	}

	public static void main(String[] args) {
		ListDirectoryRecurisve test = new ListDirectoryRecurisve();
		String dirToList = System.getProperty("user.home") + File.separator + "Documents";
		test.listDirectory(dirToList, 0);
	}
}
