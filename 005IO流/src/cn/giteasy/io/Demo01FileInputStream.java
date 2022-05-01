package cn.giteasy.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 * read()方法读取的是一个字节,为什么返回是int,而不是byte
 *
 * 00010100 00100100 01000001 11111111 0000000
 *
 * 如果按照byte读，当读到第4个四节时，读取到的为-1，读取结束。
 * 10000001    byte类型-1的原码
 * 11111110	   -1的反码
 * 11111111    -1的补码
 *
 * 按照int读取，读取到1个字节，前面会补0，变为4个字节（int类型）
 * 00000000 00000000 00000000 11111111
 *
 *
 * 总结：
 * 因为字节输入流可以操作任意类型的文件,比如图片音频等,这些文件底层都是以二进制形式的存储的,如果每次读取都返回byte,有可能在读到中间的时候遇到111111111
 * 那么这11111111是byte类型的-1,我们的程序是遇到-1就会停止不读了,后面的数据就读不到了,所以在读取的时候用int类型接收,如果11111111会在其前面补上
 * 24个0凑足4个字节,那么byte类型的-1就变成int类型的255了这样可以保证整个数据读完,而结束标记的-1就是int类型
 */
public class Demo01FileInputStream {

	/**
	 * input.txt文件内容：
	 * abcdefghijklmn
	 */
	@Test
	public void demo1() throws FileNotFoundException, IOException {

		FileInputStream fis = new FileInputStream(".\\input.txt");	//创建流对象
		//从硬盘上读取一个字节
		int a = fis.read();
		System.out.println(a);//97

		int b = fis.read();
		System.out.println(b);//98

		int c = fis.read();
		System.out.println(c);//99

		int d = fis.read();
		System.out.println(d);//100

		int e = fis.read();
		System.out.println(e);//101

		//关流释放资源
		fis.close();
	}


	@Test
	public void demo2() throws IOException {
		FileInputStream fis = new FileInputStream(".\\input.txt");	//创建流对象
		int b;
		while((b = fis.read()) != -1) {
			System.out.print(b + " ");
		}
		System.out.println();
		
		fis.close();

		/**
		 * 输出结果：
		 * 97 98 99 100 101 102 103 104 105 106 107 108 109 110
		 */
	}

}
