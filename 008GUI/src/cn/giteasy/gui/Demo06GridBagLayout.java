package cn.giteasy.gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 网格包布局
 */
public class Demo06GridBagLayout {


	public static void main(String[] args) {
		Frame f = new Frame("GridBagLayout");
		f.setVisible(true);

		GridBagLayout layout=new GridBagLayout();
		f.setLayout(layout);

		GridBagConstraints c=new GridBagConstraints();
		//设置横向坐标可以拉伸
		c.fill=GridBagConstraints.BOTH;
		//设置横向，纵向权值为1
		c.weightx=1;
		c.weighty=0;

		Button btn1 = new Button("btn1");
		Button btn2 = new Button("btn2");
		Button btn3 = new Button("btn3");
		Button btn4 = new Button("btn4");
		Button btn5 = new Button("btn5");

		layout.setConstraints(btn1,c);
		layout.setConstraints(btn2,c);
		layout.setConstraints(btn3,c);
		layout.setConstraints(btn4,c);
		//本行最后一个组件
		c.gridwidth=GridBagConstraints.REMAINDER;
		layout.setConstraints(btn5,c);

		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		f.add(btn5);

		//设置横向，纵向权值为0
		c.weightx=0;
		c.weighty=0;
		Button btn6 = new Button("btn6");
		layout.setConstraints(btn6,c);
		f.add(btn6);

		//设置组件横向占2个网格
		c.gridwidth=2;
		Button btn7 = new Button("btn7");
		layout.setConstraints(btn7,c);
		f.add(btn7);

		//本行最后一个组件
		c.gridwidth=GridBagConstraints.REMAINDER;
		Button btn8 = new Button("btn8");
		layout.setConstraints(btn8,c);
		f.add(btn8);

	   //设置组件纵向跨两个网格，横向跨一个网格
		c.gridheight=2;
		c.gridwidth=1;
		//设置横向，纵向权重为2
		c.weightx=2;
		c.weighty=2;
		Button btn9 = new Button("btn9");
		layout.setConstraints(btn9,c);
		f.add(btn9);

		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=1;
		Button btn10 = new Button("btn10");
		Button btn11 = new Button("btn11");
		layout.setConstraints(btn10,c);
		layout.setConstraints(btn11,c);
		f.add(btn10);
		f.add(btn11);

		//设置frame最佳大小并可见
		f.pack();

	}

}
