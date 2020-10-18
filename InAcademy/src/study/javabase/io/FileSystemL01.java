/**
 * @Study Information
 * @Content: File System.
 */
package study.javabase.io;

import java.io.File;

/**
 * File System in JAVA.
 * @author Emrys
 * #Method of File Class.
 */
public class FileSystemL01 {

	public static void main(String[]args) {
		File file = new File("/Users/arthur/Documents/BaseStudy/JavaBaseStudy/src/study/javabase/io/FileEx1.java");
		System.out.println("Is it file? " + file.isFile());
		System.out.println("Is it Directory? " + file.isDirectory());
		System.out.println("Relative path: " + file.getPath());
		System.out.println("Absolute path: " + file.getAbsolutePath());
		System.out.println("The name of Directory or File: " + file.getName());
		System.out.println("Length of file: " + file.length());
		System.out.println("Last Modified: " + file.lastModified());
	}
}
