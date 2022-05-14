package cn.giteasy.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *监听器：
 * 一个自定义类的对象, 实现了监听器接口, 包含事件处理方法,把监听器添加在事件源上,
 * 当事件发生的时候虚拟机就会自动调用监听器中的事件处理方法
 *
 *
 * 演示：窗体事件监听
 */
public class Demo07WindowListener {


	public static void main(String[] args) {
		Frame f = new Frame("WindowListener");
		f.setSize(500, 500);
		f.setLocation(500, 50);
		f.setVisible(true);
		Button b1 = new Button("button1");
		Button b2 = new Button("button2");
		f.add(b1);
		f.add(b2);

		/**
		 * 添加窗口监听器
		 *
		 * 事件源是窗体,把监听器注册到事件源上
		 */
		//f.addWindowListener(new MyWindowListener());

		/**
		 * 使用装饰类“WindowAdapter”，实现监听窗口事件
		 * 优点：使用哪个方法，就重写哪个方法
		 */
		//f.addWindowListener(new MyWindowAdapter());

		/**
		 * 使用匿名内部类,实现监听窗口事件
		 */
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("匿名内部类，实现监听窗口事件！windowClosing");
				System.exit(0);
			}
		});
	}
}

/**
 * 定义窗口监听器，实现用户单击关闭按钮时，可以关闭窗口，
 * 缺点：为了使用这个监听器中的一个方法，就要重写接口中的所有方法
 *
 * 替换方法：使有WindowListener的装饰类 WindowAdapter
 * @see  cn.giteasy.gui.MyWindowAdapter
 *
 */
class MyWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}

	/**
	 * 当用户单击窗口右上角关闭时执行
	 * @param e
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		System.exit(0);
	}


	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");

	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}

}

/**
 * 继承WindowListener的装饰类“WindowAdapter”，重写需要使用的方法，实现监听用户单击关闭事件，关闭窗口
 * WindowAdapter
 *
 * 优点：需要使用哪个方法，就重写哪个方法
 */
class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("cn.giteasy.gui.MyWindowAdapter.windowClosing()");
		System.exit(0);
	}
}

