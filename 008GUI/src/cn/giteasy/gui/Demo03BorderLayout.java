package cn.giteasy.gui;

import java.awt.*;

/**
 * 边界布局管理器
 */
public class Demo03BorderLayout {


	public static void main(String[] args) {
		Frame f = new Frame("BorderLayout");
		f.setSize(400, 600);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		Button b1 = new Button("north");
		Button b2 = new Button("south");
		Button b3 = new Button("west");
		Button b4 = new Button("east");
		Button b5 = new Button("center");


		f.add(b1,BorderLayout.NORTH);
		f.add(b2,BorderLayout.SOUTH);
		f.add(b3,BorderLayout.WEST);
		f.add(b4,BorderLayout.EAST);
		f.add(b5,BorderLayout.CENTER);

	}

}
