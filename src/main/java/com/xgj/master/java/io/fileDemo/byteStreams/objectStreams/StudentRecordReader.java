package com.xgj.master.java.io.fileDemo.byteStreams.objectStreams;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;

/**
 * 
 * 
 * @ClassName: StudentRecordReader
 * 
 * @Description: StudentRecordReader uses the ObjectInputStream class to read
 *               objects from a file on disk
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月7日 下午5:31:50
 */
public class StudentRecordReader {

	@Test
	public void readStudentFromDiskFile() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(new File("D:\\StudentRecord.txt"))))) {

			while (true) {

				Student student = (Student) ois.readObject();

				System.out.print(student.getName() + "\t");
				System.out.print(dateFormat.format(student.getBirthday()) + "\t");
				System.out.print(student.getGender() + "\t");
				System.out.print(student.getAge() + "\t");
				System.out.println(student.getGrade());
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
