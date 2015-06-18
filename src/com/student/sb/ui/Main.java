package com.student.sb.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch6_textcoms.BEPasswordFieldUI;
import org.jb2011.lnf.beautyeye.ch6_textcoms.BETextFieldUI;

import com.student.sb.utils.SqlUtils;

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
			// 获取学号值
			String str = jtf.getText();
			// sql查询

			ResultSet rs = SqlUtils
					.execReturnRS("SELECT `class`,`name`, `phone` FROM `software` WHERE `student_id` = "
							+ str);
			// 拼接sql语句
			try {
				if (rs == null) {
					JOptionPane.showMessageDialog(null, "查询失败", "学生信息管理系统",
							JOptionPane.WARNING_MESSAGE);
				} else {
					jtf4.setText(rs.getString(1));
					jtf2.setText(rs.getString(2));
					jtf3.setText(rs.getString(3));
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "查询失败", "学生信息管理系统",
						JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
			// 返回值
		} else if (e.getActionCommand().equals("删除")) {
			String num = jtf.getText();

			int result = SqlUtils
					.execSql("DELETE FROM `sxaustudents`.`software` WHERE `software`.`student_id` = "
							+ num + ";");

			if (result == 1) {
				JOptionPane.showMessageDialog(null, "删除成功", "学生信息管理系统",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (e.getActionCommand().equals("增加")) {
			String num = jtf.getText();
			String sclass = jtf4.getText();
			String name = jtf2.getText();
			String phone = jtf3.getText();

			ResultSet resultsql = SqlUtils
					.execReturnRS("SELECT * FROM `software` WHERE `student_id` = "
							+ num);

			try {
				if (resultsql == null) {
					int result = SqlUtils
							.execSql("INSERT INTO `sxaustudents`.`software` (`id`, `collage`, `grade`, `class`, `student_id`, `name`, `sex`, `nation`, `phone`, `dorm`, `politics`, `identity_id`, `home_phone`, `zip`, `address`, `native_palce`, `family_backgrond`, `reward`, `other`, `duty`) VALUES (NULL, NULL, NULL, '"
									+ sclass
									+ "', '"
									+ num
									+ "', ' "
									+ name
									+ "', NULL, NULL, ' "
									+ phone
									+ "', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'test');");

					if (result == 1) {
						JOptionPane.showMessageDialog(null, "添加成功", "学生信息管理系统",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "添加失败", "学生信息管理系统",
							JOptionPane.WARNING_MESSAGE);

				}

			} catch (HeadlessException e1) {
				e1.printStackTrace();
			}

		} else if (e.getActionCommand().equals("修改")) {
			String num = jtf.getText();
			String sclass = jtf4.getText();
			String name = jtf2.getText();
			String phone = jtf3.getText();

			int result = SqlUtils
					.execSql("UPDATE `sxaustudents`.`software` SET `class` = '"
							+ sclass + "', `name` = '" + name
							+ "', `phone` = '" + phone
							+ "' WHERE `software`.`student_id` = " + num + ";");

			if (result == 1) {
				JOptionPane.showMessageDialog(null, "修改成功", "学生信息管理系统",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
