package com.xgj.master.java.io.fileDemo.characterStreams.externalizableDemo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class User implements Externalizable {
	public static final long serialVersionUID = 1234L;

	// attributes
	private int code;
	private String name;
	private String password;
	private Date birthday;
	private int socialSecurityNumber;

	public User() {
	}

	// methods (getters and setters)
	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setSocialSecurityNumber(int ssn) {
		this.socialSecurityNumber = ssn;
	}

	public int getSocialSecurityNumber() {
		return this.socialSecurityNumber;
	}

	public String toString() {
		String details = "Code: " + code;
		details += "\nName: " + name;
		details += "\nBirthday: " + birthday;
		details += "\nPassword: " + password;
		details += "\nsocialSecurityNumber: " + socialSecurityNumber;

		return details;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// implement your own code to write objects of this class
		out.writeInt(code);
		out.writeObject(name);
		// write empty password:
		out.writeObject("");
		out.writeObject(birthday);

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// implement your own code to read serialized objects of this class
		this.code = in.readInt();
		this.name = (String) in.readObject();
		this.password = (String) in.readObject();
		this.birthday = (Date) in.readObject();

	}
}
