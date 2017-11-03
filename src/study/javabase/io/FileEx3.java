/**
 * @Study Information
 * @Reference: JAVA Programming Architecture.
 * @Content: File System.
 */
package study.javabase.io;

import java.io.File;
import java.io.IOException;

/**
 * File System in JAVA.
 * @author Emrys
 * #Method of File.
 */
public class FileEx3 {

	public static void main(String[] args) {
		
		File f1 = new File("/Users/arthur/Documents/BaseStudy/JavaBaseStudy/src/study/javabase/io/README.md");
		if(f1.exists()) {
			System.out.println("File name: " + f1.getName());
		} else {
			try {
				/* Cause IOException */
				if(f1.createNewFile()) {
					System.out.println("New file created.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File f2 = new File("/Users/arthur/Documents/BaseStudy/JavaBaseStudy/src/study/javabase/ioDirectoryTest");
		if(!f2.exists()) {
			f2.mkdir();
		} else {
			System.out.println("Name of Directory: " + f2.getPath());
		}
		
		File f3 = new File("/Users/arthur/Documents/BaseStudy/JavaBaseStudy/src/study/javabase/io/README.md");
		if(f3.exists()) {
			f3.delete();
		}
		
		File src = new File("/Users/arthur/Documents/BaseStudy/JavaBaseStudy/src/study/javabase/io/newFile.md");
		File dest = new File("/Users/arthur/Documents/BaseStudy/JavaBaseStudy/src/study/javabase/io/DEST.md");
		File dest2 = new File("/Users/arthur/Documents/BaseStudy/JavaBaseStudy/src/study/javabase/io/DEST2.md");
		if(src.exists()) {
			src.renameTo(dest);
			src.renameTo(dest2);
		}
		if(f2.isDirectory()) {
			String dir[] = f2.list();
			System.out.println("\n\nDir Content:=================\n");
			for(String file : dir) System.out.println("File: " + file);
		}
		
	}

}
