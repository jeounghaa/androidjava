package Login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DB.UserDAO;
import DB.UserVO;
import Main.Main;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class Register extends JFrame {

	// 01011111111 만 가능 (010-1111-1111 불가능)
	String telpattern = "\\d{3}\\d{3,4}\\d{4}";
	String telpattern2 = "\\d{3}-\\d{3,4}-\\d{4}";
	// abc@abc.com
	String emailpattern = "\\w+@\\w+.\\w+(\\.\\w+)?";

	public Register() {
		getContentPane().setBackground(new Color(95, 158, 160));
		setTitle("회원가입");
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 20));

		setSize(500, 500);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 140, 15, 31, 184, 0 };
		gridBagLayout.rowHeights = new int[] { 32, 29, 29, 0, 0, 29, 29, 29, 29, 0, 13, 31, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel l0 = new JLabel("회원가입");
		l0.setFont(new Font("굴림", Font.PLAIN, 40));

		GridBagConstraints gbc_l0 = new GridBagConstraints();
		gbc_l0.anchor = GridBagConstraints.WEST;
		gbc_l0.fill = GridBagConstraints.VERTICAL;
		gbc_l0.insets = new Insets(0, 0, 5, 5);
		gbc_l0.gridx = 1;
		gbc_l0.gridy = 1;
		getContentPane().add(l0, gbc_l0);

		JLabel l1 = new JLabel("아이디");
		l1.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_l1 = new GridBagConstraints();
		gbc_l1.anchor = GridBagConstraints.NORTH;
		gbc_l1.fill = GridBagConstraints.HORIZONTAL;
		gbc_l1.insets = new Insets(0, 0, 5, 5);
		gbc_l1.gridx = 1;
		gbc_l1.gridy = 3;
		getContentPane().add(l1, gbc_l1);
		// 아이디 입력
		JTextField f1 = new JTextField();
		f1.setFont(new Font("Dialog", Font.PLAIN, 19));
		f1.setColumns(15);
		GridBagConstraints gbc_f1 = new GridBagConstraints();
		gbc_f1.fill = GridBagConstraints.BOTH;
		gbc_f1.insets = new Insets(0, 0, 5, 0);
		gbc_f1.gridwidth = 3;
		gbc_f1.gridx = 2;
		gbc_f1.gridy = 3;
		getContentPane().add(f1, gbc_f1);

		JLabel l2 = new JLabel("패스워드");
		l2.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_l2 = new GridBagConstraints();
		gbc_l2.anchor = GridBagConstraints.NORTH;
		gbc_l2.fill = GridBagConstraints.HORIZONTAL;
		gbc_l2.insets = new Insets(0, 0, 5, 5);
		gbc_l2.gridx = 1;
		gbc_l2.gridy = 4;
		getContentPane().add(l2, gbc_l2);
		// 비밀번호 입력
		JTextField f2 = new JTextField();
		f2.setFont(new Font("Dialog", Font.PLAIN, 19));
		f2.setColumns(15);
		GridBagConstraints gbc_f2 = new GridBagConstraints();
		gbc_f2.fill = GridBagConstraints.BOTH;
		gbc_f2.insets = new Insets(0, 0, 5, 0);
		gbc_f2.gridwidth = 3;
		gbc_f2.gridx = 2;
		gbc_f2.gridy = 4;
		getContentPane().add(f2, gbc_f2);

		JLabel l3 = new JLabel("패스워드 확인");
		l3.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_l3 = new GridBagConstraints();
		gbc_l3.anchor = GridBagConstraints.NORTH;
		gbc_l3.fill = GridBagConstraints.HORIZONTAL;
		gbc_l3.insets = new Insets(0, 0, 5, 5);
		gbc_l3.gridx = 1;
		gbc_l3.gridy = 5;
		getContentPane().add(l3, gbc_l3);
		// 비밀번호 확인 입력
		JTextField f3 = new JTextField();
		f3.setFont(new Font("Dialog", Font.PLAIN, 19));
		f3.setColumns(15);
		GridBagConstraints gbc_f3 = new GridBagConstraints();
		gbc_f3.fill = GridBagConstraints.BOTH;
		gbc_f3.insets = new Insets(0, 0, 5, 0);
		gbc_f3.gridwidth = 3;
		gbc_f3.gridx = 2;
		gbc_f3.gridy = 5;
		getContentPane().add(f3, gbc_f3);

		JLabel l4 = new JLabel("이름");
		l4.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_l4 = new GridBagConstraints();
		gbc_l4.anchor = GridBagConstraints.NORTH;
		gbc_l4.fill = GridBagConstraints.HORIZONTAL;
		gbc_l4.insets = new Insets(0, 0, 5, 5);
		gbc_l4.gridx = 1;
		gbc_l4.gridy = 6;
		getContentPane().add(l4, gbc_l4);
		// 이름 입력
		JTextField f4 = new JTextField();
		f4.setFont(new Font("Dialog", Font.PLAIN, 19));
		f4.setColumns(15);
		GridBagConstraints gbc_f4 = new GridBagConstraints();
		gbc_f4.fill = GridBagConstraints.BOTH;
		gbc_f4.insets = new Insets(0, 0, 5, 0);
		gbc_f4.gridwidth = 3;
		gbc_f4.gridx = 2;
		gbc_f4.gridy = 6;
		getContentPane().add(f4, gbc_f4);

		JLabel l5 = new JLabel("연락처");
		l5.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_l5 = new GridBagConstraints();
		gbc_l5.fill = GridBagConstraints.HORIZONTAL;
		gbc_l5.insets = new Insets(0, 0, 5, 5);
		gbc_l5.gridx = 1;
		gbc_l5.gridy = 7;
		getContentPane().add(l5, gbc_l5);
		// 연락처 입력
		JTextField f5 = new JTextField();
		f5.setFont(new Font("Dialog", Font.PLAIN, 19));
		f5.setColumns(15);
		GridBagConstraints gbc_f5 = new GridBagConstraints();
		gbc_f5.fill = GridBagConstraints.BOTH;
		gbc_f5.insets = new Insets(0, 0, 5, 0);
		gbc_f5.gridwidth = 3;
		gbc_f5.gridx = 2;
		gbc_f5.gridy = 7;
		getContentPane().add(f5, gbc_f5);

		JLabel l6 = new JLabel("이메일");
		l6.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_l6 = new GridBagConstraints();
		gbc_l6.anchor = GridBagConstraints.NORTH;
		gbc_l6.fill = GridBagConstraints.HORIZONTAL;
		gbc_l6.insets = new Insets(0, 0, 5, 5);
		gbc_l6.gridx = 1;
		gbc_l6.gridy = 8;
		getContentPane().add(l6, gbc_l6);
		// 이메일 입력
		JTextField f6 = new JTextField();
		f6.setFont(new Font("Dialog", Font.PLAIN, 19));
		f6.setColumns(20);
		GridBagConstraints gbc_f6 = new GridBagConstraints();
		gbc_f6.fill = GridBagConstraints.BOTH;
		gbc_f6.insets = new Insets(0, 0, 5, 0);
		gbc_f6.gridwidth = 3;
		gbc_f6.gridx = 2;
		gbc_f6.gridy = 8;
		getContentPane().add(f6, gbc_f6);

		JLabel l7 = new JLabel("주소");
		l7.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_l7 = new GridBagConstraints();
		gbc_l7.anchor = GridBagConstraints.NORTH;
		gbc_l7.fill = GridBagConstraints.HORIZONTAL;
		gbc_l7.insets = new Insets(0, 0, 5, 5);
		gbc_l7.gridx = 1;
		gbc_l7.gridy = 9;
		getContentPane().add(l7, gbc_l7);
		// 주소 입력
		JTextField f7 = new JTextField();
		f7.setFont(new Font("Dialog", Font.PLAIN, 19));
		f7.setColumns(30);
		GridBagConstraints gbc_f7 = new GridBagConstraints();
		gbc_f7.fill = GridBagConstraints.BOTH;
		gbc_f7.insets = new Insets(0, 0, 5, 0);
		gbc_f7.gridwidth = 3;
		gbc_f7.gridx = 2;
		gbc_f7.gridy = 9;
		getContentPane().add(f7, gbc_f7);

		UserDAO userDao = new UserDAO();

		JButton b1 = new JButton("확인");
		b1.setBackground(new Color(250, 250, 210));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// user: id, password, name, tel, email, address, addresstwo
				// 입력된 값들 가져오기
				String id = f1.getText();
				String pw = f2.getText();
				String name = f4.getText();
				String tel = f5.getText();
				String email = f6.getText();
				String address = f7.getText();
				// 주소2는 나중에 설정되므로 null로 넣음
				String addresstwo = null;

				// 입력된 값들 정규표현식과 일치 여부
				boolean regTel = Pattern.matches(telpattern, f5.getText());
				boolean regTel2 = Pattern.matches(telpattern2, f5.getText());
				boolean regEmail = Pattern.matches(emailpattern, f6.getText());

				if (!f2.getText().equals(f3.getText())) {
					// 비밀번호와 비밀번호확인이 다를 경우
					JOptionPane.showMessageDialog(null, "패스워드와 패스워드확인이 다릅니다.");
					f2.requestFocus();
				} else if(f1.getText().equals("") || f2.getText().equals("") || f3.getText().equals("") 
						|| f4.getText().equals("") || f5.getText().equals("") || f6.getText().equals("") 
						|| f7.getText().equals("")) {
					// 아이디, 비밀번호, 비밀번호확인, 연락처, 이메일, 주소가 공백일 경우
					JOptionPane.showMessageDialog(null, "공백없이 입력해주세요!");
				} else if (!regTel) {
					// 연락처 정규식과 맞지 않게 입력 시
					if (regTel2) {
						// 010-1234-1234라고 입력 시
						JOptionPane.showMessageDialog(null, "-를 빼고 입력해주세요!");
						f5.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 연락처를 다시 입력해주세요.");
						f5.requestFocus();
					}
				} else if (!regEmail) {
					// 이메일 정규식과 맞지 않게 입력 시
					JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 이메일을 다시 입력해주세요.");
					f6.requestFocus();
				} else {
					// uservo에 입력된 값 넣기
					UserVO bag = new UserVO();
					bag.setId(id);
					bag.setPassword(pw);
					bag.setName(name);
					bag.setTel(tel);
					bag.setEmail(email);
					bag.setAddress(address);
					bag.setAddresstwo(addresstwo);
					try {
						// db 생성
						userDao.create(bag);
						// 파일로 저장
						UserFile file = new UserFile(bag);
						JOptionPane.showMessageDialog(null, "회원가입 되셨습니다.");
					} catch (Exception e1) {
						System.out.println("user파일 저장하면서 에러");
						e1.printStackTrace();
					}
					// main으로 이동
					new Start();
					// 이동하면서 현재 창 비활성화
					setVisible(false);
				}

			}
		});
		b1.setFont(new Font("굴림", Font.PLAIN, 20));
		GridBagConstraints gbc_b1 = new GridBagConstraints();
		gbc_b1.anchor = GridBagConstraints.EAST;
		gbc_b1.fill = GridBagConstraints.VERTICAL;
		gbc_b1.insets = new Insets(0, 0, 0, 5);
		gbc_b1.gridwidth = 2;
		gbc_b1.gridx = 1;
		gbc_b1.gridy = 11;
		getContentPane().add(b1, gbc_b1);

		JButton b2 = new JButton("취소");
		b2.setBackground(new Color(250, 250, 210));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// start화면으로 이동
				new Start();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b2.setFont(new Font("굴림", Font.PLAIN, 20));
		GridBagConstraints gbc_b2 = new GridBagConstraints();
		gbc_b2.anchor = GridBagConstraints.WEST;
		gbc_b2.fill = GridBagConstraints.VERTICAL;
		gbc_b2.gridx = 4;
		gbc_b2.gridy = 11;
		getContentPane().add(b2, gbc_b2);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Register();
	}
}
