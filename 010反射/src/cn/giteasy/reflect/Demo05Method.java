package cn.giteasy.reflect;

import java.lang.reflect.Method;

import cn.giteasy.common.Person;
import org.junit.Test;

/**
 * 通过反射获取方法并使用
 *
 * Class.getMethod(String, Class...) 和 Class.getDeclaredMethod(String,Class...)方法可以获取类中的指定方法,
 * invoke(Object,Object...)可以调用该方法；
 * Class.getMethod("eat").invoke(obj)
 * Class.getMethod("eat",int.class).invoke(obj,10)
 */
public class Demo05Method {


	@Test
	public void demo1() throws Exception {
		Class clazz = Class.forName("cn.giteasy.common.Person");
		Person person = (Person) clazz.newInstance();

		Method method = clazz.getMethod("run");					//获取eat方法
		method.invoke(person);//跑步...


		/**
		 * 如果方法是私有的，使用
		 * Class.getDeclaredMethod(String,Class...)
		 */
		Method method2 = clazz.getDeclaredMethod("run", int.class);		//获取有参的eat方法
		method2.setAccessible(true);
		method2.invoke(person, 100);//跑步100公里...
	}



}
