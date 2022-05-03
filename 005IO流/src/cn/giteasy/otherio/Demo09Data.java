package cn.giteasy.otherio;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo09Data {


	/**
	 * 使用FileOutputStream写出数据
	 * @throws IOException
	 */
	@Test
	public void demo1() throws IOException {
		FileOutputStream fos = new FileOutputStream("other\\file_output.txt");
		//写出时是按1个字节写的,只写出了最后8位
		//997 => 00000000 00000000 00000011 11100101 写入的是 11100101 => 229
		fos.write(997);
		//998 => 00000000 00000000 00000011 11100110 写入的是 11100110 => 230
		fos.write(998);
		//999 => 00000000 00000000 00000011 11100111 写入的是 11100111 => 231
		fos.write(999);

		fos.close();
	}

	/**
	 *
	 *
	 * 使用FileInputStream读数据
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {
		FileInputStream fis = new FileInputStream("other\\file_output.txt");
		//读取时，只按1个字节读入
		//11100101 => 229
		int x = fis.read();
		//11100110 =>  230
		int y = fis.read();
		//11100111 => 231
		int z = fis.read();

		System.out.println(x);//229
		System.out.println(y);//230
		System.out.println(z);//231

		fis.close();
	}


	/**
	 *  使用 DataOutputStream 写出数据
	 * @throws IOException
	 */
	@Test
	public void demo3() throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("other\\data_file_output.txt"));
		dos.writeInt(997);
		dos.writeInt(998);
		dos.writeInt(999);
		dos.close();
	}



	/**
	 * 997 => 00000000 00000000 00000011 11100101
	 * 998 => 00000000 00000000 00000011 11100110
	 * 999 => 00000000 00000000 00000011 11100111
	 */
	@Test
	public void demo4() throws IOException {

		DataInputStream dis = new DataInputStream(new FileInputStream("other\\data_file_output.txt"));
		int x = dis.readInt();
		int y = dis.readInt();
		int z = dis.readInt();
		
		System.out.println(x);//997
		System.out.println(y);//998
		System.out.println(z);//999
		
		dis.close();
	}






}
