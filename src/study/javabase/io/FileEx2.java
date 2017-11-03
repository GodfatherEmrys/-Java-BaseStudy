/**
 * @Study Information
 * @Reference: JAVA Programming Architecture.
 * @Content: File System.
 */
package study.javabase.io;

import java.io.File;

/**
 * File System in JAVA.
 * @author Emrys
 * #Directory.
 */
public class FileEx2 {

	public static void main(String[] args) {
		File directory = new File("/Users/arthur/Documents/BaseStudy/JavaBaseStudy/src/study/javabase/io");
		if(directory.exists()) {
			System.out.println(directory.getName());
			String[] fileNameList = directory.list();
			for(String fileName: fileNameList) System.out.println("│━ " + fileName);
		}
	}

}
