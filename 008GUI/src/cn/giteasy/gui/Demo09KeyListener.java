package cn.giteasy.gui;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.awt.event.*;

/**
 * 键盘事件监听
 */
public class Demo09KeyListener {


	public static void main(String[] args) {
		Frame f = new Frame("KeyListener");
		f.setSize(500, 500);
		f.setLocation(500, 50);
		f.setVisible(true);

		f.setLayout(new FlowLayout());

		TextArea textArea = new TextArea("text area",3,50);
		Button b1 = new Button("close");

		f.add(textArea);
		f.add(b1);


		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		/**
		 * 键盘监听文件输入域（匿名内部类继承键盘监听器的适配类）
		 */
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//TODO

			}

			@Override
			public void keyPressed(KeyEvent e) {
				//TODO
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased():" + e.getKeyCode());
				System.out.println("keyReleased():" + textArea.getText());

				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					System.out.println("你输入是空格！");
				}

			}
		});

	}
}
