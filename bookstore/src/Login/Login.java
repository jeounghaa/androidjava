package Login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DB.UserDAO;
import DB.UserVO;
import Main.Main;
import java.awt.Color;

public class Login extends JFrame{
	// 다른 화면에 넘길 데이터 static값으로 저장.
	public static String postadd;
	public static String username;
	public static String userid;

	public Login() {
		getContentPane().setBackground(new Color(95, 158, 160));
		setTitle("로그인");
		// 프레임1, 라벨2, 텍스트필드2
		JLabel l0 = new JLabel();
		l0.setBounds(50, 50, 150, 40);
		l0.setFont(new Font("굴림", Font.PLAIN, 30));
		JLabel l1 = new JLabel();
		l1.setFont(new Font("굴림", Font.PLAIN, 20));
		l1.setBounds(50, 150, 75, 30);
		JLabel l2 = new JLabel();
		l2.setFont(new Font("굴림", Font.PLAIN, 20));
		l2.setBounds(50, 200, 100, 30);
		JTextField t1 = new JTextField(10);
		t1.setFont(new Font("굴림", Font.PLAIN, 20));
		t1.setBounds(200, 150, 250, 30);
		JTextField t2 = new JTextField(10);
		t2.setFont(new Font("굴림", Font.PLAIN, 20));
		t2.setBounds(200, 200, 250, 30);
		// 로그인 버튼
		JButton b1 = new JButton();
		b1.setBackground(new Color(250, 250, 210));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pw = t2.getText();
				UserDAO userdao = new UserDAO();

				try {
					boolean result = userdao.login(id, pw);
					// 로그인 비교 부분
					if (result == true) {
						JOptionPane.showMessageDialog(null, id + "님 로그인되었습니다!");
						// 스테틱 변수에 고정적인 값을 저장
						// 다른부분에서도 로그인되어있는 id를 확인가능
						userid = id;

						try {
							ArrayList<UserVO> userlist = userdao.read(userid);
							UserVO userbag = userlist.get(0);
							// 스테틱 변수에 db에서 받아온 이름, 주소 저장
							postadd = userbag.getAddress();
							username = userbag.getName();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						// 메인창으로 이동
						new Main();
						// 이동하면서 현재 창 비활성화
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 다시 확인해주세요");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		b1.setFont(new Font("굴림", Font.PLAIN, 20));
		b1.setBounds(80, 300, 120, 60);
		// 회원가입 버튼 구현
		JButton b2 = new JButton();
		b2.setBackground(new Color(250, 250, 210));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원가입창으로 이동
				new Register();
				// 이동하면서 현재 창 비활성화
				setVisible(false);
			}
		});
		b2.setFont(new Font("굴림", Font.PLAIN, 20));
		b2.setBounds(240, 300, 160, 60);

		l0.setText("로그인");
		l1.setText("아이디");
		l2.setText("비밀번호");
		b1.setText("로그인");
		b2.setText("회원가입");

		getContentPane().setLayout(null);
		getContentPane().add(l0);
		getContentPane().add(l1);
		getContentPane().add(t1);
		getContentPane().add(l2);
		getContentPane().add(t2);
		getContentPane().add(b1);
		getContentPane().add(b2);

		setSize(500, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Login();

	}

}
