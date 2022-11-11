package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import connectDB.ConnectDB;
import dao.Thuoc_DAO;
import entity.Thuoc;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GDXemTTThuoc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableTimKiem;
	private Thuoc_DAO thuoc_dao;
	private DefaultTableModel modelTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDXemTTThuoc frame = new GDXemTTThuoc();
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
	public GDXemTTThuoc() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		thuoc_dao = new Thuoc_DAO();
		
		setTitle("TÌM KIẾM THÔNG TIN THUỐC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1188, 656);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel pnChinh = new JPanel();
		pnChinh.setBackground(new Color(127, 255, 212));
		pnChinh.setBounds(0, 0, 1184, 631);
		contentPane.add(pnChinh);
		pnChinh.setLayout(null);
		
		JPanel pNorth = new JPanel();
		pNorth.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(250, 128, 114)));
		pNorth.setBackground(new Color(255, 228, 181));
		pNorth.setBounds(10, 11, 1164, 172);
		pnChinh.add(pNorth);
		pNorth.setLayout(null);
		
		JLabel lblTimKiem = new JLabel("Chọn mục cần tìm: (bấm vào hình bên dưới để tìm)");
		lblTimKiem.setForeground(Color.BLUE);
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblTimKiem.setBounds(10, 11, 481, 25);
		pNorth.add(lblTimKiem);
		
		JComboBox<String> cboTimMaThuoc = new JComboBox<String>();
		cboTimMaThuoc.setBounds(10, 76, 122, 22);
		pNorth.add(cboTimMaThuoc);
		cboTimMaThuoc.setEditable(true);
		
		JComboBox<String> cboTimTenThuoc = new JComboBox<String>();
		cboTimTenThuoc.setBounds(142, 76, 293, 22);
		pNorth.add(cboTimTenThuoc);
		cboTimTenThuoc.setEditable(true);
		
		JComboBox<String> cboTimNCC = new JComboBox<String>();
		cboTimNCC.setBounds(445, 76, 293, 22);
		pNorth.add(cboTimNCC);
		cboTimNCC.setEditable(true);
		
		JComboBox<String> cboTimCongDung = new JComboBox<String>();
		cboTimCongDung.setBounds(748, 76, 293, 22);
		pNorth.add(cboTimCongDung);
		cboTimCongDung.setEditable(true);
		
		JComboBox<String> cboTimDonVi = new JComboBox<String>();
		cboTimDonVi.setBounds(1051, 76, 103, 22);
		pNorth.add(cboTimDonVi);
		cboTimDonVi.setEditable(true);
		
		ArrayList<Thuoc> listThuoc = thuoc_dao.getThuocs();
		
		for(Thuoc t : listThuoc) {
			cboTimMaThuoc.addItem(t.getMaThuoc());
			cboTimTenThuoc.addItem(t.getTenThuoc());
		}
		ArrayList<Thuoc> listDonVi = thuoc_dao.getCboDonVi();
		for(Thuoc t : listDonVi) {
			cboTimDonVi.addItem(t.getDonViTinh());
		}
		ArrayList<Thuoc> listNCC = thuoc_dao.getCboNCC();
		for(Thuoc t : listNCC) {
			cboTimNCC.addItem(t.getNhaCungCap());
		}
		ArrayList<Thuoc> listCD = thuoc_dao.getCboCongDung();
		for(Thuoc t : listCD) {
			cboTimCongDung.addItem(t.getCongDung());
		}
		cboTimCongDung.setSelectedItem("");
		cboTimDonVi.setSelectedItem("");
		cboTimMaThuoc.setSelectedItem("");
		cboTimNCC.setSelectedItem("");
		cboTimTenThuoc.setSelectedItem("");
		AutoCompleteDecorator.decorate(cboTimCongDung);
		AutoCompleteDecorator.decorate(cboTimDonVi);
		AutoCompleteDecorator.decorate(cboTimMaThuoc);
		AutoCompleteDecorator.decorate(cboTimNCC);
		AutoCompleteDecorator.decorate(cboTimTenThuoc);
		
		JLabel lblMaThuoc = new JLabel("Mã thuốc");
		lblMaThuoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaThuoc.setBounds(10, 51, 69, 14);
		pNorth.add(lblMaThuoc);
		
		JLabel lblTenThuoc = new JLabel("Tên thuốc");
		lblTenThuoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenThuoc.setBounds(142, 51, 69, 14);
		pNorth.add(lblTenThuoc);
		
		JLabel lblNhCungCp = new JLabel("Nhà cung cấp");
		lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNhCungCp.setBounds(445, 46, 88, 25);
		pNorth.add(lblNhCungCp);
		
		JLabel lblCngDng = new JLabel("Công dụng");
		lblCngDng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCngDng.setBounds(748, 48, 69, 20);
		pNorth.add(lblCngDng);
		
		JLabel lblDonVi = new JLabel("Đơn vị");
		lblDonVi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDonVi.setBounds(1051, 51, 69, 14);
		pNorth.add(lblDonVi);
		
		JLabel lblH1 = new JLabel("");
		lblH1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if(o.equals(lblH1)) {
					XoaHetDuLieuTable();
					List<Thuoc> listTimKiemTheoMa = thuoc_dao.getTimKiemTheoMa(cboTimMaThuoc.getSelectedItem().toString());
					cboTimMaThuoc.setSelectedItem("");	
					for(Thuoc t : listTimKiemTheoMa) {
						modelTimKiem.addRow(new Object[] {
								t.getMaThuoc(), t.getTenThuoc(), t.getNhaCungCap(),
								t.getGiaThuoc(), t.getCongDung(), t.getSoLuong(),
								t.getDonViTinh(), t.getNgaySanXuat(), t.getNgayHetHan()
						});
					}
				}
			}
		});
		lblH1.setBounds(42, 101, 60, 60);
		pNorth.add(lblH1);
		Image H1 = new ImageIcon(this.getClass().getResource("/img/timmathuoc.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		lblH1.setIcon(new ImageIcon(H1));
		
		JLabel lblH2 = new JLabel("");
		lblH2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if(o.equals(lblH2)) {
					XoaHetDuLieuTable();
					List<Thuoc> listTimKiemTheoTen = thuoc_dao.getTimKiemTheoTen(cboTimTenThuoc.getSelectedItem().toString());
					cboTimTenThuoc.setSelectedItem("");	
					for(Thuoc t : listTimKiemTheoTen) {
						modelTimKiem.addRow(new Object[] {
								t.getMaThuoc(), t.getTenThuoc(), t.getNhaCungCap(),
								t.getGiaThuoc(), t.getCongDung(), t.getSoLuong(),
								t.getDonViTinh(), t.getNgaySanXuat(), t.getNgayHetHan()
						});
					}
				}
			}
		});
		lblH2.setBounds(261, 101, 60, 60);
		
		pNorth.add(lblH2);
		Image H2 = new ImageIcon(this.getClass().getResource("/img/pill.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		lblH2.setIcon(new ImageIcon(H2));
		
		JLabel lblH3 = new JLabel("");
		lblH3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if(o.equals(lblH3)) {
					XoaHetDuLieuTable();
					List<Thuoc> listTimKiemTheoNCC = thuoc_dao.getTimKiemTheoNCC(cboTimNCC.getSelectedItem().toString());
					cboTimNCC.setSelectedItem("");
					for(Thuoc t : listTimKiemTheoNCC) {
						modelTimKiem.addRow(new Object[] {
								t.getMaThuoc(), t.getTenThuoc(), t.getNhaCungCap(),
								t.getGiaThuoc(), t.getCongDung(), t.getSoLuong(),
								t.getDonViTinh(), t.getNgaySanXuat(), t.getNgayHetHan()
						});
					}
				}
			}
		});
		lblH3.setBounds(566, 101, 60, 60);
		pNorth.add(lblH3);
		Image H3 = new ImageIcon(this.getClass().getResource("/img/product.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		lblH3.setIcon(new ImageIcon(H3));
		
		JLabel lblH4 = new JLabel("");
		lblH4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if(o.equals(lblH4)) {
					XoaHetDuLieuTable();
					List<Thuoc> listTimKiemTheoCongDung = thuoc_dao.getTimKiemTheoCongDung(cboTimCongDung.getSelectedItem().toString());
					cboTimCongDung.setSelectedItem("");
					for(Thuoc t : listTimKiemTheoCongDung) {
						modelTimKiem.addRow(new Object[] {
								t.getMaThuoc(), t.getTenThuoc(), t.getNhaCungCap(),
								t.getGiaThuoc(), t.getCongDung(), t.getSoLuong(),
								t.getDonViTinh(), t.getNgaySanXuat(), t.getNgayHetHan()
						});
					}
				}
			}
		});
		lblH4.setBounds(870, 101, 60, 60);
		pNorth.add(lblH4);
		Image H4 = new ImageIcon(this.getClass().getResource("/img/medicine.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		lblH4.setIcon(new ImageIcon(H4));

		JLabel lblH5 = new JLabel("");
		lblH5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if(o.equals(lblH5)) {
					XoaHetDuLieuTable();
					List<Thuoc> listTimKiemTheoDV = thuoc_dao.getTimKiemTheoDonVi(cboTimDonVi.getSelectedItem().toString());		
					cboTimDonVi.setSelectedItem("");
					for(Thuoc t : listTimKiemTheoDV) {
						modelTimKiem.addRow(new Object[] {
								t.getMaThuoc(), t.getTenThuoc(), t.getNhaCungCap(),
								t.getGiaThuoc(), t.getCongDung(), t.getSoLuong(),
								t.getDonViTinh(), t.getNgaySanXuat(), t.getNgayHetHan()
						});
					}

				}
			}
		});
		lblH5.setBounds(1073, 101, 60, 60);
		pNorth.add(lblH5);
		Image H5 = new ImageIcon(this.getClass().getResource("/img/star.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		lblH5.setIcon(new ImageIcon(H5));

		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setBackground(new Color(0, 255, 255));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDChinh().setVisible(true);
				dispose();
			}
		});
		btnQuayLai.setForeground(new Color(199, 21, 133));
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnQuayLai.setBounds(886, 11, 268, 33);
		btnQuayLai.setMnemonic(KeyEvent.VK_Q);
		btnQuayLai.setToolTipText("Bấm Alt + Q");
		pNorth.add(btnQuayLai);
		Image h_quaylai = new ImageIcon(this.getClass().getResource("/img/quaylai.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnQuayLai.setIcon(new ImageIcon(h_quaylai));
		
		JButton btnLamMoiDS = new JButton("Làm mới danh sách");
		btnLamMoiDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnLamMoiDS)) {
					XoaHetDuLieuTable();
					DocDuLieuDBVaoTable();
				}
			}
		});
		btnLamMoiDS.setForeground(new Color(199, 21, 133));
		btnLamMoiDS.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnLamMoiDS.setBackground(new Color(0, 255, 255));
		btnLamMoiDS.setBounds(608, 11, 268, 33);
		btnLamMoiDS.setMnemonic(KeyEvent.VK_L);
		btnLamMoiDS.setToolTipText("Bấm Alt + L");
		pNorth.add(btnLamMoiDS);
		Image h_LamMoi = new ImageIcon(this.getClass().getResource("/img/lammoids.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		btnLamMoiDS.setIcon(new ImageIcon(h_LamMoi));
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(255, 255, 0));
		pCenter.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 127, 80)));
		pCenter.setBounds(10, 194, 1164, 426);
		pnChinh.add(pCenter);
		pCenter.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1144, 404);
		pCenter.add(scrollPane);
		
		tableTimKiem = new JTable();
		tableTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableTimKiem.setModel(modelTimKiem = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 thu\u1ED1c", "T\u00EAn thu\u1ED1c", "Nh\u00E0 cung c\u1EA5p", "Gi\u00E1 thu\u1ED1c", "C\u00F4ng d\u1EE5ng", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n v\u1ECB", "Ng\u00E0y s\u1EA3n xu\u1EA5t", "Ng\u00E0y h\u1EBFt h\u1EA1n"
			}
		));
		tableTimKiem.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableTimKiem.getColumnModel().getColumn(1).setPreferredWidth(119);
		tableTimKiem.getColumnModel().getColumn(2).setPreferredWidth(110);
		tableTimKiem.getColumnModel().getColumn(3).setPreferredWidth(15);
		tableTimKiem.getColumnModel().getColumn(4).setPreferredWidth(250);
		tableTimKiem.getColumnModel().getColumn(5).setPreferredWidth(15);
		tableTimKiem.getColumnModel().getColumn(6).setPreferredWidth(15);
		tableTimKiem.getColumnModel().getColumn(7).setPreferredWidth(30);
		tableTimKiem.getColumnModel().getColumn(8).setPreferredWidth(30);
		
		DocDuLieuDBVaoTable();
		scrollPane.setViewportView(tableTimKiem);
	}

	private void DocDuLieuDBVaoTable() {
		List<Thuoc> list = thuoc_dao.getThuocs();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		for(Thuoc t : list) {
			
			modelTimKiem.addRow(new Object[] {
					t.getMaThuoc(), t.getTenThuoc(), t.getNhaCungCap(),
					t.getGiaThuoc(), t.getCongDung(), t.getSoLuong(),
					t.getDonViTinh(), sdf.format(t.getNgaySanXuat()), sdf.format(t.getNgayHetHan())
			});
		}
		
	}
	private void XoaHetDuLieuTable() {
		DefaultTableModel dtm = (DefaultTableModel) tableTimKiem.getModel();
		dtm.setRowCount(0);
	}
}
