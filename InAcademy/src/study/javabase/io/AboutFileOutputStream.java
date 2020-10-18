/**
 * @Study Information
 * @Reference: JAVA Programming Architecture.
 * @Content: File System.
 */
package study.javabase.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream & write
 * @author Emrys
 * 
 */
public class AboutFileOutputStream {

	public static void main(String args[]) {
		
		FileOutputStream fos = null;
		String filepath = new String("src/README.md");
		
		try {
			fos = new FileOutputStream(filepath);
			String message = "Hello, World!";
			fos.write(message.getBytes());
			fos.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if(fos != null) fos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
