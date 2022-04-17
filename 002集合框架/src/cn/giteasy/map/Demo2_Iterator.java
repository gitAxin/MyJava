package cn.giteasy.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo2_Iterator {

	/**
	 * ͨ���鿴Map���ϵ�api����û��iterator����,��ô˫�м�����ε�����?
	 * ���ݼ���ȡֵ
	 */
	public static void main(String[] args) {
		//demo1();

		//demo2();
		//demo3();

	}

	/**
	 * Map���ϵĵڶ��ֵ���,���ݼ�ֵ�Զ���,��ȡ����ֵ
	 *  A:��ֵ�Զ����Ҽ���ֵ˼·��
	 * ��ȡ���м�ֵ�Զ���ļ���
	 * ������ֵ�Զ���ļ��ϣ���ȡ��ÿһ����ֵ�Զ���
	 * ���ݼ�ֵ�Զ����Ҽ���ֵ
	 */
	@Test
	public void demo4() {
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);

		//Map.Entry˵��Entry��Map���ڲ��ӿ�,������ֵ��װ����Entry����,���洢��Set������
		/*Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		//��ȡÿһ������
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while(it.hasNext()) {
			//��ȡÿһ��Entry����
			Map.Entry<String, Integer> en = it.next();	//��������ָ���������
			//Entry<String, Integer> en = it.next();	//ֱ�ӻ�ȡ�����������
			String key = en.getKey();					//���ݼ�ֵ�Զ����ȡ��
			Integer value = en.getValue();				//���ݼ�ֵ�Զ����ȡֵ
			System.out.println(key + "=" + value);
		}*/

		for(Map.Entry<String, Integer> en : map.entrySet()) {
			System.out.println(en.getKey() + "=" + en.getValue());
		}
	}

	//ʹ����ǿforѭ������
	private static void demo3(){
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);

		for(String key : map.keySet()) {			//map.keySet()�����м��ļ���
			System.out.println(key + "=" + map.get(key));
		}

		/**
		 * ����=24
		 * ����=23
		 * ����=25
		 * ����=26
		 */
	}



	private static void demo2() {
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);
		//��ȡ���еļ�
		Set<String> keySet = map.keySet();			//��ȡ���м��ļ���
		Iterator<String> it = keySet.iterator();	//��ȡ������
		while(it.hasNext()) {						//�жϼ������Ƿ���Ԫ��
			String key = it.next();					//��ȡÿһ����
			Integer value = map.get(key);			//���ݼ���ȡֵ
			System.out.println(key + "=" + value);
		}

		/**
		 *
		 * ����=24
		 * ����=23
		 * ����=25
		 * ����=26
		 */

	}

	private static void demo1() {
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);

		Integer i = map.get("����");					//���ݼ���ȡֵ
		System.out.println(i);//23

	}

}
