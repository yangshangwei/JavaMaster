package com.xgj.master.java.io.separator;

import java.io.File;

/**
 * 
 * 
 * @ClassName: SeparatorTest
 * 
 * @Description: java.io.File类维护这些依赖于系统的属性，我们可以编写可移植的程序
 * 
 *               目录分隔符： 静态字符串字段 File.separator 和 File.separatorChar [他们没有遵循从JDK
 *               1.2采用的常规Java命名约定。]如上所述，Windows使用反斜杠’\’; 而Unixes / Mac使用正斜杠’/’。
 * 
 *               路径分隔符：静态字符串字段 File.pathSeparator和 File.pathSeparatorChar。
 *               如前所述，Windows使用分号’;’ 分隔路径列表; 而Unixes / Mac使用冒号’：’。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月6日 下午5:13:41
 */
public class SeparatorTest {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);

		System.out.println(File.separator);
		System.out.println(File.separatorChar);
	}
}
