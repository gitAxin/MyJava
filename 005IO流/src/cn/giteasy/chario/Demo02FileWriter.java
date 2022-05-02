package cn.giteasy.chario;

import java.io.FileWriter;
import java.io.IOException;

public class Demo02FileWriter {

	/**
	 * FileWriter类的write()方法可以自动把字符转为字节写出
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("chinese2_output.txt");
		fw.write("无情最是台城柳，依旧烟笼十里堤。 --台城");
		fw.write(97);
		fw.close();
	}

}
