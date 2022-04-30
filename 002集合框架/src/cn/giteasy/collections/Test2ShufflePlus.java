package cn.giteasy.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * 模拟斗地主洗牌和发牌，并对发的牌进行大小排序
 *
 * 分析:
 * 1,买一副扑克（自己创建一个集合对象,将扑克牌存储进去）
 * 2,洗牌
 * 3,发牌 (发牌后，发的牌进行大小顺序排序)
 */
public class Test2ShufflePlus {

	public static final String[] NUM = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
	public static final String[] COLOR = {"红桃","黑桃","方片","梅花"};
	public static final HashMap<Integer, String> PART = new HashMap<>();					//存储索引和扑克牌
	public static final ArrayList<Integer> LIST = new ArrayList<>();					//存储索引
	public static int INDEX = 0;

	static {
		//拼接扑克牌并索引和扑克牌存储在hm中
		for(String s1 : NUM) {											//获取数字
			for(String s2 : COLOR) {									//获取颜色
				PART.put(INDEX, s2.concat(s1));
				LIST.add(INDEX);										//将索引0到51添加到list集合中
				INDEX++;
			}
		}
		//将大小王添加到双列集合中
		PART.put(INDEX, "小王");
		LIST.add(INDEX);												//将52索引添加到集合中
		INDEX ++;
		PART.put(INDEX, "大王");
		LIST.add(INDEX);												//将53索引添加到集合中
	}


	public static void main(String[] args) {
		//1,洗牌
		Collections.shuffle(LIST);
		//2,发牌
		TreeSet<Integer> p1 = new TreeSet<>();
		TreeSet<Integer> p2 = new TreeSet<>();
		TreeSet<Integer> p3 = new TreeSet<>();
		TreeSet<Integer> p0 = new TreeSet<>(); //底牌
		
		for(int i = 0; i < LIST.size(); i++) {
			if(i >= LIST.size() - 3) {
				p0.add(LIST.get(i));							//将三张底牌存储在底牌集合中
			}else if(i % 3 == 0) {
				p1.add(LIST.get(i));
			}else if(i % 3 == 1) {
				p2.add(LIST.get(i));
			}else {
				p3.add(LIST.get(i));
			}
		}
		
		//看牌
		lookPoker(PART, p1, "p1");
		lookPoker(PART, p2, "p2");
		lookPoker(PART, p3, "p3");
		lookPoker(PART, p0, "底牌");
	}
	/**
	 * 看牌
	 * 1,返回值类型void
	 * 2,参数列表HashMap,TreeSet,String name
	 */
	public static void lookPoker(HashMap<Integer, String> PART,TreeSet<Integer> ts ,String name) {
		System.out.print(name + "的牌是:");
		for(Integer i : ts) {						//i代表双列集合中的每一个键
			System.out.print(PART.get(i) + " ");
		}
		System.out.println();
	}
}
