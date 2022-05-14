package cn.giteasy.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * 鼠标事件监听
 */
public class Demo08MouseListener {


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

		Button b1 = new Button("close window!");
		f.add(b1);

		/**
		 * 添加鼠标监听器（匿名内部类继承鼠标监听器的适配类）
		 */
		b1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked()");
				System.exit(0);
			}

			/**
			 * 按下
			 * @param e
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("mousePressed()");
			}

			/**
			 * 释放
			 * @param e
			 */
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased()");
			}

			/**
			 * TODO
			 * 更多事件
			 * ......
			 * ......
			 */


		});
	}
}
