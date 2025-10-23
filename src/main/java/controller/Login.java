package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import po.Customer;
import po.service.impl.CustomerServiceImpl;
import util.CustomerFileIO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=2,17
	 */
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel_1.setBounds(12, -11, 426, 262);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("登入頁面");
		label.setBounds(26, 34, 70, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("帳號");
		label_1.setBounds(26, 76, 70, 15);
		panel_1.add(label_1);
		
		JLabel label_1_1 = new JLabel("密碼");
		label_1_1.setBounds(26, 118, 70, 15);
		panel_1.add(label_1_1);
		
		username = new JTextField();
		username.setText("test");
		username.setBounds(68, 74, 114, 19);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setText("test123");
		password.setColumns(10);
		password.setBounds(68, 116, 114, 19);
		panel_1.add(password);
		
		
		CustomerServiceImpl csi=new CustomerServiceImpl();
		JButton login = new JButton("登入");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 點擊登入後：
				 * 1.判斷此客戶帳號是不是已經在資料庫customer username
				 * 2.如果沒有 切換到註冊頁面
				 * 3.如果有 切換到購買頁面
				*/
				/*if member != null
						save member into a file
						login page
				else
					login error
				*/
				String Username=username.getText();
				String Password=password.getText();
				Customer customer=csi.login(Username, Password);
				if (customer!=null) {
					
					csi.saveCustomer(customer);
					//change to LoginSuccess page
					LoginSuccess success=new LoginSuccess();
					success.setVisible(true);
					dispose();
					
				}else {
					//change to LoginFailed page
					LoginFailed failed=new LoginFailed();
					failed.setVisible(true);
					dispose();
				}		
			}
		});
		login.setBounds(26, 161, 117, 25);
		panel_1.add(login);

	}
}
