package com.xgj.master.java.io.fileDemo.byteStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class DataIOStream {
	public static void main(String[] args) {

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("com/xgj/master/java/io/fileDemo/data-out.txt");
		String message = "Hi,您好!";

		// Write primitives to an output file
		try (DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(resource.getFile())))) {
			out.writeByte(127);
			out.writeShort(0xFFFF); // -1
			out.writeInt(0xABCD);
			out.writeLong(0x1234_5678); // JDK 7 syntax
			out.writeFloat(11.22f);
			out.writeDouble(55.66);
			out.writeBoolean(true);
			out.writeBoolean(false);
			for (int i = 0; i < message.length(); ++i) {
				out.writeChar(message.charAt(i));
			}
			out.writeChars(message);
			out.writeBytes(message);
			out.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Read raw bytes and print in Hex
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(resource.getFile()))) {
			int inByte;
			while ((inByte = in.read()) != -1) {
				System.out.printf("%02X ", inByte); // Print Hex codes
			}
			System.out.printf("%n%n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Read primitives
		try (DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream(resource.getFile())))) {
			System.out.println("byte:    " + in.readByte());
			System.out.println("short:   " + in.readShort());
			System.out.println("int:     " + in.readInt());
			System.out.println("long:    " + in.readLong());
			System.out.println("float:   " + in.readFloat());
			System.out.println("double:  " + in.readDouble());
			System.out.println("boolean: " + in.readBoolean());
			System.out.println("boolean: " + in.readBoolean());

			System.out.print("char:    ");
			for (int i = 0; i < message.length(); ++i) {
				System.out.print(in.readChar());
			}
			System.out.println();

			System.out.print("chars:   ");
			for (int i = 0; i < message.length(); ++i) {
				System.out.print(in.readChar());
			}
			System.out.println();

			System.out.print("bytes:   ");
			for (int i = 0; i < message.length(); ++i) {
				System.out.print((char) in.readByte());
			}
			System.out.println();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
