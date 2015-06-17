package com.student.sb.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch6_textcoms.BEPasswordFieldUI;
import org.jb2011.lnf.beautyeye.ch6_textcoms.BETextFieldUI;

import com.student.sb.utils.PropertiesUtils;
import com.student.sb.utils.SqlUtils;

/*
 * 第一个界面，在测试数据库无法连接时会出现
 */

public class SqlInit extends BaseJFrame {
	private JTextField jtf;
	private JTextField jtf2;
	private JTextField jtf3;
	private JPasswordField jtf4;

	public SqlInit() {
		// 此处应该测试数据库连接，如果能连上则显示登录界面
		this.setBounds((getScreenWidth() - 400) / 2,
				(getScreenHeight() - 300) / 2, 400, 300);
		this.setTitle("SIMS-学生信息管理系统");
		getContentPane().setLayout(new GridLayout(6, 1, 10, 10));

		JLabel jlabel = new JLabel("数据库连接失败，请填写下列信息", JLabel.CENTER);
		JLabel jlabel1 = new JLabel("连接地址：");
		JLabel jlabel2 = new JLabel("连接端口：");
		JLabel jlabel3 = new JLabel("连接用户：");
		JLabel jlabel4 = new JLabel("连接密码：");

		jtf = new JTextField(27);
		jtf2 = new JTextField(27);
		jtf3 = new JTextField(27);
		jtf4 = new JPasswordField(27);
		BETextFieldUI.createUI(jtf);
		BETextFieldUI.createUI(jtf2);
		BETextFieldUI.createUI(jtf3);
		BEPasswordFieldUI.createUI(jtf4);

		JPanel panAdd = new JPanel(new FlowLayout());
		panAdd.add(jlabel1);
		panAdd.add(jtf);

		JPanel panPort = new JPanel(new FlowLayout());
		panPort.add(jlabel2);
		panPort.add(jtf2);

		JPanel panUser = new JPanel(new FlowLayout());
		panUser.add(jlabel3);
		panUser.add(jtf3);

		JPanel panPass = new JPanel(new FlowLayout());
		panPass.add(jlabel4);
		panPass.add(jtf4);

		JButton button = new JButton("保存");

		button.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 保存信息
				PropertiesUtils.writeConn(jtf.getText(), jtf2.getText(),
						jtf3.getText(), String.valueOf(jtf4.getPassword()));
				// 测试连接
				try {
					String url = "jdbc:mysql://" + jtf.getText() + ":"
							+ jtf2.getText() + "/";
					
					SqlUtils.setConnection(url, jtf3.getText(),
							String.valueOf(jtf4.getPassword()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "请重新填写信息", "数据库连接失败",
							JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
				// 如果无法连接则弹出对话框
				// 初始化数据
				// 创建数据库和表
				// 跳转界面
				SqlInit.this.setVisible(false);
				Login mJframe = new Login();

			}
		});

		getContentPane().add(jlabel);
		getContentPane().add(panAdd);
		getContentPane().add(panPort);
		getContentPane().add(panUser);
		getContentPane().add(panPass);
		getContentPane().add(button);
		this.setVisible(true);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		UIManager.put("RootPane.setupButtonVisible", false);
		// 测试是否能连接数据库，连接不上则显示数据库界面
		try {
			SqlUtils.isConnectSql();
			Main mJframe = new Main();
		} catch (Exception e) {
			SqlInit sqlInit = new SqlInit();
			e.printStackTrace();
		}
		System.out.println(PropertiesUtils.readKey("ISFIRST").equals("true"));
	}
}
