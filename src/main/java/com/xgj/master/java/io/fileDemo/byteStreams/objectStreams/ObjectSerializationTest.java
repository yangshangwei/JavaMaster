package com.xgj.master.java.io.fileDemo.byteStreams.objectStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerializationTest {
	public static void main(String[] args) {
		String filename = "object.ser";
		int numObjs = 5;

		// Write objects
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(filename)))) {

			// Create an array of 10 MySerializedObjects with ascending numbers
			MySerializedObject[] objs = new MySerializedObject[numObjs];
			for (int i = 0; i < numObjs; ++i) {
				objs[i] = new MySerializedObject(0xAA + i); // Starting at AA
			}
			// Write the objects to file, one by one.
			for (int i = 0; i < numObjs; ++i) {
				out.writeObject(objs[i]);
			}
			// Write the entire array in one go.
			out.writeObject(objs);
			out.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Read raws bytes and print in Hex
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename))) {
			int inByte;
			while ((inByte = in.read()) != -1) {
				System.out.printf("%02X ", inByte); // Print Hex codes
			}
			System.out.printf("%n%n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Read objects
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
			// Read back the objects, cast back to its original type.
			MySerializedObject objIn;
			for (int i = 0; i < numObjs; ++i) {
				objIn = (MySerializedObject) in.readObject();
				System.out.println(objIn.getNumber());
			}
			MySerializedObject[] objArrayIn;
			objArrayIn = (MySerializedObject[]) in.readObject();
			for (MySerializedObject o : objArrayIn) {
				System.out.println(o.getNumber());
			}
		} catch (ClassNotFoundException | IOException ex) { // JDK 7
			ex.printStackTrace();
		}
	}
}

class MySerializedObject implements Serializable {
	private int number;

	public MySerializedObject(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
