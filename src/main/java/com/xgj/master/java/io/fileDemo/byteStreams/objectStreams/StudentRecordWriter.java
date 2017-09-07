package com.xgj.master.java.io.fileDemo.byteStreams.objectStreams;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: StudentRecordWriter
 * 
 * @Description: This class will uses the ObjectOutputStream class to write a
 *               list of Students object to a file on disk
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月7日 下午5:25:28
 */
public class StudentRecordWriter {

	@Test
	public void writeStudent2DiskFile() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		// JDK 7中的写法
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(new File("D:\\StudentRecord.txt"))))) {

			List<Student> studentList = new ArrayList<>();

			studentList.add(new Student("Xiao", dateFormat.parse("1993-02-15"), false, 23, 80.5f));

			studentList.add(new Student("Gong", dateFormat.parse("1994-10-03"), true, 22, 95.0f));

			studentList.add(new Student("Jiang", dateFormat.parse("1995-08-22"), false, 21, 79.8f));

			for (Student student : studentList) {
				oos.writeObject(student);
			}

		} catch (IOException | ParseException ex) {
			ex.printStackTrace();
		}
	}
}
