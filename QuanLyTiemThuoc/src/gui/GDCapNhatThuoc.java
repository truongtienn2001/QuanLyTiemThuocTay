package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.Thuoc_DAO;
import entity.Thuoc;
import util.DateUtil;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GDCapNhatThuoc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablecapnhat;
	private JTextField txtMaThuoc;
	private JTextField txtTenThuoc;
	private JTextField txtNhaCungCap;
	private JTextField txtGiaThuoc;
	private JTextField txtCongDung;
	private JTextField txtSoluong;
	private JTextField txtNgaySX;
	private JTextField txtNgayHetHan;
	private DefaultTableModel modelCapNhat;
	private JComboBox<String> cboDonVi;
	private Thuoc_DAO thuoc_dao;
	private JComboBox<String> cboTim; 
	private JTextField txtThongBao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDCapNhatThuoc frame = new GDCapNhatThuoc();
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
	public GDCapNhatThuoc() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		thuoc_dao = new Thuoc_DAO();
		
		setTitle("CẬP NHẬT THÔNG TIN THUỐC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel pnChinh = new JPanel();
		pnChinh.setBackground(new Color(127, 255, 212));
		pnChinh.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 99, 71)));
		pnChinh.setBounds(0, 0, 1077, 633);
		contentPane.add(pnChinh);
		pnChinh.setLayout(null);
		
		JPanel pNorth = new JPanel();
		pNorth.setBounds(22, 21, 1034, 259);
		pNorth.setBackground(new Color(245, 245, 220));
		pNorth.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 99, 71)));
		pnChinh.add(pNorth);
		pNorth.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
		});
		scrollPane.setBounds(10, 10, 1014, 239);
		pNorth.add(scrollPane);
		
		
		tablecapnhat = new JTable();
		tablecapnhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tablecapnhat.getSelectedRow();
				cboTim.setSelectedItem(modelCapNhat.getValueAt(row, 0).toString());
				txtTenThuoc.setText(modelCapNhat.getValueAt(row, 1).toString());
				txtNhaCungCap.setText(modelCapNhat.getValueAt(row, 2).toString());
				txtGiaThuoc.setText(modelCapNhat.getValueAt(row, 3).toString());
				txtCongDung.setText(modelCapNhat.getValueAt(row, 4).toString());
				txtSoluong.setText(modelCapNhat.getValueAt(row, 5).toString());
				cboDonVi.setSelectedItem(modelCapNhat.getValueAt(row, 6).toString());
				txtNgaySX.setText(modelCapNhat.getValueAt(row, 7).toString());
				txtNgayHetHan.setText(modelCapNhat.getValueAt(row, 8).toString());
			}
		});
		tablecapnhat.setFont(new Font("Tahoma", Font.BOLD, 13 ));
		tablecapnhat.setModel(modelCapNhat = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Thu\u1ED1c", "T\u00EAn Thu\u1ED1c", "Nh\u00E0 cung c\u1EA5p", "Gi\u00E1 thu\u1ED1c", "C\u00F4ng d\u1EE5ng", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n v\u1ECB", "Ng\u00E0y s\u1EA3n xu\u1EA5t", "Ng\u00E0y h\u1EBFt h\u1EA1n"
			}
		));
		DocDuLieuDBVaoTable();
		scrollPane.setViewportView(tablecapnhat);	
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(255, 255, 224));
		pCenter.setBounds(22, 290, 1034, 210);
		pCenter.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 99, 71)));
		pnChinh.add(pCenter);
		pCenter.setLayout(null);
		
		JLabel lblTim = new JLabel("Tìm theo mã :");
		lblTim.setBounds(22, 26, 122, 22);
		lblTim.setFont(new Font("Tahoma", Font.BOLD, 16));
		pCenter.add(lblTim);
		
		cboTim = new JComboBox<String>();
		cboTim.setBounds(154, 28, 127, 22);
		pCenter.add(cboTim);
		
		JLabel lblMaThuoc = new JLabel("Mã thuốc :");
		lblMaThuoc.setBounds(22, 59, 111, 22);
		lblMaThuoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		pCenter.add(lblMaThuoc);
		
		txtMaThuoc = new JTextField();
		txtMaThuoc.setBounds(154, 61, 220, 22);
		pCenter.add(txtMaThuoc);
		txtMaThuoc.setColumns(10);
		txtMaThuoc.setEditable(false);
		
		JLabel lblTenThuoc = new JLabel("Tên thuốc : ");
		lblTenThuoc.setBounds(22, 92, 112, 24);
		lblTenThuoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		pCenter.add(lblTenThuoc);
		
		txtTenThuoc = new JTextField();
		txtTenThuoc.setBounds(154, 93, 516, 23);
		pCenter.add(txtTenThuoc);
		txtTenThuoc.setColumns(10);
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp :");
		lblNhaCungCap.setBounds(22, 124, 122, 22);
		lblNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 16));
		pCenter.add(lblNhaCungCap);
		
		txtNhaCungCap = new JTextField();
		txtNhaCungCap.setBounds(154, 125, 516, 22);
		pCenter.add(txtNhaCungCap);
		txtNhaCungCap.setColumns(10);
		
		JLabel lblGiaThuoc = new JLabel("Giá thuốc :");
		lblGiaThuoc.setBounds(706, 63, 121, 13);
		lblGiaThuoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		pCenter.add(lblGiaThuoc);
		
		txtGiaThuoc = new JTextField();
		txtGiaThuoc.setBounds(854, 58, 153, 22);
		pCenter.add(txtGiaThuoc);
		txtGiaThuoc.setColumns(10);
		
		JLabel lblCongDung = new JLabel("Công dụng :");
		lblCongDung.setBounds(22, 157, 122, 21);
		lblCongDung.setFont(new Font("Tahoma", Font.BOLD, 16));
		pCenter.add(lblCongDung);
		
		txtCongDung = new JTextField();
		txtCongDung.setBounds(154, 156, 516, 22);
		pCenter.add(txtCongDung);
		txtCongDung.setColumns(10);
		
		JLabel lblSoLuong = new JLabel("Số lượng :");
		lblSoLuong.setBounds(706, 91, 99, 22);
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		pCenter.add(lblSoLuong);
		
		txtSoluong = new JTextField();
		txtSoluong.setBounds(854, 91, 153, 22);
		pCenter.add(txtSoluong);
		txtSoluong.setColumns(10);
		
		JLabel lblDonVi = new JLabel("Đơn vị :");
		lblDonVi.setBounds(411, 59, 74, 25);
		lblDonVi.setFont(new Font("Tahoma", Font.BOLD, 16));
		pCenter.add(lblDonVi);
		
		cboDonVi = new JComboBox<String>();
		cboDonVi.setBounds(517, 62, 153, 22);
		pCenter.add(cboDonVi);
		ArrayList<Thuoc> listDonVi = thuoc_dao.getCboDonVi();
		for(Thuoc t : listDonVi) {
			cboDonVi.addItem(t.getDonViTinh());
		}
		
		
		JLabel lblNgaySX = new JLabel("Ngày sản xuất :");
		lblNgaySX.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgaySX.setBounds(706, 122, 135, 25);
		pCenter.add(lblNgaySX);
		
		txtNgaySX = new JTextField();
		txtNgaySX.setBounds(854, 123, 153, 23);
		pCenter.add(txtNgaySX);
		txtNgaySX.setColumns(10);
		
		JLabel lblNgayHetHan = new JLabel("Ngày hết hạn :");
		lblNgayHetHan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgayHetHan.setBounds(706, 158, 135, 17);
		pCenter.add(lblNgayHetHan);
		
		txtNgayHetHan = new JTextField();
		txtNgayHetHan.setBounds(854, 156, 153, 23);
		pCenter.add(txtNgayHetHan);
		txtNgayHetHan.setColumns(10);
		
		txtThongBao = new JTextField();
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtThongBao.setEditable(false);
		txtThongBao.setBorder(null);
		txtThongBao.setBackground(new Color(255, 255, 224));
		txtThongBao.setBounds(291, 27, 379, 22);
		pCenter.add(txtThongBao);
		
		JPanel pSouth = new JPanel();
		pSouth.setBackground(new Color(250, 250, 210));
		pSouth.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 99, 71)));
		pSouth.setBounds(22, 510, 1034, 102);
		pnChinh.add(pSouth);
		pSouth.setLayout(null);
		
		JButton btnSua = new JButton("Sửa");
		Image img_Sua = new ImageIcon(this.getClass().getResource("/img/sua.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btnSua.setIcon(new ImageIcon(img_Sua));
		btnSua.setForeground(new Color(199, 21, 133));
		btnSua.setBackground(new Color(255, 240, 245));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBounds(78, 32, 152, 34);
		btnSua.setMnemonic(KeyEvent.VK_S);
		btnSua.setToolTipText("Bấm Alt + S");
		pSouth.add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validData()) {
					int row = tablecapnhat.getSelectedRow();
					if(row < 0)
					{
						return;
					}
					modelCapNhat.setValueAt(txtMaThuoc.getText().trim(), row, 0);
					modelCapNhat.setValueAt(txtTenThuoc.getText().trim(), row, 1);
					modelCapNhat.setValueAt(txtNhaCungCap.getText().trim(), row, 2);
					modelCapNhat.setValueAt(txtGiaThuoc.getText().trim(), row, 3);
					modelCapNhat.setValueAt(txtCongDung.getText().trim(), row, 4);
					modelCapNhat.setValueAt(txtSoluong.getText().trim(), row, 5);
					modelCapNhat.setValueAt(cboDonVi.getSelectedItem().toString(), row, 6);
					modelCapNhat.setValueAt(txtNgaySX.getText().trim(), row, 7);
					modelCapNhat.setValueAt(txtNgayHetHan.getText().trim(), row, 8);
					
					Thuoc t = new Thuoc();
					t.setMaThuoc(txtMaThuoc.getText().trim());
					t.setTenThuoc(txtTenThuoc.getText().trim());
					t.setNhaCungCap(txtNhaCungCap.getText().trim());
					t.setGiaThuoc(Double.parseDouble(txtGiaThuoc.getText().trim()));
					t.setCongDung(txtCongDung.getText().trim());
					t.setSoLuong(Integer.parseInt(txtSoluong.getText().trim()));
					t.setDonViTinh(cboDonVi.getSelectedItem().toString());
					Date nsx = Date.valueOf(txtNgaySX.getText());
					t.setNgaySanXuat(nsx);
					Date nhh = Date.valueOf(txtNgayHetHan.getText());
					t.setNgayHetHan(nhh);
					
					thuoc_dao.update(t);
				}	
			}

			private boolean validData() {
				String ten = txtTenThuoc.getText().trim();
				String ncc = txtNhaCungCap.getText().trim();
				String gia = txtGiaThuoc.getText().trim();
				String congDung = txtCongDung.getText().trim();
				String sl = txtSoluong.getText().trim();

				String nsx = txtNgaySX.getText().trim();
				String nhh = txtNgayHetHan.getText().trim();
					
				if(!(ten.length() > 0)) {
					showMessage("Tên thuốc không được để trống", txtTenThuoc);
					return false;
				}
				else if(!(ten.matches("[^&%$#@!~_',/\\.?();]*"))) {
					showMessage("Tên thuốc không được nhập ký tự đặc biệt", txtTenThuoc);
					return false;
				}
				if(!(ncc.length() > 0)) {
					showMessage("Nhà cung cấp không được để trống", txtNhaCungCap);
					return false;
				}
				else if(!(ncc.matches("[^&%$#@!~_',/\\.?();]*"))) {
					showMessage("Nhà cung cấp không được nhập ký tự đặc biệt", txtNhaCungCap);
					return false;
				}
				if(!(gia.length()  > 0)){
					showMessage("Giá thuốc không được để trống", txtGiaThuoc);
					return false;
				}
				else if(gia.length() > 0) {
					try {
						double x = Double.parseDouble(gia);
						if(!(x > 0)){
							showMessage("Giá thuốc phải lớn hơn 0", txtGiaThuoc);
							return false;
						}
						
					} catch (NumberFormatException e) {
						showMessage("Giá thuốc phải nhập số", txtGiaThuoc);
						return false;
					}	
				}
				if(!(congDung.length() > 0)) {
					showMessage("Công dụng không được để trống", txtCongDung);
					return false;
				}
				else if(!(congDung.matches("[^&%$#@!~_',/\\.?();]*"))) {
					showMessage("Công dụng không được nhập ký tự đặc biệt", txtCongDung);
					return false;
				}
				if(!(sl.length()  > 0)){
					showMessage("Số lượng không được để trống", txtSoluong);
					return false;
				}
				else if(sl.length() > 0) {
					try {
						int x = Integer.parseInt(sl);
						if(!(x > 0)){
							showMessage("Số lượng phải lớn hơn 0", txtSoluong);
							return false;
						}
						
					} catch (NumberFormatException e) {
						showMessage("Số lượng phải nhập số", txtSoluong);
						return false;
					}	
				}
					
				if(!DateUtil.validDate(nsx)) {
					showMessage("Phải nhập nsx theo dạng yyyy-mm-dd", txtNgaySX);
					return false;
				}
				
				if(!DateUtil.validDate(nhh)) {
					showMessage("Phải nhập nhh theo dạng yyyy-mm-dd", txtNgayHetHan);
					return false;
				}	
					
				return true;	
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Object o = a.getSource();
				if(o.equals(btnXoa)) {
					int row = tablecapnhat.getSelectedRow();
					if(row == -1)
						JOptionPane.showMessageDialog(pnChinh, "Bạn chưa chọn dòng để xóa");
					else {
						int xoa;
						xoa = JOptionPane.showConfirmDialog(pnChinh, "Bạn có muốn xóa dòng đã chọn?", "Nhắc nhở", JOptionPane.YES_NO_OPTION);
						if(xoa == JOptionPane.YES_OPTION) {
							modelCapNhat.removeRow(row);
							String ma = cboTim.getSelectedItem().toString();
							thuoc_dao.delete(ma);
							JOptionPane.showMessageDialog(pnChinh, "Xóa thành công");
							cboTim.removeItem(cboTim.getSelectedItem());
						}
					}
				}
			}
		});
		Image img_Xoa = new ImageIcon(this.getClass().getResource("/img/xoa.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btnXoa.setIcon(new ImageIcon(img_Xoa));
		btnXoa.setForeground(new Color(199, 21, 133));
		btnXoa.setBackground(new Color(255, 240, 245));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoa.setBounds(326, 32, 152, 34);
		btnXoa.setMnemonic(KeyEvent.VK_X);
		btnXoa.setToolTipText("Bấm Alt + X");
		pSouth.add(btnXoa);
		
		JButton btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnXoaRong)) {
					clearTextfields();	
				}
			}

		});
		Image img_XoaRong = new ImageIcon(this.getClass().getResource("/img/xoatrang.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btnXoaRong.setIcon(new ImageIcon(img_XoaRong));
		btnXoaRong.setForeground(new Color(199, 21, 133));
		btnXoaRong.setBackground(new Color(255, 240, 245));
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoaRong.setBounds(563, 32, 152, 34);
		btnXoaRong.setMnemonic(KeyEvent.VK_R);
		btnXoaRong.setToolTipText("Bấm Alt + R");
		pSouth.add(btnXoaRong);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GDChinh chinh = new GDChinh();
				chinh.setVisible(true);
				dispose();
			}
		});
		Image img_QuayLai = new ImageIcon(this.getClass().getResource("/img/quaylai.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btnQuayLai.setIcon(new ImageIcon(img_QuayLai));
		btnQuayLai.setForeground(new Color(199, 21, 133));
		btnQuayLai.setBackground(new Color(255, 240, 245));
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuayLai.setBounds(804, 32, 152, 34);
		btnQuayLai.setMnemonic(KeyEvent.VK_Q);
		btnQuayLai.setToolTipText("Bấm Alt + Q");
		pSouth.add(btnQuayLai);
		
		//
		
		ArrayList<Thuoc> listThuoc = thuoc_dao.getThuocs();
		for(Thuoc t : listThuoc) {
			cboTim.addItem(t.getMaThuoc());
		}
		cboTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				ArrayList<Thuoc> listTimKiemThuoc = thuoc_dao.getTimKiemTheoMa(cboTim.getSelectedItem().toString());
				if(o.equals(cboTim)) {
					for(Thuoc t : listTimKiemThuoc) {
						txtMaThuoc.setText(t.getMaThuoc());
						txtTenThuoc.setText(t.getTenThuoc());
						txtNhaCungCap.setText(t.getNhaCungCap());
						txtCongDung.setText(t.getCongDung());
						txtSoluong.setText(t.getSoLuong() + "");
						txtGiaThuoc.setText(t.getGiaThuoc() + "");
						txtNgaySX.setText(t.getNgaySanXuat() + "");
						txtNgayHetHan.setText(t.getNgayHetHan() + "");
					}
					if(listTimKiemThuoc != null) {
						tablecapnhat.clearSelection();
						int index = cboTim.getSelectedIndex();
						tablecapnhat.getSelectionModel().addSelectionInterval(index, index);
					}
				}			
			}
		});	
	}
	
	private void DocDuLieuDBVaoTable() {
		List<Thuoc> list = thuoc_dao.getThuocs();
		for(Thuoc t : list) {
			
			modelCapNhat.addRow(new Object[] {
					t.getMaThuoc(), t.getTenThuoc(), t.getNhaCungCap(),
					t.getGiaThuoc(), t.getCongDung(), t.getSoLuong(),
					t.getDonViTinh(), t.getNgaySanXuat(), t.getNgayHetHan()
			});
		}
		
	}

	private void clearTextfields() {
		txtMaThuoc.setText("");
		txtTenThuoc.setText("");
		txtNhaCungCap.setText("");
		txtGiaThuoc.setText("");
		txtCongDung.setText("");
		txtSoluong.setText("");
		txtNgaySX.setText("");
		txtNgayHetHan.setText("");
		txtMaThuoc.requestFocus();
		
	}
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtThongBao.setText(message);
	}
}
