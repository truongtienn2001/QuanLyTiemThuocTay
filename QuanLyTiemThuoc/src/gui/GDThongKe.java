package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.ThongKe_DAO;
import entity.HoaDonBanThuoc;
import entity.Thuoc;

import java.awt.Font;

public class GDThongKe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel labell;
	private JTable tableThongKe;
	private DefaultTableModel modelThongKe;
	private ThongKe_DAO thongke_dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDThongKe frame = new GDThongKe();
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
	public GDThongKe() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		thongke_dao = new ThongKe_DAO();
		
		setTitle("THỐNG KÊ THÔNG TIN THUỐC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 659);
		labell = new JPanel();
		labell.setBackground(Color.GREEN);
		labell.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(labell);
		setResizable(false);
		setLocationRelativeTo(null);
		Image img_TroVe = new ImageIcon(this.getClass().getResource("/img/back.png")).getImage().getScaledInstance(55, 50, Image.SCALE_SMOOTH);
		labell.setLayout(null);
		Image h_LamMoi = new ImageIcon(this.getClass().getResource("/img/lammoids.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		Image h_ThuocHetHan = new ImageIcon(this.getClass().getResource("/img/thuochh.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		Image h_ThuocConHan = new ImageIcon(this.getClass().getResource("/img/thuocconhan.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(0, 73, 1075, 506);
		labell.add(scrollPane);
		
		tableThongKe = new JTable();
		tableThongKe.setModel(modelThongKe = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn thu\u1ED1c", "Nh\u00E0 cung c\u1EA5p", "\u0110\u01A1n v\u1ECB t\u00EDnh", "T\u00ECnh tr\u1EA1ng s\u1ED1 l\u01B0\u1EE3ng", "T\u00ECnh tr\u1EA1ng h\u1EA1n"
			}
		));
		scrollPane.setViewportView(tableThongKe);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(Color.CYAN);
		pnChucNang.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pnChucNang.setBounds(0, 0, 1075, 75);
		labell.add(pnChucNang);
		pnChucNang.setLayout(null);
		
		JLabel lblThuocConHan = new JLabel("");
		
		lblThuocConHan.setBounds(186, 0, 64, 75);
		pnChucNang.add(lblThuocConHan);
		lblThuocConHan.setToolTipText("THUỐC CÒN HẠN");
		lblThuocConHan.setDisplayedMnemonic(KeyEvent.VK_1);
		lblThuocConHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThuocConHan.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblThuocConHan.setIcon(new ImageIcon(h_ThuocConHan));
		
		JLabel lblThuocHetHan = new JLabel("");
		
		lblThuocHetHan.setBounds(124, 0, 64, 75);
		pnChucNang.add(lblThuocHetHan);
		lblThuocHetHan.setToolTipText("THUỐC HẾT HẠN");
		lblThuocHetHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThuocHetHan.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblThuocHetHan.setIcon(new ImageIcon(h_ThuocHetHan));
		
		JLabel lblLamMoi = new JLabel("");
		
		lblLamMoi.setBounds(62, 0, 64, 75);
		pnChucNang.add(lblLamMoi);
		lblLamMoi.setToolTipText("LÀM MỚI DANH SÁCH");
		lblLamMoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblLamMoi.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblLamMoi.setIcon(new ImageIcon(h_LamMoi));
		
		JLabel lblTroVe = new JLabel("");
		lblTroVe.setBounds(0, 0, 64, 75);
		pnChucNang.add(lblTroVe);
		lblTroVe.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblTroVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GDChinh chinh = new GDChinh();
				chinh.setVisible(true);
				dispose();
			}
		});
		lblTroVe.setToolTipText("TRỞ VỀ GIAO DIỆN CHÍNH");
		lblTroVe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTroVe.setIcon(new ImageIcon(img_TroVe));
		
		JPanel pnTST = new JPanel();
		pnTST.setBackground(Color.CYAN);
		pnTST.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pnTST.setBounds(0, 576, 342, 55);
		labell.add(pnTST);
		pnTST.setLayout(null);
		
		JLabel lblTongSoThuoc = new JLabel("............");
		lblTongSoThuoc.setBounds(175, 16, 123, 28);
		pnTST.add(lblTongSoThuoc);
		lblTongSoThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Tổng số thuốc:");
		lblNewLabel.setBounds(42, 16, 123, 28);
		pnTST.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(366, 576, 342, 55);
		labell.add(panel);
		
		JLabel lblTCH = new JLabel("............");
		lblTCH.setBounds(178, 16, 123, 28);
		panel.add(lblTCH);
		lblTCH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblSLConHan = new JLabel("Thuốc còn hạn:");
		lblSLConHan.setBounds(45, 16, 123, 28);
		panel.add(lblSLConHan);
		lblSLConHan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(733, 576, 342, 55);
		labell.add(panel_1);
		
		JLabel lblTDT = new JLabel("............");
		lblTDT.setBounds(177, 16, 123, 28);
		panel_1.add(lblTDT);
		lblTDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTongDoanhThu = new JLabel("Tổng doanh thu:");
		lblTongDoanhThu.setBounds(44, 16, 123, 28);
		panel_1.add(lblTongDoanhThu);
		lblTongDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		long millis = System.currentTimeMillis();
		Date nlhd = new Date(millis);
		List<Thuoc> list = thongke_dao.getThuoc();
		for(Thuoc t : list) {
			modelThongKe.addRow(new Object[] {
				t.getTenThuoc(), t.getNhaCungCap(), t.getDonViTinh(),
				t.getSoLuong() > 0 ? "Còn hàng" : "Hết hàng", t.getNgayHetHan().before(nlhd) ? "Hết hạn" : "Còn hạn"
			});
		}
		
		int dem = 0;
		int row = tableThongKe.getRowCount();
		for(int i = 0; i < row; i++) {
			if(modelThongKe.getValueAt(i, 4).toString() == "Còn hạn") {
				dem++;
			}
		}
		lblTCH.setText(dem + "");
		lblTongSoThuoc.setText(row + "");
		
		double tong = 0;
		List<HoaDonBanThuoc> listTien = thongke_dao.getTongDoanhThu();
		for(HoaDonBanThuoc hdbt : listTien) {
			tong = tong + hdbt.getThanhTien();
		}
		lblTDT.setText(tong + "");
		
		lblLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if(o.equals(lblLamMoi)) {
					XoaHetDuLieuTable();
					List<Thuoc> list = thongke_dao.getThuoc();
					for(Thuoc t : list) {
						modelThongKe.addRow(new Object[] {
							t.getTenThuoc(), t.getNhaCungCap(), t.getDonViTinh(),
							t.getSoLuong() > 0 ? "Còn hàng" : "Hết hàng", t.getNgayHetHan().before(nlhd) ? "Hết hạn" : "Còn hạn"
						});
					}
				}
			}
		});
		
		lblThuocConHan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if(o.equals(lblThuocConHan)) {
					XoaHetDuLieuTable();
					List<Thuoc> list = thongke_dao.getThuoc();
					for(Thuoc t : list) {
						if(t.getNgayHetHan().after(nlhd)) {
							modelThongKe.addRow(new Object[] {
									t.getTenThuoc(), t.getNhaCungCap(), t.getDonViTinh(),
									t.getSoLuong() > 0 ? "Còn hàng" : "Hết hàng", "Còn hạn"
								});
						}
						
					}
				}
			}
		});
		
		lblThuocHetHan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if(o.equals(lblThuocHetHan)) {
					XoaHetDuLieuTable();
					List<Thuoc> list = thongke_dao.getThuoc();
					for(Thuoc t : list) {
						if(t.getNgayHetHan().before(nlhd)) {
							modelThongKe.addRow(new Object[] {
									t.getTenThuoc(), t.getNhaCungCap(), t.getDonViTinh(),
									t.getSoLuong() > 0 ? "Còn hàng" : "Hết hàng", "Hết hạn"
								});
						}
						
					}
				}
			}
		});
	}
	private void XoaHetDuLieuTable() {
		DefaultTableModel dtm = (DefaultTableModel) tableThongKe.getModel();
		dtm.setRowCount(0);
	}
}
