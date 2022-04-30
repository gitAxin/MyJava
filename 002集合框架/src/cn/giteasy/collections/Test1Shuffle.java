package cn.giteasy.collections;

import java.util.ArrayList;
import java.util.Collections;
/**
 * A:������ʾ
 * ģ�⶷����ϴ�ƺͷ���
 *
 * ����:
 * 1,��һ���˿ˣ��Լ�����һ�����϶���,���˿��ƴ洢��ȥ��
 * 2,ϴ��
 * 3,���� (���ƺ󣬷�����û�д�С˳������)
 * 4,����
 */

public class Test1Shuffle {

	/**
	 *�˿���
	 */
	private static final String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private static final String[] color = {"����","����","��Ƭ","÷��"};
	//һ���˿���
	private static final ArrayList<String> coll = new ArrayList<>();

	static {
		//ƴ�ӻ�ɫ������
		for(String s1 : color) {
			for(String s2 : num) {
				coll.add(s1.concat(s2)); 			//concat���������ַ���
			}
		}
		coll.add("С��");
		coll.add("����");
	}

	public static void main(String[] args) {
		//1,ϴ��
		Collections.shuffle(coll);
		//System.out.println(coll);
		//2,����
		ArrayList<String> p1 = new ArrayList<>();
		ArrayList<String> p2 = new ArrayList<>();
		ArrayList<String> p3 = new ArrayList<>();
		ArrayList<String> p0 = new ArrayList<>();//����
		
		for(int i = 0; i < coll.size(); i++) {
			if(i >= coll.size() - 3) {
				p0.add(coll.get(i));					//�����ŵ��ƴ洢�ڵ��Ƽ�����
			} else if(i % 3 == 0) {
				p1.add(coll.get(i));
			} else if(i % 3 == 1) {
				p2.add(coll.get(i));
			} else {
				p3.add(coll.get(i));
			}
		}
		
		//3,����
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p0);
	}

}
