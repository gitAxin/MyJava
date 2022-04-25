package cn.giteasy.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 通过查看Map集合的api发现没有iterator方法,那么双列集合如何迭代呢?

 *
 *
 *
 */

public class Demo2Iterator {


	/**
	 *  根据键获取值
	 *   	V get(Object key):根据键获取值
	 */
	@Test
	public void demo1() {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);

		Integer i = map.get("张三");					//根据键获取值
		System.out.println(i);//23

	}

	/**
	 * Set<K> keySet():获取集合中所有键的集合
	 */
	@Test
	public void demo2() {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);
		//获取所有的键
		Set<String> keySet = map.keySet();			//获取所有键的集合
		Iterator<String> it = keySet.iterator();	//获取迭代器
		while(it.hasNext()) {						//判断集合中是否有元素
			String key = it.next();					//获取每一个键
			Integer value = map.get(key);			//根据键获取值
			System.out.println(key + "=" + value);
		}

		/**
		 *
		 * 李四=24
		 * 张三=23
		 * 王五=25
		 * 赵六=26
		 */

	}


	/**
	 * 使用增强for循环遍历
	 */
	@Test
	public void demo3(){
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);

		for(String key : map.keySet()) {			//map.keySet()是所有键的集合
			System.out.println(key + "=" + map.get(key));
		}

		/**
		 * 李四=24
		 * 张三=23
		 * 王五=25
		 * 赵六=26
		 */
	}


	/**
	 *
	 * Set<Map.Entry<K,V>> entrySet():
	 * 		Map集合的第二种迭代,根据键值对对象,获取键和值
	 * 		 A:键值对对象找键和值思路：
	 * 		获取所有键值对对象的集合
	 * 		遍历键值对对象的集合，获取到每一个键值对对象
	 * 		根据键值对对象找键和值
	 */
	@Test
	public void demo4() {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);

		//Map.Entry说明Entry是Map的内部接口,将键和值封装成了Entry对象,并存储在Set集合中
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		//获取每一个对象
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while(it.hasNext()) {
			//获取每一个Entry对象
			Map.Entry<String, Integer> en = it.next();	//父类引用指向子类对象
			//Entry<String, Integer> en = it.next();	//直接获取的是子类对象
			String key = en.getKey();					//根据键值对对象获取键
			Integer value = en.getValue();				//根据键值对对象获取值
			System.out.println(key + "=" + value);
		}

		System.out.println("=====================");
		for(Map.Entry<String, Integer> en : map.entrySet()) {
			System.out.println(en.getKey() + "=" + en.getValue());
		}
	}





}
