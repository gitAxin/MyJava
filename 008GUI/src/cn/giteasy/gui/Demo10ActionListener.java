package cn.giteasy.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * 动作事件监听
 */
public class Demo10ActionListener {


	public static void main(String[] args) {
		Frame f = new Frame("MouseListener");
		f.setSize(400, 600);
		f.setLocation(500, 50);
		f.setVisible(true);

		f.setLayout(new FlowLayout());
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing()");
				System.exit(0);
			}
		});

		Button b1 = new Button("button1");
		Button b2 = new Button("button2");
		f.add(b1);
		f.add(b2);

		/**
		 * 使用动作监听器监听鼠标单击按钮事件
		 * 创建动作监听器
		 */
		ActionListener  myActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("actionPerformed:" + e.getActionCommand());

			}
		};

		/**
		 * 向按钮添加动作监听器
		 */
		b1.addActionListener(myActionListener);
		b2.addActionListener(myActionListener);


	}
}
