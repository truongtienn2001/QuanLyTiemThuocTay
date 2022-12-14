package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.border.MatteBorder;

public class GDChinh extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDChinh frame = new GDChinh();
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
	public GDChinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel pnChinh = new JPanel();
		pnChinh.setBackground(new Color(47, 79, 79));
		pnChinh.setBounds(0, 0, 886, 563);
		getContentPane().add(pnChinh);
		pnChinh.setLayout(null);

		JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(new Color(0, 128, 128));
		pnChucNang.setBounds(0, 0, 338, 563);
		pnChinh.add(pnChucNang);
		pnChucNang.setLayout(null);
		Image img_CapNhatThuoc = new ImageIcon(this.getClass().getResource("/img/capnhat.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Image img_XemThongTinThuoc = new ImageIcon(this.getClass().getResource("/img/xem.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Image img_LapHoaDon = new ImageIcon(this.getClass().getResource("/img/hoadon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(104, 0, 133, 133);
		pnChucNang.add(lblLogo);
		Image img = new ImageIcon(this.getClass().getResource("/img/tiemthuoc.png")).getImage().getScaledInstance(133, 133, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		Image img_IconThem = new ImageIcon(this.getClass().getResource("/img/themthuoc.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		JButton btnQLKH = new JButton("  QU???N L?? KH??CH H??NG");
		btnQLKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GDQLKhachHang qlkh = new GDQLKhachHang();
				qlkh.setVisible(true);
				dispose();
			}
		});
		btnQLKH.setBackground(new Color(218, 165, 32));
		btnQLKH.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLKH.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQLKH.setBounds(0, 285, 338, 52);
		btnQLKH.setMnemonic(KeyEvent.VK_Q);
		btnQLKH.setToolTipText("B???m Alt + Q");
		pnChucNang.add(btnQLKH);
		Image img_IconQLKH = new ImageIcon(this.getClass().getResource("/img/qlkhachhang.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		btnQLKH.setIcon(new ImageIcon(img_IconQLKH));
		
				JButton btnLapHoaDon = new JButton("  L???P H??A ????N");
				btnLapHoaDon.setBounds(0, 335, 338, 52);
				pnChucNang.add(btnLapHoaDon);
				btnLapHoaDon.setBackground(new Color(218, 165, 32));
				btnLapHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
				btnLapHoaDon.setMnemonic(KeyEvent.VK_L);
				btnLapHoaDon.setToolTipText("B???m Alt + L");
				btnLapHoaDon.setIcon(new ImageIcon(img_LapHoaDon));
				btnLapHoaDon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GDLapHoaDon l = new GDLapHoaDon();
						l.setVisible(true);
						dispose();
					}
				});
				btnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
				
						JButton btnXemThongTinThuoc = new JButton("  XEM TH??NG TIN THU???C");
						btnXemThongTinThuoc.setBounds(0, 235, 338, 52);
						pnChucNang.add(btnXemThongTinThuoc);
						btnXemThongTinThuoc.setBackground(new Color(218, 165, 32));
						btnXemThongTinThuoc.setHorizontalAlignment(SwingConstants.LEFT);
						btnXemThongTinThuoc.setIcon(new ImageIcon(img_XemThongTinThuoc));
						btnXemThongTinThuoc.setFont(new Font("Tahoma", Font.BOLD, 16));
						btnXemThongTinThuoc.setMnemonic(KeyEvent.VK_X);
						btnXemThongTinThuoc.setToolTipText("B???m Alt + X");
						
								JButton btnCapNhatThuoc = new JButton("  C???P NH???T TH??NG TIN THU???C");
								btnCapNhatThuoc.setBounds(0, 185, 338, 52);
								pnChucNang.add(btnCapNhatThuoc);
								btnCapNhatThuoc.setBackground(new Color(218, 165, 32));
								btnCapNhatThuoc.setHorizontalAlignment(SwingConstants.LEFT);
								btnCapNhatThuoc.setIcon(new ImageIcon(img_CapNhatThuoc));
								btnCapNhatThuoc.setMnemonic(KeyEvent.VK_C);
								btnCapNhatThuoc.setToolTipText("B???m Alt + C");
								btnCapNhatThuoc.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										GDCapNhatThuoc c = new GDCapNhatThuoc();
										c.setVisible(true);
										dispose();
									}
								});
								btnCapNhatThuoc.setFont(new Font("Tahoma", Font.BOLD, 16));
								
										JButton btnThemTTThuoc = new JButton("  TH??M TH??NG TIN THU???C");
										btnThemTTThuoc.setBounds(0, 136, 338, 52);
										pnChucNang.add(btnThemTTThuoc);
										btnThemTTThuoc.setBackground(new Color(218, 165, 32));
										btnThemTTThuoc.setHorizontalAlignment(SwingConstants.LEFT);
										btnThemTTThuoc.setMnemonic(KeyEvent.VK_T);
										btnThemTTThuoc.setToolTipText("B???m Alt + T");
										btnThemTTThuoc.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
												GDThemTTThuoc them = new GDThemTTThuoc();
												them.setVisible(true);
												dispose();

											}	
										});
										btnThemTTThuoc.setFont(new Font("Tahoma", Font.BOLD, 16));
										btnThemTTThuoc.setIcon(new ImageIcon(img_IconThem));
										
										JButton btnThongKe = new JButton("  TH???NG K?? TH??NG TIN THU???C");
										btnThongKe.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												GDThongKe tk = new GDThongKe();
												tk.setVisible(true);
												dispose();
											}
										});
										btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
										btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 16));
										btnThongKe.setBackground(new Color(218, 165, 32));
										btnThongKe.setBounds(0, 385, 338, 52);
										btnThongKe.setMnemonic(KeyEvent.VK_H);
										btnThongKe.setToolTipText("B???m Alt + H");
										Image img_IconThongKe = new ImageIcon(this.getClass().getResource("/img/thongke.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
										btnThongKe.setIcon(new ImageIcon(img_IconThongKe));
										pnChucNang.add(btnThongKe);
										
										JLabel lblAnhNen = new JLabel("");
										lblAnhNen.setBounds(0, 436, 338, 127);
										Image imgAN = new ImageIcon(this.getClass().getResource("/img/tim.jpg")).getImage().getScaledInstance(338, 127, Image.SCALE_SMOOTH);
										lblAnhNen.setIcon(new ImageIcon(imgAN));
										pnChucNang.add(lblAnhNen);
										
						btnXemThongTinThuoc.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new GDXemTTThuoc().setVisible(true);
								dispose();
							}
						});
		
		JLabel lblTieuDe = new JLabel("TI???M THU???C TTT");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(new Color(222, 184, 135));
		lblTieuDe.setBackground(new Color(255, 255, 255));
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(371, 23, 476, 96);
		pnChinh.add(lblTieuDe);

		JLabel lblHinhChinh = new JLabel("");
		lblHinhChinh.setBounds(339, 136, 545, 427);
		pnChinh.add(lblHinhChinh);
		Image img1 = new ImageIcon(this.getClass().getResource("/img/bacsi.jpg")).getImage().getScaledInstance(545, 427, Image.SCALE_SMOOTH);
		lblHinhChinh.setIcon(new ImageIcon(img1));
		lblHinhChinh.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
