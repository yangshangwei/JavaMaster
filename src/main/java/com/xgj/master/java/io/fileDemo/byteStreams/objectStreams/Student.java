package com.xgj.master.java.io.fileDemo.byteStreams.objectStreams;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @ClassName: Student
 * 
 * @Description: this class implements the Serializable interface and has 5
 *               member variables of various data types.
 * 
 *               We will write two programs for writing and reading objects of
 *               this class using the ObjectInputStream and ObjectOutputStream
 *               classes.
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月7日 下午5:23:36
 */
public class Student implements Serializable {
	private String name;
	private Date birthday;
	private boolean gender; // true is male, false is female
	private int age;
	private float grade;

	public Student() {
	}

	public Student(String name, Date birthday, boolean gender, int age, float grade) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getGrade() {
		return this.grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
}
