package cn.giteasy.reflect;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 练习：
 * 	通过反射越过泛型检查
 *
 * ArrayList<Integer>的一个集合，向这个集合中添加一个String类型元素.
 *
 * 提示：泛型只在编译期有效,在运行期会被擦除掉
 */
public class Test01 {

	@Test
	public void test1() throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(100);
		list.add(101);

		Class clazz = Class.forName("java.util.ArrayList");				//获取字节码对象
		Method method = clazz.getMethod("add", Object.class);		//获取add方法
		method.invoke(list, "str");

		//[100, 101, str]
		System.out.println(list);
	}


}
