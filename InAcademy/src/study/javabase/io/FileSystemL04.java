package study.javabase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileSystemL04 {
	public static void main(String[]args) {
		
		FileInputStream fis = null;
		byte _read[] = new byte[100];
		byte console[] = new byte[100];
		
		try {
			System.out.println("FileName: ");
			System.in.read(console);
			String file = new String(console).trim();
			fis = new FileInputStream(file);
			fis.read(_read, 0, _read.length);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if (fis!=null) fis.close();
			} catch(IOException ie) {
				ie.printStackTrace();
			}
		}
	}
}
