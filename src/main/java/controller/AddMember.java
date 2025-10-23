package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import po.Customer;
import po.service.impl.CustomerServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel p;
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JTextField companyname;
	private JTextField phone;
	private JTextField address;
	private JTextField email;
	private CustomerServiceImpl csi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 497);
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel label = new JLabel("會員註冊");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(208, 0, 88, 35);
		p.add(label);
		
		JLabel label_username = new JLabel("帳號名稱");
		label_username.setBounds(39, 90, 70, 15);
		p.add(label_username);
		
		JLabel label_password = new JLabel("密碼");
		label_password.setBounds(39, 138, 70, 15);
		p.add(label_password);
		
		JLabel label_name = new JLabel("會員姓名");
		label_name.setBounds(39, 185, 70, 15);
		p.add(label_name);
		
		JLabel label_companyname = new JLabel("公司名稱");
		label_companyname.setBounds(39, 234, 70, 15);
		p.add(label_companyname);
		
		JLabel label_phone = new JLabel("手機電話");
		label_phone.setBounds(39, 276, 70, 15);
		p.add(label_phone);
		
		JLabel label_address = new JLabel("地址");
		label_address.setBounds(39, 319, 70, 15);
		p.add(label_address);
		
		JLabel label_email = new JLabel("E-mail");
		label_email.setBounds(39, 362, 70, 15);
		p.add(label_email);
		
		username = new JTextField();
		username.setBounds(127, 88, 169, 19);
		p.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(127, 136, 169, 19);
		p.add(password);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(127, 183, 169, 19);
		p.add(name);
		
		companyname = new JTextField();
		companyname.setColumns(10);
		companyname.setBounds(127, 232, 169, 19);
		p.add(companyname);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(127, 274, 169, 19);
		p.add(phone);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(127, 317, 169, 19);
		p.add(address);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(127, 360, 169, 19);
		p.add(email);
	
		JButton button = new JButton("註冊送出");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerServiceImpl csi=new CustomerServiceImpl();
				String Username=username.getText();
				String Password=password.getText();
				String Name=name.getText();
				String Companyname=companyname.getText();
				String Phone=phone.getText();
				String Address=address.getText();				 
				String Email=email.getText();
				String Customerid=csi.findNextId();
				System.out.println("TEST:"+Customerid);
				//建立Customer物件
	//			Customer customer=new Customer();
				
				//add member
				Customer customer=new Customer(Customerid, Username,Password,
												Name,Companyname,Phone,
												Address,Email);
				csi.addCustomer(customer);
//				csi.updateForCustomerIdAndTime(csi.findByUsernameForId(customer));
				
				/* 之後做customer's 'id' 超出範圍exception
				int Id=csi.findById(customer);
				System.out.println("find by id test"+Id);
				*/
				
				AddMemberSuccess success=new AddMemberSuccess();
				success.setVisible(true);
				dispose();
			}
		});
		button.setBounds(371, 392, 117, 25);
		p.add(button);

	}
}
