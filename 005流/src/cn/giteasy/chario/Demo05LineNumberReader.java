package cn.giteasy.chario;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Demo05LineNumberReader {


	@Test
	public void demo1() throws IOException {
		LineNumberReader numberReader = new LineNumberReader(new FileReader(".\\最美的遇见.txt"));
		
		String line;
		numberReader.setLineNumber(100);
		while((line = numberReader.readLine()) != null) {
			System.out.println(numberReader.getLineNumber() + ":" + line);
		}
		
		numberReader.close();
	}

}