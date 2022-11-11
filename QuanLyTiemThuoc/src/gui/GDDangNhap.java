package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.DangNhap;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GDDangNhap extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDDangNhap frame = new GDDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	public GDDangNhap() {
		
		setTitle("GIAO DIỆN ĐĂNG NHẬP");
		setBounds(100, 100, 636, 401);
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel pnChinh = new JPanel();
		pnChinh.setBackground(new Color(46, 139, 87));
		pnChinh.setBounds(0, 0, 620, 362);
		contentPane.add(pnChinh);
		pnChinh.setLayout(null);
		
		JPanel pnHinh = new JPanel();
		pnHinh.setBounds(0, 0, 273, 362);
		pnChinh.add(pnHinh);
		pnHinh.setLayout(null);
		
		JLabel lblHinh = new JLabel("");
		lblHinh.setBounds(0, 0, 282, 362);
		pnHinh.add(lblHinh);
		Image img = new ImageIcon(this.getClass().getResource("/img/chuthapdo.jpg")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		lblHinh.setIcon(new ImageIcon(img));
		lblHinh.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTaiKhoan = new JLabel("Tài khoản :");
		lblTaiKhoan.setForeground(new Color(255, 255, 0));
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTaiKhoan.setBounds(292, 100, 126, 32);
		pnChinh.add(lblTaiKhoan);
		Image img1 = new ImageIcon(this.getClass().getResource("/img/taikhoan.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblTaiKhoan.setIcon(new ImageIcon(img1));
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(428, 102, 168, 26);
		txtTaiKhoan.setText("3T");
		pnChinh.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu :");
		lblMatKhau.setForeground(new Color(255, 255, 0));
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatKhau.setBounds(292, 147, 126, 32);
		pnChinh.add(lblMatKhau);
		Image img2 = new ImageIcon(this.getClass().getResource("/img/matkhau.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblMatKhau.setIcon(new ImageIcon(img2));
		lblMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(428, 149, 168, 26);
		txtMatKhau.setText("123456789");
		pnChinh.add(txtMatKhau);
		
		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setBackground(new Color(255, 192, 203));
		btnDangNhap.setForeground(new Color(0, 0, 128));
		btnDangNhap.setToolTipText("Bấm Alt + D");
		btnDangNhap.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnDangNhap)) {
					DangNhap dn = new DangNhap();
					if(!(dn.getTaikhoan().equals(txtTaiKhoan.getText()) && dn.getMatKhau().equals(txtMatKhau.getText()))) {
						JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu !!! Vui lòng nhập lại");
						txtMatKhau.setText("");
						txtTaiKhoan.requestFocus();
					}
					else {
						new GDChinh().setVisible(true);
						dispose();
					}
				}
				
			}
		});

		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDangNhap.setBounds(447, 202, 134, 38);
		btnDangNhap.setMnemonic(KeyEvent.VK_ENTER);
		pnChinh.add(btnDangNhap);
	}
}
