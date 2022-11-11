package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import connectDB.ConnectDB;
import dao.HoaDonBanThuoc_DAO;
import dao.KhachHang_DAO;
import dao.Thuoc_DAO;
import entity.HoaDonBanThuoc;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

public class GDLapHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaHoaDon;
	private JTextField txtSoLuong;
	private JTable tableCTHD;
	private DefaultTableModel modelHD;
	private KhachHang_DAO kh_dao;
	private HoaDonBanThuoc_DAO hdbt_dao;
	private Thuoc_DAO thuoc_dao;
	private JLabel lblTongTien;
	private JTextField txtThongBao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDLapHoaDon frame = new GDLapHoaDon();
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
	public GDLapHoaDon() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		hdbt_dao = new HoaDonBanThuoc_DAO();
		kh_dao = new KhachHang_DAO();
		thuoc_dao = new Thuoc_DAO();
		
		setTitle("HÓA ĐƠN BÁN THUỐC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1188, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel pnChinh = new JPanel();
		pnChinh.setBackground(new Color(127, 255, 212));
		pnChinh.setBounds(0, 0, 1186, 633);
		contentPane.add(pnChinh);
		pnChinh.setLayout(null);
		
		JPanel pnHoaDon = new JPanel();
		pnHoaDon.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 69, 0)));
		pnHoaDon.setBounds(10, 10, 1166, 209);
		pnChinh.add(pnHoaDon);
		pnHoaDon.setLayout(null);
		
		JLabel lblMaHoaDon = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n:");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaHoaDon.setBounds(10, 28, 80, 30);
		pnHoaDon.add(lblMaHoaDon);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setBounds(152, 31, 120, 26);
		pnHoaDon.add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);
		
		JLabel lblHoTenNV = new JLabel("Nhân viên kê đơn:");
		lblHoTenNV.setBounds(10, 106, 132, 26);
		pnHoaDon.add(lblHoTenNV);
		lblHoTenNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblHoTenKH = new JLabel("H\u1ECD t\u00EAn kh\u00E1ch h\u00E0ng:");
		lblHoTenKH.setBounds(10, 65, 132, 30);
		pnHoaDon.add(lblHoTenKH);
		lblHoTenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblTenThuoc = new JLabel("T\u00EAn thu\u1ED1c:");
		lblTenThuoc.setBounds(657, 31, 76, 26);
		pnHoaDon.add(lblTenThuoc);
		lblTenThuoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JComboBox<String> cboTenThuoc = new JComboBox<String>();
		cboTenThuoc.setBounds(791, 32, 267, 26);
		pnHoaDon.add(cboTenThuoc);
		cboTenThuoc.setEditable(true);
		
		JLabel lblDonViTinh = new JLabel("\u0110\u01A1n v\u1ECB t\u00EDnh:");
		lblDonViTinh.setBounds(657, 68, 81, 26);
		pnHoaDon.add(lblDonViTinh);
		lblDonViTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JComboBox<String> cboDonViTinh = new JComboBox<String>();
		cboDonViTinh.setBounds(791, 69, 150, 26);
		pnHoaDon.add(cboDonViTinh);
		
		JLabel lblSoLuong = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lblSoLuong.setBounds(657, 105, 76, 26);
		pnHoaDon.add(lblSoLuong);
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(791, 106, 90, 26);
		pnHoaDon.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JButton btnThemHoaDon = new JButton("Thêm hóa đơn");
		btnThemHoaDon.setBackground(new Color(128, 128, 0));
		btnThemHoaDon.setForeground(new Color(0, 0, 0));
		btnThemHoaDon.setBounds(657, 143, 160, 37);
		btnThemHoaDon.setMnemonic(KeyEvent.VK_T);
		btnThemHoaDon.setToolTipText("bấm Alt T");
		pnHoaDon.add(btnThemHoaDon);
		btnThemHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		Image img_ThemHD= new ImageIcon(this.getClass().getResource("/img/themhd.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btnThemHoaDon.setIcon(new ImageIcon(img_ThemHD));
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBackground(new Color(128, 128, 0));
		btnXoaTrang.setForeground(new Color(0, 0, 0));
		btnXoaTrang.setBounds(827, 143, 160, 37);
		btnXoaTrang.setMnemonic(KeyEvent.VK_R);
		btnXoaTrang.setToolTipText("Bấm Alt + R");
		pnHoaDon.add(btnXoaTrang);
		
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		Image img_XoaTrang = new ImageIcon(this.getClass().getResource("/img/xoatrang.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btnXoaTrang.setIcon(new ImageIcon(img_XoaTrang));
		
		JButton btnQuayLai = new JButton("Quay L\u1EA1i");
		btnQuayLai.setBackground(new Color(128, 128, 0));
		btnQuayLai.setForeground(new Color(0, 0, 0));
		btnQuayLai.setBounds(997, 143, 159, 37);
		btnQuayLai.setMnemonic(KeyEvent.VK_Q);
		btnQuayLai.setToolTipText("Bấm Alt + Q");
		pnHoaDon.add(btnQuayLai);
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GDChinh chinh = new GDChinh();
				chinh.setVisible(true);
				dispose();
			}
		});
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		Image img_QuayLai = new ImageIcon(this.getClass().getResource("/img/quaylai.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btnQuayLai.setIcon(new ImageIcon(img_QuayLai));
		
		JLabel lblHinhAnhHD = new JLabel("");
		Image img_HD = new ImageIcon(this.getClass().getResource("/img/hoadonbanthuoc.png")).getImage().getScaledInstance(154, 154, Image.SCALE_SMOOTH);
		lblHinhAnhHD.setBounds(493, 11, 154, 187);
		lblHinhAnhHD.setIcon(new ImageIcon(img_HD));
		pnHoaDon.add(lblHinhAnhHD);
		
		JComboBox<String> cboHoTenKH = new JComboBox<String>();
		cboHoTenKH.setBounds(152, 68, 273, 26);
		cboHoTenKH.setEditable(true);
		pnHoaDon.add(cboHoTenKH);
		
		JComboBox<String> cboNVKD = new JComboBox<String>();
		cboNVKD.setBounds(152, 107, 273, 26);
		cboNVKD.setEditable(true);
		pnHoaDon.add(cboNVKD);
		
		ArrayList<KhachHang> listKH = kh_dao.getCboThongTinKH();
		for(KhachHang kh : listKH) {
			cboHoTenKH.addItem(kh.getHoTenKH());
		}
		cboHoTenKH.setSelectedItem("");
		
		ArrayList<NhanVien> listNV = hdbt_dao.getTenNV();
		for(NhanVien nv : listNV){
			cboNVKD.addItem(nv.getHoTenNV());
		}
		cboNVKD.setSelectedItem("");
		
		ArrayList<Thuoc> listTenThuoc = thuoc_dao.getTenThuoc();
		for(Thuoc t : listTenThuoc) {
			cboTenThuoc.addItem(t.getTenThuoc());
		}
		cboTenThuoc.setSelectedItem("");
		
		ArrayList<Thuoc> listDVT = thuoc_dao.getDVT();
		for(Thuoc t : listDVT) {
			cboDonViTinh.addItem(t.getDonViTinh());
		}
		
		AutoCompleteDecorator.decorate(cboHoTenKH);
		AutoCompleteDecorator.decorate(cboNVKD);
		AutoCompleteDecorator.decorate(cboTenThuoc);
		
		txtThongBao = new JTextField();
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtThongBao.setEditable(false);
		txtThongBao.setBorder(null);
		txtThongBao.setBackground(new Color(240, 240, 240));
		txtThongBao.setBounds(10, 150, 379, 22);
		pnHoaDon.add(txtThongBao);
		
		JPanel pnBangHD = new JPanel();
		pnBangHD.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 69, 0)));
		pnBangHD.setBounds(10, 230, 401, 392);
		pnChinh.add(pnBangHD);
		pnBangHD.setLayout(null);
		
		JLabel lblHDMaHD = new JLabel("Mã hóa đơn:");
		lblHDMaHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHDMaHD.setBounds(10, 11, 111, 30);
		pnBangHD.add(lblHDMaHD);
		
		JLabel lblHDTenKH = new JLabel("Họ tên khách hàng:");
		lblHDTenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHDTenKH.setBounds(10, 52, 116, 30);
		pnBangHD.add(lblHDTenKH);
		
		JLabel lblHDNS = new JLabel("Ngày sinh:");
		lblHDNS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHDNS.setBounds(10, 93, 103, 30);
		pnBangHD.add(lblHDNS);
		
		JLabel lblHDGioiTinh = new JLabel("Giới tính:");
		lblHDGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHDGioiTinh.setBounds(250, 93, 59, 30);
		pnBangHD.add(lblHDGioiTinh);
		
		JLabel lblHDDiaChi = new JLabel("Địa chỉ:");
		lblHDDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHDDiaChi.setBounds(10, 134, 103, 30);
		pnBangHD.add(lblHDDiaChi);
		
		JLabel lblNVKeDon = new JLabel("Nhân viên kê đơn:");
		lblNVKeDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNVKeDon.setBounds(10, 175, 111, 30);
		pnBangHD.add(lblNVKeDon);
		
		JLabel lblNgayKeDon = new JLabel("Ngày kê đơn:");
		lblNgayKeDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgayKeDon.setBounds(10, 216, 111, 30);
		pnBangHD.add(lblNgayKeDon);
		
		JLabel lblMHD = new JLabel("...........");
		lblMHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMHD.setBounds(131, 11, 72, 30);
		pnBangHD.add(lblMHD);
		
		JLabel lblHTKH = new JLabel("...........");
		lblHTKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHTKH.setBounds(131, 52, 246, 30);
		pnBangHD.add(lblHTKH);
		
		JLabel lblNS = new JLabel("...........");
		lblNS.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNS.setBounds(131, 93, 109, 30);
		pnBangHD.add(lblNS);
		
		JLabel lblDC = new JLabel("...........");
		lblDC.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDC.setBounds(131, 134, 72, 30);
		pnBangHD.add(lblDC);
		
		JLabel lblNVKD = new JLabel("...........");
		lblNVKD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNVKD.setBounds(131, 175, 188, 30);
		pnBangHD.add(lblNVKD);
		
		JLabel lblNKD = new JLabel("...........");
		lblNKD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNKD.setBounds(131, 216, 246, 30);
		pnBangHD.add(lblNKD);
		
		JLabel lblGT = new JLabel("...........");
		lblGT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGT.setBounds(319, 93, 72, 30);
		pnBangHD.add(lblGT);
		
		JButton btnXemDSHD = new JButton("Xem danh sách hóa đơn đã lập");
		btnXemDSHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GDDanhSachHoaDon hd = new GDDanhSachHoaDon();
				hd.setVisible(true);
				dispose();
			}
		});
		btnXemDSHD.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
		btnXemDSHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXemDSHD.setBounds(10, 344, 381, 37);
		btnXemDSHD.setMnemonic(KeyEvent.VK_H);
		btnXemDSHD.setToolTipText("Bấm Alt + H");
		pnBangHD.add(btnXemDSHD);
		
		btnThemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validData()) {
					String ma = txtMaHoaDon.getText();
					String maKH = null;
					String maNV = null;
					String maThuoc = null;
					String tenKH = cboHoTenKH.getSelectedItem().toString();	
					List<KhachHang> listLayMaTuTenKH = kh_dao.getMaTuTenKH(tenKH);
					for(KhachHang kh : listLayMaTuTenKH) {
						maKH = kh.getMaKH();
					}
					List<KhachHang> listLayNgaySinhTuTenKH = kh_dao.getNgaySinhTuTenKH(tenKH);
					for(KhachHang kh : listLayNgaySinhTuTenKH) {
						lblNS.setText(kh.getNgaySinhKH().toString());
					}
					Date ns = Date.valueOf(lblNS.getText());
					List<KhachHang> listLayGTTuTenKH = kh_dao.getGioiTinhTuTenKH(tenKH);
					for(KhachHang kh : listLayGTTuTenKH) {
						lblGT.setText(kh.isGioiTinh() == false ? "Nữ" : "Nam");
					}
					boolean gt = lblGT.getText() == "Nữ" ? false : true;
					List<KhachHang> listLayDiaChiTuTenKH = kh_dao.getDiaChiTuTenKH(tenKH);
					for(KhachHang kh : listLayDiaChiTuTenKH) {
						lblDC.setText(kh.getDiaChi());
					}
					String dc = lblDC.getText();
					String tenNV = cboNVKD.getSelectedItem().toString();
					List<NhanVien> listLayMaTuTenNV = hdbt_dao.getMaTuTenNV(tenNV);
					for(NhanVien nv : listLayMaTuTenNV) {
						maNV = nv.getMaNV();
					}
					String tenThuoc = cboTenThuoc.getSelectedItem().toString();
					List<Thuoc> listLayMaTuTenThuoc = thuoc_dao.getMaTuTenThuoc(tenThuoc);
					for(Thuoc t : listLayMaTuTenThuoc) {
						maThuoc = t.getMaThuoc();
					}
					String dvt = cboDonViTinh.getSelectedItem().toString();
					int sl = Integer.parseInt(txtSoLuong.getText());
					long millis = System.currentTimeMillis();
					Date nlhd = new Date(millis);
					List<Thuoc> listLayGiaTuTenThuoc = thuoc_dao.getGiaTuTenThuoc(tenThuoc);
					double gia = 0;
					for(Thuoc t : listLayGiaTuTenThuoc) {
						gia = t.getGiaThuoc();
					}
					double thanhTien = sl * gia;
					
					HoaDonBanThuoc hdbt = new HoaDonBanThuoc(ma, new KhachHang(maKH, "", ""), new KhachHang(tenKH), new KhachHang(ns), new KhachHang(gt), new KhachHang(dc, ""), new NhanVien(maNV, ""), new NhanVien(tenNV), new Thuoc(maThuoc, "", "", "", "", ""), new Thuoc(tenThuoc, "", "", ""), new Thuoc(dvt), sl, nlhd, thanhTien);
					
					if(!hdbt_dao.create(hdbt))
						JOptionPane.showMessageDialog(pnChinh, "Mã hóa đơn đã tồn tại");
					else {
						modelHD.addRow(new Object[] {
								hdbt.getTenThuoc().getTenThuoc(), hdbt.getDonViTinh().getDonViTinh(),
								hdbt.getSoLuong(), hdbt.getThanhTien()
						});
						
						lblMHD.setText(hdbt.getMaHoaDon());
						lblHTKH.setText(hdbt.getHoTenKH().getHoTenKH());
						lblNVKD.setText(hdbt.getTenNV().getHoTenNV());
						lblNKD.setText(hdbt.getNgayLap().toString());
						lblTongTien.setText(Double.toString(getSum()));
						JOptionPane.showMessageDialog(pnChinh, "Thêm thành công");
					}
				}
			}

			private double getSum() {
				double tongTien = 0;
				int n = tableCTHD.getRowCount();
				for(int i = 0 ; i < n; i++) {
					tongTien = tongTien + Double.parseDouble(modelHD.getValueAt(i, 3).toString());
				}
				return tongTien;
			}

			private boolean validData() {
				String ma = txtMaHoaDon.getText().trim();	
				String sl = txtSoLuong.getText().trim();
			
				
				if(!(ma.length() > 0)) {
					showMessage("Mã hóa đơn không được để trống", txtMaHoaDon);
					return false;
				}
				else if(!(ma.matches("^(HD)[0-9]+"))) {
					showMessage("Mã hóa đơn phải bắt đầu bằng HD theo sau là số", txtMaHoaDon);
					return false;
				}
					
				if(!(sl.length() > 0)){
					showMessage("Số lượng không được để trống", txtSoLuong);
				}
				else if(sl.length() > 0) {
					try {
						int x = Integer.parseInt(sl);
						if(!(x > 0)){
							showMessage("Số lượng phải lớn hơn 0", txtSoLuong);
							return false;
						}
						
					} catch (NumberFormatException e) {
						showMessage("Số lượng phải nhập số", txtSoLuong);
						return false;
					}	
				}
				
				return true;
			}
		});
		
		JPanel pnBangCTHD = new JPanel();
		pnBangCTHD.setBorder(new TitledBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 99, 71)), "Y\u00EAu c\u1EA7u kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnBangCTHD.setBounds(421, 230, 755, 392);
		pnChinh.add(pnBangCTHD);
		pnBangCTHD.setLayout(null);
		
		JScrollPane scrollPaneCTHD = new JScrollPane();
		scrollPaneCTHD.setBounds(10, 14, 735, 331);
		pnBangCTHD.add(scrollPaneCTHD);
		
		tableCTHD = new JTable();
		tableCTHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableCTHD.getSelectedRow();
				cboTenThuoc.setSelectedItem(modelHD.getValueAt(row, 0).toString());
				cboDonViTinh.setSelectedItem(modelHD.getValueAt(row, 1).toString());
				txtSoLuong.setText(modelHD.getValueAt(row, 2).toString());
			}
		});
		tableCTHD.setModel(modelHD = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn thu\u1ED1c", "\u0110\u01A1n v\u1ECB t\u00EDnh", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n"
			}
		));
		tableCTHD.getColumnModel().getColumn(0).setPreferredWidth(106);
		tableCTHD.getColumnModel().getColumn(1).setPreferredWidth(60);
		tableCTHD.getColumnModel().getColumn(2).setPreferredWidth(60);
		scrollPaneCTHD.setViewportView(tableCTHD);
		
		JLabel lblTT = new JLabel("TỔNG TIỀN:");
		lblTT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTT.setBounds(520, 356, 110, 25);
		pnBangCTHD.add(lblTT);
		
		lblTongTien = new JLabel(".........");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongTien.setBounds(635, 356, 110, 25);
		pnBangCTHD.add(lblTongTien);
		setLocationRelativeTo(null);
		
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnXoaTrang)) {
					txtMaHoaDon.setText("");
					txtSoLuong.setText("");
					txtMaHoaDon.requestFocus();
					cboTenThuoc.setSelectedItem("");
					cboHoTenKH.setSelectedItem("");
					cboNVKD.setSelectedItem("");
					XoaHetDuLieuTable();
					lblDC.setText("...........");
					lblGT.setText("...........");
					lblNVKD.setText("...........");
					lblNKD.setText("...........");
					lblNS.setText("...........");
					lblMHD.setText("...........");
					lblHTKH.setText("...........");
					lblTongTien.setText("...........");
				}
			}
		});
	}
	private void XoaHetDuLieuTable() {
		DefaultTableModel dtm = (DefaultTableModel) tableCTHD.getModel();
		dtm.setRowCount(0);
	}
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtThongBao.setText(message);
	}
}
