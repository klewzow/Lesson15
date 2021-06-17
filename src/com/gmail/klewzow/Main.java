package com.gmail.klewzow;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File a = new File("A/");
		File b = new File("B/ ");
		FileFilter cf = new SearchAndCopyFile(a, b);
		cf.copyFile("doc");
	}
}
