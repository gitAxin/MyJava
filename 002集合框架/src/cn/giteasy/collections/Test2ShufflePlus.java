package cn.giteasy.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * ģ�⶷����ϴ�ƺͷ��ƣ����Է����ƽ��д�С����
 *
 * ����:
 * 1,��һ���˿ˣ��Լ�����һ�����϶���,���˿��ƴ洢��ȥ��
 * 2,ϴ��
 * 3,���� (���ƺ󣬷����ƽ��д�С˳������)
 */
public class Test2ShufflePlus {

	public static final String[] NUM = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
	public static final String[] COLOR = {"����","����","��Ƭ","÷��"};
	public static final HashMap<Integer, String> PART = new HashMap<>();					//�洢�������˿���
	public static final ArrayList<Integer> LIST = new ArrayList<>();					//�洢����
	public static int INDEX = 0;

	static {
		//ƴ���˿��Ʋ��������˿��ƴ洢��hm��
		for(String s1 : NUM) {											//��ȡ����
			for(String s2 : COLOR) {									//��ȡ��ɫ
				PART.put(INDEX, s2.concat(s1));
				LIST.add(INDEX);										//������0��51��ӵ�list������
				INDEX++;
			}
		}
		//����С����ӵ�˫�м�����
		PART.put(INDEX, "С��");
		LIST.add(INDEX);												//��52������ӵ�������
		INDEX ++;
		PART.put(INDEX, "����");
		LIST.add(INDEX);												//��53������ӵ�������
	}


	public static void main(String[] args) {
		//1,ϴ��
		Collections.shuffle(LIST);
		//2,����
		TreeSet<Integer> p1 = new TreeSet<>();
		TreeSet<Integer> p2 = new TreeSet<>();
		TreeSet<Integer> p3 = new TreeSet<>();
		TreeSet<Integer> p0 = new TreeSet<>(); //����
		
		for(int i = 0; i < LIST.size(); i++) {
			if(i >= LIST.size() - 3) {
				p0.add(LIST.get(i));							//�����ŵ��ƴ洢�ڵ��Ƽ�����
			}else if(i % 3 == 0) {
				p1.add(LIST.get(i));
			}else if(i % 3 == 1) {
				p2.add(LIST.get(i));
			}else {
				p3.add(LIST.get(i));
			}
		}
		
		//����
		lookPoker(PART, p1, "p1");
		lookPoker(PART, p2, "p2");
		lookPoker(PART, p3, "p3");
		lookPoker(PART, p0, "����");
	}
	/**
	 * ����
	 * 1,����ֵ����void
	 * 2,�����б�HashMap,TreeSet,String name
	 */
	public static void lookPoker(HashMap<Integer, String> PART,TreeSet<Integer> ts ,String name) {
		System.out.print(name + "������:");
		for(Integer i : ts) {						//i����˫�м����е�ÿһ����
			System.out.print(PART.get(i) + " ");
		}
		System.out.println();
	}
}
