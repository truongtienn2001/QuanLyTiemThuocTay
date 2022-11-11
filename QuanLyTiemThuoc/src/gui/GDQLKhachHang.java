package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entity.KhachHang;
import util.DateUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GDQLKhachHang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtNgaySinh;
	private JTextField txtDiaChi;
	private JTable tableKhachHang;
	private JTextField txtMaKH;
	private KhachHang_DAO kh_dao;
	private DefaultTableModel modelKhachHang;
	private JTextField txtThongBao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDQLKhachHang frame = new GDQLKhachHang();
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
	public GDQLKhachHang() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		kh_dao = new KhachHang_DAO();
		
		setTitle("QUẢN LÝ KHÁCH HÀNG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1188, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel pnChinh = new JPanel();
		pnChinh.setBackground(new Color(135, 206, 235));
		pnChinh.setBounds(0, 0, 1184, 631);
		contentPane.add(pnChinh);
		pnChinh.setLayout(null);
		
		JButton btnQuayLai = new JButton("QUAY LẠI");
		btnQuayLai.setBounds(928, 11, 173, 80);
		btnQuayLai.setForeground(new Color(139, 0, 0));
		btnQuayLai.setBackground(new Color(100, 149, 237));
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQuayLai.setMnemonic(KeyEvent.VK_Q);
		btnQuayLai.setToolTipText("Bấm Alt + Q");
		pnChinh.add(btnQuayLai);
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GDChinh chinh = new GDChinh();
				chinh.setVisible(true);
				dispose();
			}
		});
		Image img_QuayLai = new ImageIcon(this.getClass().getResource("/img/quaylai.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		btnQuayLai.setIcon(new ImageIcon(img_QuayLai));
		
		JLabel lblTenKH = new JLabel("Họ và tên khách hàng:");
		lblTenKH.setBounds(91, 47, 146, 24);
		lblTenKH.setForeground(new Color(0, 0, 205));
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnChinh.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(247, 50, 264, 20);
		pnChinh.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setBounds(91, 78, 146, 24);
		lblNgaySinh.setForeground(new Color(0, 0, 205));
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnChinh.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(247, 81, 95, 20);
		txtNgaySinh.setColumns(10);
		pnChinh.add(txtNgaySinh);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(91, 110, 146, 24);
		lblGioiTinh.setForeground(new Color(0, 0, 205));
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnChinh.add(lblGioiTinh);
		
		JComboBox<String> cboGioiTinh = new JComboBox<String>();
		cboGioiTinh.setBounds(247, 112, 95, 22);
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("Nữ");
		pnChinh.add(cboGioiTinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(91, 142, 146, 24);
		lblDiaChi.setForeground(new Color(0, 0, 205));
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnChinh.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(247, 145, 264, 20);
		txtDiaChi.setColumns(10);
		pnChinh.add(txtDiaChi);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnThem)) {
					if(validData()) {
						String ma = txtMaKH.getText();
						String ten = txtTenKH.getText();
						Date ns = Date.valueOf(txtNgaySinh.getText());
						boolean gt = cboGioiTinh.getSelectedItem() == "Nữ" ? false : true;
						String dc = txtDiaChi.getText();
						KhachHang kh = new KhachHang(ma, ten, ns, gt, dc);
						if(!kh_dao.create(kh))
							JOptionPane.showMessageDialog(pnChinh, "Mã khách hàng đã tồn tại");
						else {
							modelKhachHang.addRow(new Object[] {
									kh.getMaKH(), kh.getHoTenKH(), kh.getNgaySinhKH(),
									kh.isGioiTinh() == false ? "Nữ" : "Nam", kh.getDiaChi()
							});
							JOptionPane.showMessageDialog(pnChinh, "Thêm thành công");
						}
					}
				}
			}

			
		});
		btnThem.setBounds(561, 11, 173, 80);
		btnThem.setForeground(new Color(139, 0, 0));
		btnThem.setBackground(new Color(100, 149, 237));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setMnemonic(KeyEvent.VK_T);
		btnThem.setToolTipText("Bấm Alt + T");
		pnChinh.add(btnThem);
		Image img_Them= new ImageIcon(this.getClass().getResource("/img/themthuoc.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		btnThem.setIcon(new ImageIcon(img_Them));
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnXoa)) {
					int row = tableKhachHang.getSelectedRow();
					if(row == -1)
						JOptionPane.showMessageDialog(pnChinh, "Bạn chưa chọn dòng để xóa");
					else {
						int xoa;
						xoa = JOptionPane.showConfirmDialog(pnChinh, "Bạn có muốn xóa dòng đã chọn?", "Nhắc nhở", JOptionPane.YES_NO_OPTION);
						if(xoa == JOptionPane.YES_OPTION) {
							modelKhachHang.removeRow(row);
							String ma = txtMaKH.getText();
							kh_dao.delete(ma);
							JOptionPane.showMessageDialog(pnChinh, "Xóa thành công");
							txtMaKH.setText("");
							txtTenKH.setText("");
							txtDiaChi.setText("");
							txtNgaySinh.setText("");
							txtMaKH.requestFocus();
						}
					}
				}
			}
		});
		btnXoa.setBounds(745, 102, 173, 80);
		btnXoa.setForeground(new Color(139, 0, 0));
		btnXoa.setBackground(new Color(100, 149, 237));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setMnemonic(KeyEvent.VK_X);
		btnXoa.setToolTipText("Bấm Alt + X");
		pnChinh.add(btnXoa);
		Image img_Xoa = new ImageIcon(this.getClass().getResource("/img/xoa.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		btnXoa.setIcon(new ImageIcon(img_Xoa));
		
		JButton btnXoaTrang = new JButton("XÓA TRẮNG");
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnXoaTrang)) {
					txtMaKH.setText("");
					txtTenKH.setText("");
					txtDiaChi.setText("");
					txtNgaySinh.setText("");
					txtMaKH.requestFocus();
					txtMaKH.setEditable(true);
				}
			}
		});
		btnXoaTrang.setBounds(745, 11, 173, 80);
		btnXoaTrang.setForeground(new Color(139, 0, 0));
		btnXoaTrang.setBackground(new Color(100, 149, 237));
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaTrang.setMnemonic(KeyEvent.VK_R);
		btnXoaTrang.setToolTipText("Bấm Alt + R");
		pnChinh.add(btnXoaTrang);
		Image img_XoaTrang = new ImageIcon(this.getClass().getResource("/img/xoatrang.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		btnXoaTrang.setIcon(new ImageIcon(img_XoaTrang));
		
		JButton btnSua = new JButton("SỬA");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validData()) {
					int row = tableKhachHang.getSelectedRow();
					if(row < 0)
					{
						return;
					}
					modelKhachHang.setValueAt(txtMaKH.getText().trim(), row, 0);
					modelKhachHang.setValueAt(txtTenKH.getText().trim(), row, 1);
					modelKhachHang.setValueAt(txtNgaySinh.getText().trim(), row, 2);
					modelKhachHang.setValueAt(cboGioiTinh.getSelectedItem().toString(), row, 3);
					modelKhachHang.setValueAt(txtDiaChi.getText().trim(), row, 4);

					
					KhachHang kh = new KhachHang();
					kh.setMaKH(txtMaKH.getText().trim());
					kh.setHoTenKH(txtTenKH.getText().trim());
					Date nskh = Date.valueOf(txtNgaySinh.getText());
					kh.setNgaySinhKH(nskh);
					kh.setGioiTinh(cboGioiTinh.getSelectedItem() == "Nữ" ? false : true);
					kh.setDiaChi(txtDiaChi.getText().trim());
					
					kh_dao.update(kh);
				}	
			}
		});
		btnSua.setBounds(561, 102, 173, 80);
		btnSua.setForeground(new Color(139, 0, 0));
		btnSua.setBackground(new Color(100, 149, 237));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setMnemonic(KeyEvent.VK_S);
		btnSua.setToolTipText("Bấm Alt + S");
		pnChinh.add(btnSua);
		Image img_Sua = new ImageIcon(this.getClass().getResource("/img/sua.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		btnSua.setIcon(new ImageIcon(img_Sua));
		
		JPanel pnBang = new JPanel();
		pnBang.setBounds(0, 193, 1184, 438);
		pnChinh.add(pnBang);
		pnBang.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1184, 438);
		pnBang.add(scrollPane);
		
		tableKhachHang = new JTable();
		tableKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableKhachHang.getSelectedRow();
				txtMaKH.setText(modelKhachHang.getValueAt(row, 0).toString());
				txtTenKH.setText(modelKhachHang.getValueAt(row, 1).toString());
				txtNgaySinh.setText(modelKhachHang.getValueAt(row, 2).toString());
				cboGioiTinh.setSelectedItem(modelKhachHang.getValueAt(row, 3));
				txtDiaChi.setText(modelKhachHang.getValueAt(row, 4).toString());
				txtMaKH.setEditable(false);
			}
		});
		tableKhachHang.setModel(modelKhachHang = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 ", "H\u1ECC V\u00C0 T\u00CAN", "NG\u00C0Y SINH", "GI\u1EDAI T\u00CDNH", "\u0110\u1ECAA CH\u1EC8"
			}
		));
		tableKhachHang.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableKhachHang.getColumnModel().getColumn(1).setPreferredWidth(209);
		tableKhachHang.getColumnModel().getColumn(2).setPreferredWidth(30);
		tableKhachHang.getColumnModel().getColumn(3).setPreferredWidth(15);
		tableKhachHang.getColumnModel().getColumn(4).setPreferredWidth(220);
		
		DocDuLieuDBVaoTable();
		scrollPane.setViewportView(tableKhachHang);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setForeground(new Color(0, 0, 205));
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaKH.setBounds(91, 16, 146, 24);
		pnChinh.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(247, 19, 95, 20);
		pnChinh.add(txtMaKH);
		
		JButton btnLapHD = new JButton("LẬP HÓA ĐƠN");
		btnLapHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GDLapHoaDon lhd = new GDLapHoaDon();
				lhd.setVisible(true);
				dispose();
			}
		});
		btnLapHD.setForeground(new Color(139, 0, 0));
		btnLapHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLapHD.setBackground(new Color(100, 149, 237));
		btnLapHD.setBounds(928, 102, 173, 80);
		btnLapHD.setMnemonic(KeyEvent.VK_L);
		btnLapHD.setToolTipText("Bấm Alt + L");
		Image img_IconLapHD = new ImageIcon(this.getClass().getResource("/img/qlkhachhang.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		btnLapHD.setIcon(new ImageIcon(img_IconLapHD));
		pnChinh.add(btnLapHD);
		
		txtThongBao = new JTextField();
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtThongBao.setEditable(false);
		txtThongBao.setBorder(null);
		txtThongBao.setBackground(new Color(135, 206, 235));
		txtThongBao.setBounds(91, 175, 379, 19);
		pnChinh.add(txtThongBao);
	}

	private void DocDuLieuDBVaoTable() {
		List<KhachHang> list = kh_dao.getTatCaKH();
		for(KhachHang kh : list) {
			modelKhachHang.addRow(new Object[] {
					kh.getMaKH(), kh.getHoTenKH(), kh.getNgaySinhKH(),
					kh.isGioiTinh() == false ? "Nữ" : "Nam", kh.getDiaChi()
			});
		}
	}
	private boolean validData() {
		String ma = txtMaKH.getText();
		String ten = txtTenKH.getText();
		String ns = txtNgaySinh.getText();
		String dc = txtDiaChi.getText();


		if(!(ma.length() > 0)) {
			showMessage("Mã khách hàng không được để trống", txtMaKH);
			return false;
		}
		else if(!(ma.matches("^(KH)[0-9]+"))) {
			showMessage("Mã khách hàng phải bắt đầu bằng KH theo sau là số", txtMaKH);
			return false;
		}
		if(!(ten.length() > 0)) {
			showMessage("Tên khách hàng không được để trống", txtTenKH);
			return false;
		}
		else if(!(ten.matches("[^&%$#@!~_',/\\.?();]*"))) {
			showMessage("Tên KH không được nhập ký tự đặc biệt", txtTenKH);
			return false;
		}

		if(!DateUtil.validDate(ns)) {
			showMessage("Phải nhập ngày sinh theo dạng yyyy-mm-dd", txtNgaySinh);
			return false;
		}

		if(!(dc.length() > 0)) {
			showMessage("Địa chỉ không được để trống", txtDiaChi);
			return false;
		}
		else if(!(dc.matches("[^&%$#@!~_',\\.?();]*"))) {
			showMessage("Địa chỉ không được nhập ký tự đặc biệt", txtDiaChi);
			return false;
		}
		return true;
	}
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtThongBao.setText(message);
	}
}
