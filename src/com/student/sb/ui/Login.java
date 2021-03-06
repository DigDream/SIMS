package com.student.sb.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch6_textcoms.BETextFieldUI;

import com.student.sb.utils.SqlUtils;

public class Login extends BaseJFrame implements ActionListener {
	private JTextField jtfuser;
	private JPasswordField jtfpass;

	public Login() {
		this.setTitle("登录界面");
		this.setBounds((getScreenWidth() - 300) / 2,
				(getScreenHeight() - 200) / 2, 300, 200);
		this.setResizable(false);

		getContentPane().setLayout(new GridLayout(4, 1, 10, 10));

		JLabel jlabel = new JLabel("数据库连接正常，请输入您的用户名和密码", JLabel.CENTER);
		jtfuser = new JTextField();
		jtfpass = new JPasswordField();
		jtfpass.addActionListener(this);

		BETextFieldUI.createUI(jtfuser);

		JButton btnlogin = new JButton("登录");
		btnlogin.addActionListener(this);
		btnlogin.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));

		getContentPane().add(jlabel);
		getContentPane().add(jtfuser);
		getContentPane().add(jtfpass);
		getContentPane().add(btnlogin);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 获取用户名和密码
		System.out.println(jtfuser.getText()
				+ String.valueOf(jtfpass.getPassword()));
		// 加密类加密
		// 与数据库进行对比
		String str = SqlUtils
				.execResultSetSql("SELECT `pw` FROM `user_table` WHERE `user` = 'test'");
		if (str.equals(String.valueOf(jtfpass.getPassword()))) {
			JOptionPane.showMessageDialog(null, "登录成功", "学生信息管理系统",
					JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			Main main = new Main();
		} else {
			JOptionPane.showMessageDialog(null, "登录失败", "学生信息管理系统",
					JOptionPane.WARNING_MESSAGE);
		}
		// 根据返回值判断
	}
}
