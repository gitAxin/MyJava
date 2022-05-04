package cn.giteasy.chario;


/**
 *
 * 设计模式：装饰模式
 *
 *	装饰设计模式的好处是:
 * 		耦合性不强,被装饰的类的变化与装饰类的变化无关
 */
public class Demo06Wrapper {


	public static void main(String[] args) {
		//被包装前
		Parent child = new Child();
		child.method();

		System.out.println("被包装后==================");

		//被包装后
		Parent wrapper = new Wrapper(new Child());
		wrapper.method();




	}

}

interface Parent {
	public void method();
}

class Child implements Parent {

	@Override
	public void method() {
		System.out.println("hello world");
	}
	
}

class Wrapper implements Parent {

	/**
	 * 1.获取被装饰类的引用
	 */
	private Child child;   //被包装引用

	/**
	 * 2.在构造方法中传入被装饰类的对象
	 */
	public Wrapper(Child child) {
		this.child = child;
	}

	/**
	 * 3.对原有的功能进行升级
	 */
	@Override
	public void method() {
		child.method();
		System.out.println("hello java");
		System.out.println("hello javascript");
		System.out.println("hello oracle");
		System.out.println("hello typescript");
		System.out.println("......");
	}
}
