package com.student.sb.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch6_textcoms.BEPasswordFieldUI;
import org.jb2011.lnf.beautyeye.ch6_textcoms.BETextFieldUI;

/*
 * 学生信息管理系统的主界面
 */
public class Main extends BaseJFrame implements ActionListener {

	private JTextField jtf;
	private JTextField jtf2;
	private JTextField jtf3;
	private JTextField jtf4;

	public Main() {
		this.setTitle("User--学生信息管理系统的主界面");
		this.setBounds((getScreenWidth() - 600) / 2,
				(getScreenHeight() - 400) / 2, 600, 400);

		getContentPane().setLayout(new GridLayout(6, 1, 10, 10));

		JLabel jlabel = new JLabel("可以根据学号查询信息", JLabel.CENTER);
		JLabel jlabel1 = new JLabel("学号：");
		JLabel jlabel2 = new JLabel("姓名：");
		JLabel jlabel3 = new JLabel("电话：");
		JLabel jlabel4 = new JLabel("班级：");

		jtf = new JTextField(27);
		jtf2 = new JTextField(27);
		jtf3 = new JTextField(27);
		jtf4 = new JTextField(27);
		BETextFieldUI.createUI(jtf);
		BETextFieldUI.createUI(jtf2);
		BETextFieldUI.createUI(jtf3);
		BEPasswordFieldUI.createUI(jtf4);

		JPanel panNum = new JPanel(new FlowLayout());
		panNum.add(jlabel1);
		panNum.add(jtf);

		JPanel panName = new JPanel(new FlowLayout());
		panName.add(jlabel2);
		panName.add(jtf2);

		JPanel panPhone = new JPanel(new FlowLayout());
		panPhone.add(jlabel3);
		panPhone.add(jtf3);

		JPanel panClass = new JPanel(new FlowLayout());
		panClass.add(jlabel4);
		panClass.add(jtf4);

		JButton button = new JButton("查询");

		button.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));

		JButton buttonAdd = new JButton("增加");

		buttonAdd.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));

		JButton buttonDel = new JButton("删除");

		buttonDel.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));

		JButton buttonUpdate = new JButton("修改");

		buttonUpdate.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));

		button.addActionListener(this);
		buttonAdd.addActionListener(this);
		buttonDel.addActionListener(this);
		buttonUpdate.addActionListener(this);

		JPanel panButton = new JPanel(new FlowLayout());
		panButton.add(button);
		panButton.add(buttonAdd);
		panButton.add(buttonDel);
		panButton.add(buttonUpdate);

		getContentPane().add(jlabel);
		getContentPane().add(panNum);
		getContentPane().add(panName);
		getContentPane().add(panPhone);
		getContentPane().add(panClass);
		getContentPane().add(panButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("查询")) {
			System.out.println("sdf");

		} else if (e.getActionCommand().equals("删除")) {
			System.out.println("sd1f");

		} else if (e.getActionCommand().equals("增加")) {
			System.out.println("sdf2");

		} else if(e.getActionCommand().equals("修改")) {
			System.out.println("sdf4");
			
		}

	}

}
