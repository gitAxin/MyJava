package cn.giteasy.gui;

import java.awt.*;

/**
 * 流式布局管理器
 */
public class Demo02FlowLayout {


	public static void main(String[] args) {
		Frame f = new Frame("FlowLayout");
		f.setSize(400, 600);
		f.setLayout(new FlowLayout());
		f.setVisible(true);


		//awt对中文支持不好，会出现乱码，可能需要在哪里设置，未深入研究
		Button b1 = new Button("button1");
		Button b2 = new Button("button2");
		Button b3 = new Button("button3");
		Button b4 = new Button("button4");
		Button b5 = new Button("button5");
		Button b6 = new Button("button6");
		Button b7 = new Button("button7");

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);





	}

}
