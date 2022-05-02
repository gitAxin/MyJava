package cn.giteasy.chario;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo03Copy {


	/**
	 * 字符流也可以拷贝文本文件, 但不推荐使用. 因为读取时会把字节转为字符, 写出时还要把字符转回字节.
	 * 程序需要读取一段文本, 或者需要写出一段文本的时候可以使用字符流
	 * 读取的时候是按照字符的大小读取的,不会出现半个中文
	 * 写出的时候可以直接将字符串写出,不用转换为字节数组
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void demo1() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("chinese2.txt");
		FileWriter fw = new FileWriter("chinese2_copy.txt");

		int c;
		while((c = fr.read()) != -1) {
			fw.write(c);
		}

		fr.close();
		fw.close();				//Writer类中有一个2k的小缓冲区,会先将内容写到缓冲区里,再写入文件，如果不关流，可能会丢失数据，关流会将缓冲区内容刷新,再关闭
	}


	/**
	 * 字符流不可以拷贝非纯文本的文件
	 * 因为在读的时候会将字节转换为字符,在转换过程中,可能找不到对应的字符,就会用?代替,写出的时候会将字符转换成字节写出去
	 * 如果是?,直接写出,这样写出之后的文件就乱了,看不了了
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {

		FileReader fr = new FileReader("test.jpg");
		FileWriter fw = new FileWriter("test_copy.jpg");//COPY后的图片打不开

		int c;
		while((c = fr.read()) != -1) {
			fw.write(c);
		}

		fr.close();
		fw.close();
	}


	@Test
	public void demo3() throws IOException {
		FileReader fr = new FileReader("chinese2.txt");
		FileWriter fw = new FileWriter("chinese2_copy3.txt");
		
		char[] arr = new char[1024];
		int len;
		while((len = fr.read(arr)) != -1) {			//将文件上的数据读取到字符数组中
			fw.write(arr,0,len);				//将字符数组中的数据写到文件上
		}
		
		fr.close();
		fw.close();
	}

	@Test
	public void demo4() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("chinese2.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("chinese2_copy4.txt"));

		int ch;
		while((ch = br.read()) != -1) {  //read一次,会先将缓冲区读满,从缓冲去中一个一个的返给临时变量ch
					////write一次,是将数据装到字符数组,装满后再一起写出去
			bw.write(ch);
		}

		br.close();
		bw.close();
	}





}
