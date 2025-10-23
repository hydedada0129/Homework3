package controller;
//JFreeChart core
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

//Dataset for charts
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import po.Customer;
import po.Product;
import po.service.impl.OrderItemsServiceImpl;
import po.service.impl.PorderServiceImpl;
import po.service.impl.ProductServiceImpl;
import util.ChangeCalculator;
import util.CreatePorder_Id;
import util.CustomerFileIO;
import util.PoiExcel;
import util.StringHandler;
import util.createdOrderItem_Id;
import vo.ShoppingReportView;
import vo.service.impl.ViewServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTree;

public class ShoppingPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField mouse_textField;
	private JTextField speaker_textField;
	private JTextField tshirt_textField;
	private JTextField jean_textField;
	private JTextField LED_textField;
	private JTextField MarkCup_textField;
	private JTextField CoffeeBean_textField;
	private JTextField hyaeyeDrop_textField;
	private JTextField chocolate_textField;
	private JTextField eyedrop_textField;
	private JTextField codLiverOil_textField;
	private JTextField address_textField;
	private JTextField payCash_text;

	//Services:
	ProductServiceImpl psi;
	PorderServiceImpl osi;
	OrderItemsServiceImpl oisi;
	ViewServiceImpl vsi;
	
	//
    private int subtotal=0;
	private int total = 0;
	
	private String customerId;
	private String shippingAddr;

    private int Id;
    private int OiId;
    private String porder_id;
    private String order_item_id;
	
	//無線滑鼠成員：
	private String mouseProductname;
    private String mouseProductId;
    private int mouseUnitPrice;
    private int mouseQty;
    
    //bluetoothSpeaker
    private String bluetoothSpeakerProductname;
    private String bluetoothSpeakerProductId;
    private int bluetoothSpeakerUnitPrice;
    private int bluetoothSpeakerQty;
    
    private String tShirtProductname;
	private String tShirtProductId;
	private int tShirtUnitPrice;
    private int tShirtQty;

    private String jeanProductName;
    private String jeanProductId;
    private int jeanUnitPrice;
    private int jeanQty;

    private String LEDLightProductName;
    private String LEDLightProductId;
    private int LEDLightUnitPrice;
    private int LEDLightQty;

    private String markCupProductName;
    private String markCupProductId;
    private int markCupUnitPrice;
    private int markCupQty;

    private String coffeeBeanProductName;
    private String coffeeBeanProductId;
    private int coffeeBeanUnitPrice;
    private int coffeeBeanQty;

    private String chocolateProductName;
    private String chocolateProductId;
    private int chocolateUnitPrice;
    private int chocolateQty;

    private String codLiverOilProductName;
    private String codLiverOilProductId;
    private int codLiverOilUnitPrice;
    private int codLiverOilQty;

    private String eyeDropProductName;
    private String eyeDropProductId;
    private int eyeDropUnitPrice;
    private int eyeDropQty;

    private String hyaEyeDropProductName;
    private String hyaEyeDropProductId;
    private int hyaEyeDropUnitPrice;
    private int hyaEyeDropQty;

	private JTextField creditCard_textField;
	private JTextField expiredDate_textField;
	private JTextField cvc_textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingPage frame = new ShoppingPage();
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
	public ShoppingPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1512, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(12, 12, 378, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("168 批發網");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(12, 5, 354, 40);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 64, 378, 52);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel clock = new JLabel("");
		clock.setFont(new Font("Dialog", Font.BOLD, 14));
		clock.setBounds(12, 12, 354, 28);
		panel_1.add(clock);

		//timer
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("uuuu-MM-dd hh:mm:ss");
		Timer timer=new Timer(1000, e->clock.setText(LocalDateTime.now().format(formatter)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(392, 12, 414, 104);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel name = new JLabel("");
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setFont(new Font("Dialog", Font.BOLD, 16));
		name.setBounds(12, 12, 394, 80);
		panel_2.add(name);
		timer.start();
		
		//讀取customer file and name
		name.setText(CustomerFileIO.readCustomerToFile().getName()+" Welcome!");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 128, 378, 396);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		mouse_textField = new JTextField();
		mouse_textField.setText("0");
		mouse_textField.setBounds(83, 10, 114, 19);
		panel_3.add(mouse_textField);
		mouse_textField.setColumns(10);
		
		speaker_textField = new JTextField();
		speaker_textField.setText("0");
		speaker_textField.setColumns(10);
		speaker_textField.setBounds(83, 39, 114, 19);
		panel_3.add(speaker_textField);
		
		tshirt_textField = new JTextField();
		tshirt_textField.setText("0");
		tshirt_textField.setColumns(10);
		tshirt_textField.setBounds(83, 65, 114, 19);
		panel_3.add(tshirt_textField);
		
		jean_textField = new JTextField();
		jean_textField.setText("0");
		jean_textField.setColumns(10);
		jean_textField.setBounds(83, 94, 114, 19);
		panel_3.add(jean_textField);
		
		LED_textField = new JTextField();
		LED_textField.setText("0");
		LED_textField.setColumns(10);
		LED_textField.setBounds(83, 121, 114, 19);
		panel_3.add(LED_textField);
		
		MarkCup_textField = new JTextField();
		MarkCup_textField.setText("0");
		MarkCup_textField.setColumns(10);
		MarkCup_textField.setBounds(83, 146, 114, 19);
		panel_3.add(MarkCup_textField);
		
		CoffeeBean_textField = new JTextField();
		CoffeeBean_textField.setText("0");
		CoffeeBean_textField.setColumns(10);
		CoffeeBean_textField.setBounds(83, 175, 114, 19);
		panel_3.add(CoffeeBean_textField);
		
		hyaeyeDrop_textField = new JTextField();
		hyaeyeDrop_textField.setText("0");
		hyaeyeDrop_textField.setColumns(10);
		hyaeyeDrop_textField.setBounds(83, 281, 114, 19);
		panel_3.add(hyaeyeDrop_textField);
		
		eyedrop_textField = new JTextField();
		eyedrop_textField.setText("0");
		eyedrop_textField.setColumns(10);
		eyedrop_textField.setBounds(83, 254, 114, 19);
		panel_3.add(eyedrop_textField);
		
		codLiverOil_textField = new JTextField();
		codLiverOil_textField.setText("0");
		codLiverOil_textField.setColumns(10);
		codLiverOil_textField.setBounds(83, 227, 114, 19);
		panel_3.add(codLiverOil_textField);
		

		JCheckBox mouse = new JCheckBox("無線滑鼠");
		mouse.setBounds(216, 8, 129, 23);
		panel_3.add(mouse);

		JCheckBox bluetoothSpeaker = new JCheckBox("藍牙喇叭");
		bluetoothSpeaker.setBounds(216, 37, 129, 23);
		panel_3.add(bluetoothSpeaker);
		
		JCheckBox TShirt = new JCheckBox("純棉短袖T恤");
		TShirt.setBounds(216, 63, 129, 23);
		panel_3.add(TShirt);
		
		JCheckBox jean = new JCheckBox("牛仔褲");
		jean.setBounds(216, 92, 129, 23);
		panel_3.add(jean);
		
		JCheckBox LEDLight = new JCheckBox("LED檯燈");
		LEDLight.setBounds(216, 119, 129, 23);
		panel_3.add(LEDLight);
		
		JCheckBox markCup = new JCheckBox("陶瓷馬克杯");
		markCup.setBounds(216, 144, 129, 23);
		panel_3.add(markCup);
		
		JCheckBox coffeeBean = new JCheckBox("咖啡豆1公斤");
		coffeeBean.setBounds(216, 173, 129, 23);
		panel_3.add(coffeeBean);
		
		JCheckBox chocolate = new JCheckBox("手工巧克力");
		chocolate.setBounds(216, 198, 129, 23);
		panel_3.add(chocolate);
		
		JCheckBox codLiverOil = new JCheckBox("魚肝油");
		codLiverOil.setBounds(216, 225, 129, 23);
		panel_3.add(codLiverOil);
		
		JCheckBox eyeDrop = new JCheckBox("人工淚液");
		eyeDrop.setBounds(216, 252, 129, 23);
		panel_3.add(eyeDrop);
		
		JCheckBox hyaEyeDrop = new JCheckBox("玻尿酸人工淚液");
		hyaEyeDrop.setBounds(216, 279, 147, 23);
		panel_3.add(hyaEyeDrop);
		
		JLabel label_1 = new JLabel("數量");
		label_1.setBounds(12, 12, 70, 15);
		panel_3.add(label_1);
		
		JLabel label_1_1 = new JLabel("數量");
		label_1_1.setBounds(12, 41, 70, 15);
		panel_3.add(label_1_1);
		
		JLabel label_1_2 = new JLabel("數量");
		label_1_2.setBounds(12, 67, 70, 15);
		panel_3.add(label_1_2);
		
		JLabel label_1_3 = new JLabel("數量");
		label_1_3.setBounds(12, 96, 70, 15);
		panel_3.add(label_1_3);
		
		JLabel label_1_4 = new JLabel("數量");
		label_1_4.setBounds(12, 123, 70, 15);
		panel_3.add(label_1_4);
		
		JLabel label_1_5 = new JLabel("數量");
		label_1_5.setBounds(12, 148, 70, 15);
		panel_3.add(label_1_5);
		
		JLabel label_1_6 = new JLabel("數量");
		label_1_6.setBounds(12, 177, 70, 15);
		panel_3.add(label_1_6);
		
		JLabel label_1_7 = new JLabel("數量");
		label_1_7.setBounds(12, 202, 70, 15);
		panel_3.add(label_1_7);
		
		JLabel label_1_8 = new JLabel("數量");
		label_1_8.setBounds(12, 229, 70, 15);
		panel_3.add(label_1_8);
		
		JLabel label_1_9 = new JLabel("數量");
		label_1_9.setBounds(12, 256, 70, 15);
		panel_3.add(label_1_9);
		
		JLabel label_1_10 = new JLabel("數量");
		label_1_10.setBounds(12, 283, 70, 15);
		panel_3.add(label_1_10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(620, 129, 187, 396);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_2 = new JLabel("輸入付款現金額");
		label_2.setBounds(15, 140, 97, 15);
		panel_4.add(label_2);
		
		payCash_text = new JTextField();
		payCash_text.setBounds(15, 167, 114, 19);
		panel_4.add(payCash_text);
		payCash_text.setColumns(10);
		
		JLabel label_3 = new JLabel("找零：");
		label_3.setBounds(15, 235, 41, 15);
		panel_4.add(label_3);
		
		JTextArea change_textArea = new JTextArea();
		change_textArea.setBounds(12, 262, 168, 122);
		panel_4.add(change_textArea);
		
		JComboBox paymentMethodcomboBox = new JComboBox();
		paymentMethodcomboBox.setModel(new DefaultComboBoxModel(new String[] {"現金", "信用卡", "比特幣", "物品交換"}));
		paymentMethodcomboBox.setBounds(12, 34, 160, 24);
		panel_4.add(paymentMethodcomboBox);
		
		JLabel label_6 = new JLabel("選擇付款方式...(趕工中)");
		label_6.setBounds(15, 12, 157, 15);
		panel_4.add(label_6);
		
		JLabel addr_label = new JLabel("寄件地址");
		addr_label.setBounds(12, 314, 70, 15);
		panel_3.add(addr_label);
		
		address_textField = new JTextField();
		address_textField.setBounds(83, 312, 282, 19);
		panel_3.add(address_textField);
		address_textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(392, 129, 226, 394);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_4 = new JLabel("購物車");
		label_4.setFont(new Font("Dialog", Font.BOLD, 16));
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setBounds(13, 13, 55, 15);
		panel_5.add(label_4);
		
		JButton payCash_button = new JButton("付錢");
		payCash_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change_textArea.setText(new ChangeCalculator().cal(payCash_text.getText(), total));
			}
		});
		payCash_button.setBounds(12, 198, 117, 25);
		panel_4.add(payCash_button);
		
		JButton totalCal_btn = new JButton("結帳計算");
		totalCal_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				osi=new PorderServiceImpl();
				String porder_id=osi.findNextId();
				System.out.println("先建立porder id 給order_item insert: "+porder_id);
				
				if ((mouse.isSelected()) && (mouse_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int mouseSubTotal=mouseQty*mouseUnitPrice;
					System.out.println("order item id: "+order_item_id);
					oisi.add(order_item_id, porder_id, mouseQty, mouseProductId, mouseSubTotal, mouseUnitPrice);	
					
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\tmouse小記： "+ mouseSubTotal);
				}
				if ((bluetoothSpeaker.isSelected()) && (speaker_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int blueSubtotal=bluetoothSpeakerQty*bluetoothSpeakerUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, bluetoothSpeakerQty, bluetoothSpeakerProductId, blueSubtotal, bluetoothSpeakerUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\tbluetooth小記： "+ blueSubtotal);
				}
				if ((TShirt.isSelected()) && (tshirt_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int tshirtSub=tShirtQty*tShirtUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, tShirtQty, tShirtProductId, tshirtSub, tShirtUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\ttshit小記： "+ tshirtSub);
				}
//			    private String jeanProductId;jeanSub
//			    private int jeanUnitPrice;jean_textField
//			    private int jeanQty;jean
				if ((jean.isSelected()) && (jean_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int jeanSub=jeanQty*jeanUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, jeanQty, jeanProductId, jeanSub, jeanUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\tjean小記： "+ jeanSub);
				}
			    //LEDLight, LED_textField, 
//			    private String LEDLightProductId;
//			    private int LEDLightUnitPrice;
//			    private int LEDLightQty;
				if ((LEDLight.isSelected()) && (LED_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int LedSub=LEDLightQty*LEDLightUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, LEDLightQty, LEDLightProductId, LedSub, LEDLightUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\tLEDLight小記： "+ LedSub);
				}
				//markCup, MarkCup_textField, markSub
//			    private String markCupProductId;
//			    private int markCupUnitPrice;
//			    private int markCupQty;
				if ((markCup.isSelected()) && (MarkCup_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int markSub=markCupQty*markCupUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, markCupQty, markCupProductId, markSub, markCupUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\tmarkCup小記： "+ markSub);
				}
				//coffeeBean, CoffeeBean_textField, coffeeSub
//			    private String coffeeBeanProductId;
//			    private int coffeeBeanUnitPrice;
//			    private int coffeeBeanQty;
				if ((coffeeBean.isSelected()) && (CoffeeBean_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int coffeeSub=coffeeBeanQty*coffeeBeanUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, coffeeBeanQty, coffeeBeanProductId, coffeeSub, coffeeBeanUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\tcoffeeBean小記： "+ coffeeSub);
				}
				//chocolate, chocolate_textField, choSub
//			    private String chocolateProductId;
//			    private int chocolateUnitPrice;
//			    private int chocolateQty;
				if ((chocolate.isSelected()) && (chocolate_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int choSub=chocolateQty*chocolateUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, chocolateQty, chocolateProductId, choSub, chocolateUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\tchocolate小記： "+ choSub);
				}
				//codLiverOil, codLiverOil_textField, codSub
//			    private String codLiverOilProductId;
//			    private int codLiverOilUnitPrice;
//			    private int codLiverOilQty;
				if ((codLiverOil.isSelected()) && (codLiverOil_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int codSub=codLiverOilQty*codLiverOilUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, codLiverOilQty, codLiverOilProductId, codSub, codLiverOilUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\tcodLiverOil小記： "+ codSub);
				}
				//eyeDrop, eyedrop_textField, eyeDropSub
//			    private String eyeDropProductId;
//			    private int eyeDropUnitPrice;
//			    private int eyeDropQty;
				if ((eyeDrop.isSelected()) && (eyedrop_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int eyeDropSub=eyeDropQty*eyeDropUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, eyeDropQty, eyeDropProductId, eyeDropSub, eyeDropUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\teyeDrop小記： "+ eyeDropSub);
				}
				//hyaEyeDrop, hyaeyeDrop_textField, hyaSub
//			    private String hyaEyeDropProductId;
//			    private int hyaEyeDropUnitPrice;
//			    private int hyaEyeDropQty;
				if ((hyaEyeDrop.isSelected()) && (hyaeyeDrop_textField.getText() != "0")) {
					//porder 
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					
					oisi=new OrderItemsServiceImpl();		
					String order_item_id=oisi.findNewestOiId();
					int hyaSub=hyaEyeDropQty*hyaEyeDropUnitPrice;
					System.out.println(order_item_id);
					oisi.add(order_item_id, porder_id, hyaEyeDropQty, hyaEyeDropProductId, hyaSub, hyaEyeDropUnitPrice);	
//					osi=new PorderServiceImpl();
////					String porder_id=osi.findNextId();
//					osi.add(porder_id, customerId, shippingAddr, total);
					System.out.println("CRUD porder, order_items table 成功");
					System.out.println("總金額 "+ total+ "\thyaEyeDrop小記： "+ hyaSub);
				}
				osi=new PorderServiceImpl();
				osi.add(porder_id, customerId, shippingAddr, total);
				System.out.println("porder_id: "+porder_id);
				
			}
			
			//=========================================================================
		});
		totalCal_btn.setBounds(102, 357, 117, 25);
		panel_5.add(totalCal_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 40, 201, 305);
		panel_5.add(scrollPane);
		
		JTextArea shoppingCart_textArea = new JTextArea();
		scrollPane.setViewportView(shoppingCart_textArea);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(392, 535, 419, 30);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JButton excel_btn = new JButton("匯出Excel");
		excel_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PoiExcel poi=new PoiExcel();
				String file_name="excel_report.xls";
				String sheet_name="shopping_report";
				poi.createExcelFile(file_name, sheet_name);
				List<ShoppingReportView> list=new ArrayList();	
				vsi=new ViewServiceImpl();
				list=vsi.findtView();
				ShoppingReportView singleObj=list.stream().findFirst().orElse(null);
				List<ShoppingReportView> listForOne=new ArrayList();
				listForOne.add(singleObj);
				poi.inserValue(file_name, sheet_name, listForOne);
			}
		});
		excel_btn.setBounds(290, 0, 117, 25);
		panel_6.add(excel_btn);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(819, 128, 238, 437);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_5 = new JLabel("掃描信用卡照片...(趕工中)");
		label_5.setBounds(12, 39, 214, 15);
		panel_7.add(label_5);
		
		JButton creditCardPay_button = new JButton("信用卡付款");
		creditCardPay_button.setBounds(12, 191, 117, 25);
		panel_7.add(creditCardPay_button);
		
		creditCard_textField = new JTextField();
		creditCard_textField.setBounds(61, 104, 165, 19);
		panel_7.add(creditCard_textField);
		creditCard_textField.setText("xxxx-xxxx-xxxx-xxxx");
		creditCard_textField.setColumns(10);
		
		JLabel label_7 = new JLabel("信用卡付款");
		label_7.setBounds(12, 12, 70, 15);
		panel_7.add(label_7);
		
		expiredDate_textField = new JTextField();
		expiredDate_textField.setText("xx/xx");
		expiredDate_textField.setBounds(61, 135, 114, 19);
		panel_7.add(expiredDate_textField);
		expiredDate_textField.setColumns(10);
		
		JLabel label_8 = new JLabel("到期日");
		label_8.setBounds(12, 137, 70, 15);
		panel_7.add(label_8);
		
		JLabel label_9 = new JLabel("卡號");
		label_9.setBounds(12, 110, 31, 15);
		panel_7.add(label_9);
		
		JLabel label_8_1 = new JLabel("CVC");
		label_8_1.setBounds(12, 164, 31, 15);
		panel_7.add(label_8_1);
		
		cvc_textField = new JTextField();
		cvc_textField.setText("xxx");
		cvc_textField.setColumns(10);
		cvc_textField.setBounds(61, 160, 114, 19);
		panel_7.add(cvc_textField);
		
		JButton uploadPic_button_1 = new JButton("上傳照片");
		uploadPic_button_1.setBounds(128, 67, 98, 25);
		panel_7.add(uploadPic_button_1);
		
		JButton takePic_button_1_1 = new JButton("拍照");
		takePic_button_1_1.setBounds(12, 66, 91, 25);
		panel_7.add(takePic_button_1_1);
		
		JLabel label_10 = new JLabel("手動輸入");
		label_10.setBounds(176, 164, 50, 15);
		panel_7.add(label_10);
		
		JButton totalCalculateBtn = new JButton("加入購物車");
		totalCalculateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				total=0;
				String cartString="";
				
				//"無線滑鼠 mouse" 點擊後 回傳兩個: product id, product unit price
				if (mouse.isSelected()){
					List<Product> list=new ArrayList();
					psi = new ProductServiceImpl();
					list=psi.findByProductname(mouse.getText());	//get a list
					for(Product obj:list) {
						//add into porder and order_items tables first
						
						//params for CRUD:C
						mouseProductname=obj.getName();
						mouseProductId=obj.getProduct_id();
						mouseUnitPrice=obj.getUnit_price();
						mouseQty=Integer.parseInt(mouse_textField.getText());
						customerId=CustomerFileIO.readCustomerToFile().getCustomerid();
						shippingAddr=address_textField.getText();
						subtotal=mouseQty*mouseUnitPrice;
						total+=subtotal;

						//test
						System.out.println("產品名稱："+mouseProductname + "\n" + "product id:" + mouseProductId + 
								 "\n unit price: "+mouseUnitPrice+"\n 數量："+mouseQty+
								"\n 小計："+subtotal);
						System.out.println("customer id: "+customerId+"\t"+shippingAddr+"\t total:"+total);
						
						//加入cart, 還沒有存進資料庫
						cartString=cartString+"產品名稱："+mouseProductname + 
								"\nproduct id:" + mouseProductId + 
								 "\nunit price: "+ mouseUnitPrice+
								 "\n數量："+mouseQty+
								"\n小計："+subtotal + "\n";
						shoppingCart_textArea.setText(cartString);
						
					}
				}
				
				//點擊後 回傳兩個: product id, product unit price
				if (bluetoothSpeaker.isSelected()){
					List<Product> list=new ArrayList();
					psi = new ProductServiceImpl();
					list=psi.findByProductname(bluetoothSpeaker.getText());	//get a list
					for(Product obj:list) {
						//add into porder and order_items tables first
						
						//params for CRUD:C
						bluetoothSpeakerProductname=obj.getName();
						bluetoothSpeakerProductId=obj.getProduct_id();
						bluetoothSpeakerUnitPrice=obj.getUnit_price();
						bluetoothSpeakerQty=Integer.parseInt(speaker_textField.getText());
						customerId=CustomerFileIO.readCustomerToFile().getCustomerid();
						shippingAddr=address_textField.getText();
						subtotal=bluetoothSpeakerQty*bluetoothSpeakerUnitPrice;
						total+=subtotal;

						//test
						System.out.println("產品名稱："+bluetoothSpeakerProductname + "\n" + 
								"bluetoothSpeakerProductId id:" + mouseProductId + 
								 "\n unit price: "+bluetoothSpeakerUnitPrice+
								 "\n 數量："+bluetoothSpeakerQty+
								"\n 小計："+subtotal);
						System.out.println("customer id: "+customerId+"\t"+shippingAddr+"\t total:"+total);
						
						//加入cart, 還沒有存進資料庫
						cartString=cartString+"產品名稱："+bluetoothSpeakerProductname + 
								"\nproduct id:" + bluetoothSpeakerProductId + 
								 "\nunit price: "+ bluetoothSpeakerUnitPrice+
								 "\n數量："+bluetoothSpeakerQty+
								"\n小計："+subtotal + "\n";
						shoppingCart_textArea.setText(cartString);
						
					}
				}
				
				if (TShirt.isSelected()) {
				    List<Product> list = new ArrayList<>();
				    psi = new ProductServiceImpl();
				    list = psi.findByProductname(TShirt.getText()); // get a list
				    
				    for (Product obj : list) {
				        // add into porder and order_items tables first

				        // params for CRUD:C
				        tShirtProductname = obj.getName();
				        tShirtProductId = obj.getProduct_id();
				        tShirtUnitPrice = obj.getUnit_price();
				        tShirtQty = Integer.parseInt(tshirt_textField.getText());
				        customerId = CustomerFileIO.readCustomerToFile().getCustomerid();
				        shippingAddr = address_textField.getText();

				        // subtotal calculation
				        subtotal = tShirtQty * tShirtUnitPrice;
				        total += subtotal;

				        // 🧾 test print
				        System.out.println("產品名稱：" + tShirtProductname + 
				                           "\n產品 ID：" + tShirtProductId +
				                           "\n單價：" + tShirtUnitPrice +
				                           "\n數量：" + tShirtQty +
				                           "\n小計：" + subtotal);
				        System.out.println("客戶 ID：" + customerId + 
				                           "\t送貨地址：" + shippingAddr + 
				                           "\t目前總計：" + total);
				        
				        // add to cart (not saved to DB yet)
				        cartString = cartString +
				                "產品名稱：" + tShirtProductname + 
				                "\n產品 ID：" + tShirtProductId + 
				                "\n單價：" + tShirtUnitPrice + 
				                "\n數量：" + tShirtQty + 
				                "\n小計：" + subtotal + "\n\n";
				        shoppingCart_textArea.setText(cartString);
				    }
				}

				if (jean.isSelected()) {
				    List<Product> list = new ArrayList<>();
				    psi = new ProductServiceImpl();
				    list = psi.findByProductname(jean.getText());

				    for (Product obj : list) {
				        jeanProductName = obj.getName();
				        jeanProductId = obj.getProduct_id();
				        jeanUnitPrice = obj.getUnit_price();
				        jeanQty = Integer.parseInt(jean_textField.getText());
				        customerId = CustomerFileIO.readCustomerToFile().getCustomerid();
				        shippingAddr = address_textField.getText();

				        subtotal = jeanQty * jeanUnitPrice;
				        total += subtotal;

				        System.out.println("產品名稱：" + jeanProductName +
				                           "\n產品 ID：" + jeanProductId +
				                           "\n單價：" + jeanUnitPrice +
				                           "\n數量：" + jeanQty +
				                           "\n小計：" + subtotal);
				        System.out.println("客戶 ID：" + customerId +
				                           "\t送貨地址：" + shippingAddr +
				                           "\t目前總計：" + total);

				        cartString += "產品名稱：" + jeanProductName +
				                      "\n產品 ID：" + jeanProductId +
				                      "\n單價：" + jeanUnitPrice +
				                      "\n數量：" + jeanQty +
				                      "\n小計：" + subtotal + "\n\n";

				        shoppingCart_textArea.setText(cartString);
				    }
				}
				if (LEDLight.isSelected()) {
				    List<Product> list = new ArrayList<>();
				    psi = new ProductServiceImpl();
				    list = psi.findByProductname(LEDLight.getText());

				    for (Product obj : list) {
				        LEDLightProductName = obj.getName();
				        LEDLightProductId = obj.getProduct_id();
				        LEDLightUnitPrice = obj.getUnit_price();
				        LEDLightQty = Integer.parseInt(LED_textField.getText());
				        customerId = CustomerFileIO.readCustomerToFile().getCustomerid();
				        shippingAddr = address_textField.getText();

				        subtotal = LEDLightQty * LEDLightUnitPrice;
				        total += subtotal;

				        System.out.println("產品名稱：" + LEDLightProductName +
				                           "\n產品 ID：" + LEDLightProductId +
				                           "\n單價：" + LEDLightUnitPrice +
				                           "\n數量：" + LEDLightQty +
				                           "\n小計：" + subtotal);
				        System.out.println("客戶 ID：" + customerId +
				                           "\t送貨地址：" + shippingAddr +
				                           "\t目前總計：" + total);

				        cartString += "產品名稱：" + LEDLightProductName +
				                      "\n產品 ID：" + LEDLightProductId +
				                      "\n單價：" + LEDLightUnitPrice +
				                      "\n數量：" + LEDLightQty +
				                      "\n小計：" + subtotal + "\n\n";

				        shoppingCart_textArea.setText(cartString);
				    }
				}

				if (markCup.isSelected()) {
				    List<Product> list = new ArrayList<>();
				    psi = new ProductServiceImpl();
				    list = psi.findByProductname(markCup.getText());

				    for (Product obj : list) {
				        markCupProductName = obj.getName();
				        markCupProductId = obj.getProduct_id();
				        markCupUnitPrice = obj.getUnit_price();
				        markCupQty = Integer.parseInt(MarkCup_textField.getText());
				        customerId = CustomerFileIO.readCustomerToFile().getCustomerid();
				        shippingAddr = address_textField.getText();

				        subtotal = markCupQty * markCupUnitPrice;
				        total += subtotal;

				        System.out.println("產品名稱：" + markCupProductName +
				                           "\n產品 ID：" + markCupProductId +
				                           "\n單價：" + markCupUnitPrice +
				                           "\n數量：" + markCupQty +
				                           "\n小計：" + subtotal);
				        System.out.println("客戶 ID：" + customerId +
				                           "\t送貨地址：" + shippingAddr +
				                           "\t目前總計：" + total);

				        cartString += "產品名稱：" + markCupProductName +
				                      "\n產品 ID：" + markCupProductId +
				                      "\n單價：" + markCupUnitPrice +
				                      "\n數量：" + markCupQty +
				                      "\n小計：" + subtotal + "\n\n";

				        shoppingCart_textArea.setText(cartString);
				    }
				}

				if (coffeeBean.isSelected()) {
				    List<Product> list = new ArrayList<>();
				    psi = new ProductServiceImpl();
				    list = psi.findByProductname(coffeeBean.getText());

				    for (Product obj : list) {
				        coffeeBeanProductName = obj.getName();
				        coffeeBeanProductId = obj.getProduct_id();
				        coffeeBeanUnitPrice = obj.getUnit_price();
				        coffeeBeanQty = Integer.parseInt(CoffeeBean_textField.getText());
				        customerId = CustomerFileIO.readCustomerToFile().getCustomerid();
				        shippingAddr = address_textField.getText();

				        subtotal = coffeeBeanQty * coffeeBeanUnitPrice;
				        total += subtotal;

				        System.out.println("產品名稱：" + coffeeBeanProductName +
				                           "\n產品 ID：" + coffeeBeanProductId +
				                           "\n單價：" + coffeeBeanUnitPrice +
				                           "\n數量：" + coffeeBeanQty +
				                           "\n小計：" + subtotal);
				        System.out.println("客戶 ID：" + customerId +
				                           "\t送貨地址：" + shippingAddr +
				                           "\t目前總計：" + total);

				        cartString += "產品名稱：" + coffeeBeanProductName +
				                      "\n產品 ID：" + coffeeBeanProductId +
				                      "\n單價：" + coffeeBeanUnitPrice +
				                      "\n數量：" + coffeeBeanQty +
				                      "\n小計：" + subtotal + "\n\n";

				        shoppingCart_textArea.setText(cartString);
				    }
				}

				if (chocolate.isSelected()) {
				    List<Product> list = new ArrayList<>();
				    psi = new ProductServiceImpl();
				    list = psi.findByProductname(chocolate.getText());

				    for (Product obj : list) {
				        chocolateProductName = obj.getName();
				        chocolateProductId = obj.getProduct_id();
				        chocolateUnitPrice = obj.getUnit_price();
				        chocolateQty = Integer.parseInt(chocolate_textField.getText());
				        customerId = CustomerFileIO.readCustomerToFile().getCustomerid();
				        shippingAddr = address_textField.getText();

				        subtotal = chocolateQty * chocolateUnitPrice;
				        total += subtotal;

				        System.out.println("產品名稱：" + chocolateProductName +
				                           "\n產品 ID：" + chocolateProductId +
				                           "\n單價：" + chocolateUnitPrice +
				                           "\n數量：" + chocolateQty +
				                           "\n小計：" + subtotal);
				        System.out.println("客戶 ID：" + customerId +
				                           "\t送貨地址：" + shippingAddr +
				                           "\t目前總計：" + total);

				        cartString += "產品名稱：" + chocolateProductName +
				                      "\n產品 ID：" + chocolateProductId +
				                      "\n單價：" + chocolateUnitPrice +
				                      "\n數量：" + chocolateQty +
				                      "\n小計：" + subtotal + "\n\n";

				        shoppingCart_textArea.setText(cartString);
				    }
				}
				if (codLiverOil.isSelected()) {
				    List<Product> list = new ArrayList<>();
				    psi = new ProductServiceImpl();
				    list = psi.findByProductname(codLiverOil.getText());

				    for (Product obj : list) {
				        codLiverOilProductName = obj.getName();
				        codLiverOilProductId = obj.getProduct_id();
				        codLiverOilUnitPrice = obj.getUnit_price();
				        codLiverOilQty = Integer.parseInt(codLiverOil_textField.getText());
				        customerId = CustomerFileIO.readCustomerToFile().getCustomerid();
				        shippingAddr = address_textField.getText();

				        subtotal = codLiverOilQty * codLiverOilUnitPrice;
				        total += subtotal;

				        System.out.println("產品名稱：" + codLiverOilProductName +
				                           "\n產品 ID：" + codLiverOilProductId +
				                           "\n單價：" + codLiverOilUnitPrice +
				                           "\n數量：" + codLiverOilQty +
				                           "\n小計：" + subtotal);
				        System.out.println("客戶 ID：" + customerId +
				                           "\t送貨地址：" + shippingAddr +
				                           "\t目前總計：" + total);

				        cartString += "產品名稱：" + codLiverOilProductName +
				                      "\n產品 ID：" + codLiverOilProductId +
				                      "\n單價：" + codLiverOilUnitPrice +
				                      "\n數量：" + codLiverOilQty +
				                      "\n小計：" + subtotal + "\n\n";

				        shoppingCart_textArea.setText(cartString);
				    }
				}

				if (eyeDrop.isSelected()) {
				    List<Product> list = new ArrayList<>();
				    psi = new ProductServiceImpl();
				    list = psi.findByProductname(eyeDrop.getText());

				    for (Product obj : list) {
				        eyeDropProductName = obj.getName();
				        eyeDropProductId = obj.getProduct_id();
				        eyeDropUnitPrice = obj.getUnit_price();
				        eyeDropQty = Integer.parseInt(eyedrop_textField.getText());
				        customerId = CustomerFileIO.readCustomerToFile().getCustomerid();
				        shippingAddr = address_textField.getText();

				        subtotal = eyeDropQty * eyeDropUnitPrice;
				        total += subtotal;

				        System.out.println("產品名稱：" + eyeDropProductName +
				                           "\n產品 ID：" + eyeDropProductId +
				                           "\n單價：" + eyeDropUnitPrice +
				                           "\n數量：" + eyeDropQty +
				                           "\n小計：" + subtotal);
				        System.out.println("客戶 ID：" + customerId +
				                           "\t送貨地址：" + shippingAddr +
				                           "\t目前總計：" + total);

				        cartString += "產品名稱：" + eyeDropProductName +
				                      "\n產品 ID：" + eyeDropProductId +
				                      "\n單價：" + eyeDropUnitPrice +
				                      "\n數量：" + eyeDropQty +
				                      "\n小計：" + subtotal + "\n\n";

				        shoppingCart_textArea.setText(cartString);
				    }
				}
				if (hyaEyeDrop.isSelected()) {
				    List<Product> list = new ArrayList<>();
				    psi = new ProductServiceImpl();
				    list = psi.findByProductname(hyaEyeDrop.getText());

				    for (Product obj : list) {
				        hyaEyeDropProductName = obj.getName();
				        hyaEyeDropProductId = obj.getProduct_id();
				        hyaEyeDropUnitPrice = obj.getUnit_price();
				        hyaEyeDropQty = Integer.parseInt(hyaeyeDrop_textField.getText());
				        customerId = CustomerFileIO.readCustomerToFile().getCustomerid();
				        shippingAddr = address_textField.getText();

				        subtotal = hyaEyeDropQty * hyaEyeDropUnitPrice;
				        total += subtotal;

				        System.out.println("產品名稱：" + hyaEyeDropProductName +
				                           "\n產品 ID：" + hyaEyeDropProductId +
				                           "\n單價：" + hyaEyeDropUnitPrice +
				                           "\n數量：" + hyaEyeDropQty +
				                           "\n小計：" + subtotal);
				        System.out.println("客戶 ID：" + customerId +
				                           "\t送貨地址：" + shippingAddr +
				                           "\t目前總計：" + total);

				        cartString += "產品名稱：" + hyaEyeDropProductName +
				                      "\n產品 ID：" + hyaEyeDropProductId +
				                      "\n單價：" + hyaEyeDropUnitPrice +
				                      "\n數量：" + hyaEyeDropQty +
				                      "\n小計：" + subtotal + "\n\n";

				        shoppingCart_textArea.setText(cartString);
				    }
				}

				cartString=cartString+"總金額： "+total;
		        shoppingCart_textArea.setText(cartString);

			}
		});
		totalCalculateBtn.setBounds(83, 343, 117, 25);
		panel_3.add(totalCalculateBtn);
		
		chocolate_textField = new JTextField();
		chocolate_textField.setBounds(83, 200, 114, 19);
		panel_3.add(chocolate_textField);
		chocolate_textField.setText("0");
		chocolate_textField.setColumns(10);
		
		JButton button_1 = new JButton("清除選項");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Component cp:panel_3.getComponents()) {
					if(cp instanceof JCheckBox) {//判斷物件
						((JCheckBox) cp).setSelected(false);
						
					}
				}
			}
		});
		button_1.setBounds(249, 343, 117, 25);
		panel_3.add(button_1);
		
		JButton button = new JButton("關閉視窗");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		button.setBounds(940, 91, 117, 25);
		contentPane.add(button);
		
		JPanel panel_for_chart = new JPanel();
		panel_for_chart.setBounds(1069, 129, 431, 395);
		contentPane.add(panel_for_chart);
		panel_for_chart.setLayout(null);
		
		List<ShoppingReportView> viewList2=new ArrayList(); 
		ViewServiceImpl vsi=new ViewServiceImpl();
		viewList2=vsi.findtView();

		
		JButton chart_btn = new JButton("銷售報表");
		chart_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultPieDataset dataset=new DefaultPieDataset();
				
				List<ShoppingReportView> viewList2=new ArrayList(); 
				ViewServiceImpl vsi=new ViewServiceImpl();
				viewList2=vsi.findtView();
				for(ShoppingReportView obj:viewList2) {
					dataset.setValue(obj.getProduct_name(), obj.getQty());
					
					
				}
//				dataset.setValue("Apple", 10);
//				dataset.setValue("Orange", 2);
//				dataset.setValue("Apple", 100);

				
				
				JFreeChart pieChart=ChartFactory.createPieChart(
						"fruit sales",
						dataset,
						true,
						true,
						false
				);
				
				ChartPanel chartPanel=new ChartPanel(pieChart);
				panel_for_chart.setLayout(new BorderLayout());
				panel_for_chart.add(chartPanel);
			}
		});
		chart_btn.setBounds(1071, 91, 117, 25);
		contentPane.add(chart_btn);
	
	}
}
