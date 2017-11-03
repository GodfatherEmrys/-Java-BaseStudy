package study.javabase.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

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
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
