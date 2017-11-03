/**
 * Study Information
 * @Reference: JAVA Programming Architecture.
 * @Content: File System.
 */

package study.javabase.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This sample class is Self Read Class by JAVA File System.
 * @author Emrys.
 *
 */
public class SelfReadFile {

	public static void main(String[]args) {
		
		File file = new File("/Users/arthur/Documents/BaseStudy/JavaBaseStudy/src/study/javabase/io/SelfReadFile.java");

		try {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file.getPath()));
			BufferedReader br = new BufferedReader(inputStreamReader);
			try {
				String str = null;
				while((str = br.readLine()) != null) {
					System.out.println(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try { if (inputStreamReader != null) inputStreamReader.close();} catch ( IOException io) { io.printStackTrace(); }
				try { if (br != null) br.close();} catch ( IOException io) { io.printStackTrace(); }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
