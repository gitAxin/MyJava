package cn.giteasy.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将写出的字节异或一个数,这个数就是密钥,解密的时候再次异或就可以了
 *
 * 提示：一个数，异常另一个数两次，等于它本身。
 *
 */

public class Test01 {



	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test_copy2.jpg"));
		
		int b;
		while((b = bis.read()) != -1) {
			bos.write(b ^ 123);
		}
		
		bis.close();
		bos.close();
	}

}
