package cn.giteasy.chario;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * 获取一个文本文本中每个字符出现的次数,将结果写在word_count.txt文本中
 *
 * 分析:
 * 1.创建带缓冲的输入流对象
 * 2.创建双列集合对象TreeMap
 * 3.将读到的字符存储在双列集合中,存储的时候要做判断,如果不包含这个键,就将键和1存储,如果包含这个键,就将该键和值加1存储
 * 4.关闭输入流
 * 5.创建输出流对象
 * 6.遍历集合将集合中的内容写到times.txt中
 * 7.关闭输出流
 *
 */
public class Test02WordCount {


	@Test
	public void test1() throws IOException {
		//1.创建带缓冲的输入流对象
		BufferedReader br = new BufferedReader(new FileReader("最美的遇见.txt"));
		//2.创建双列集合对象TreeMap
		TreeMap<Character, Integer> tm = new TreeMap<>();
		//3.将读到的字符存储在双列集合中,存储的时候要做判断,如果不包含这个键,就将键和1存储,如果包含这个键,就将该键和值加1存储
		int ch;
		while((ch = br.read()) != -1) {
			char c = (char)ch;					//强制类型转换
			/*if(!tm.containsKey(c)) {
				tm.put(c, 1);
			}else {
				tm.put(c, tm.get(c) + 1);
			}*/
			tm.put(c, !tm.containsKey(c) ? 1 : tm.get(c) + 1);
		}
		//4.关闭输入流
		br.close();
		//5.创建输出流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("word_count.txt"));
		//6.遍历集合将集合中的内容写到times.txt中
		for(Character key : tm.keySet()) {
			switch (key) {
			case '\t':
				bw.write("\\t" + "=" + tm.get(key)); 	
				break;
			case '\n':
				bw.write("\\n" + "=" + tm.get(key)); 
				break;
			case '\r':
				bw.write("\\r" + "=" + tm.get(key)); 
				break;
			default:
				bw.write(key + "=" + tm.get(key));//写出键和值
				break;
			}
			bw.newLine();
		}
		//7.关闭输出流
		bw.close();
	}

}
