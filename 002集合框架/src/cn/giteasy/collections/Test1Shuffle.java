package cn.giteasy.collections;

import java.util.ArrayList;
import java.util.Collections;
/**
 * A:案例演示
 * 模拟斗地主洗牌和发牌
 *
 * 分析:
 * 1,买一副扑克（自己创建一个集合对象,将扑克牌存储进去）
 * 2,洗牌
 * 3,发牌 (发牌后，发的牌没有大小顺序排序)
 * 4,看牌
 */

public class Test1Shuffle {

	/**
	 *扑克牌
	 */
	private static final String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private static final String[] color = {"红桃","黑桃","方片","梅花"};
	//一副扑克牌
	private static final ArrayList<String> coll = new ArrayList<>();

	static {
		//拼接花色和数字
		for(String s1 : color) {
			for(String s2 : num) {
				coll.add(s1.concat(s2)); 			//concat连接两个字符串
			}
		}
		coll.add("小王");
		coll.add("大王");
	}

	public static void main(String[] args) {
		//1,洗牌
		Collections.shuffle(coll);
		//System.out.println(coll);
		//2,发牌
		ArrayList<String> p1 = new ArrayList<>();
		ArrayList<String> p2 = new ArrayList<>();
		ArrayList<String> p3 = new ArrayList<>();
		ArrayList<String> p0 = new ArrayList<>();//底牌
		
		for(int i = 0; i < coll.size(); i++) {
			if(i >= coll.size() - 3) {
				p0.add(coll.get(i));					//将三张底牌存储在底牌集合中
			} else if(i % 3 == 0) {
				p1.add(coll.get(i));
			} else if(i % 3 == 1) {
				p2.add(coll.get(i));
			} else {
				p3.add(coll.get(i));
			}
		}
		
		//3,看牌
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p0);
	}

}
