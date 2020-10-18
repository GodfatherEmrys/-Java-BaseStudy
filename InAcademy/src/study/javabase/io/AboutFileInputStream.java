/**
 * @Study Information
 * @Reference: JAVA Programming Architecture.
 * @Content: File System.
 */
package study.javabase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream & byte[] _read.
 * @author Emrys
 * 
 */
public class AboutFileInputStream {
	
	public static void main(String[]args) {
		
		FileInputStream fis = null;
		byte _read[] = new byte[1024];
		byte console[] = new byte[1024];
		
		try {
			System.out.print("File name: ");
			System.in.read(console);
			String file = new String(console).trim();
			fis = new FileInputStream(file);
			/* In this case, file path means just project folder. so If you want to test this code.
			 * you have to input the right path
			 * like "src/README.md" or src/study/javabase/io/AboutFileInputStream.java */
			fis.read(_read, 0, _read.length);
			System.out.println(new String(_read).trim());
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
