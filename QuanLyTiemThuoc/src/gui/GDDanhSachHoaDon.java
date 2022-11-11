package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import connectDB.ConnectDB;
import dao.HoaDonBanThuoc_DAO;
import entity.HoaDonBanThuoc;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GDDanhSachHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableDSHD;
	private DefaultTableModel modelDSHD;
	private HoaDonBanThuoc_DAO hdbt_dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDDanhSachHoaDon frame = new GDDanhSachHoaDon();
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
	public GDDanhSachHoaDon() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		hdbt_dao = new HoaDonBanThuoc_DAO();
		
		setTitle("DANH SÁCH HÓA ĐƠN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel pnChinh = new JPanel();
		pnChinh.setBackground(Color.PINK);
		pnChinh.setBounds(0, 0, 1184, 631);
		contentPane.add(pnChinh);
		pnChinh.setLayout(null);
		
		JComboBox<String> cboTim = new JComboBox<String>();
		cboTim.setToolTipText("Ngày lập hóa đơn");
		cboTim.setBounds(943, 14, 190, 28);
		pnChinh.add(cboTim);
		cboTim.setEditable(true);
		cboTim.setSelectedItem("");
		ArrayList<HoaDonBanThuoc> listTimKiemTheoNgayLap = hdbt_dao.getNgayLap(); 
		for(HoaDonBanThuoc hdbt : listTimKiemTheoNgayLap) {
			cboTim.addItem(hdbt.getNgayLap().toString());
		}
		AutoCompleteDecorator.decorate(cboTim);
		
		JLabel lblTim = new JLabel("Tìm theo ngày lập hóa đơn: ");
		lblTim.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTim.setBounds(740, 13, 202, 30);
		pnChinh.add(lblTim);
		
		JLabel lblTimKiem = new JLabel("");
		lblTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaHetDuLieuTable();
				List<HoaDonBanThuoc> list = hdbt_dao.getDSHDTheoNgayLap(cboTim.getSelectedItem().toString());
				cboTim.setSelectedItem("");
				for(HoaDonBanThuoc hdbt : list) {
					modelDSHD.addRow(new Object[] {
							hdbt.getMaHoaDon(), hdbt.getHoTenKH().getHoTenKH(),
							hdbt.getNgaySinhKH().getNgaySinhKH(), hdbt.getGioiTinhKH().isGioiTinh() == false ? "Nữ" : "Nam",
							hdbt.getDiaChiKH().getDiaChi(), hdbt.getTenNV().getHoTenNV(),
							hdbt.getTenThuoc().getTenThuoc(), hdbt.getDonViTinh().getDonViTinh(),
							hdbt.getSoLuong(), hdbt.getNgayLap(), hdbt.getThanhTien()
					});
				}
			}
		});
		lblTimKiem.setBounds(1144, 12, 30, 30);
		pnChinh.add(lblTimKiem);
		Image img_Tim = new ImageIcon(this.getClass().getResource("/img/timkiem.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		lblTimKiem.setIcon(new ImageIcon(img_Tim));
		
		JPanel pnBang = new JPanel();
		pnBang.setBounds(0, 53, 1184, 578);
		pnChinh.add(pnBang);
		pnBang.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1184, 577);
		pnBang.add(scrollPane);
		
		tableDSHD = new JTable();
		tableDSHD.setModel(modelDSHD = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "H\u1ECD t\u00EAn kh\u00E1ch h\u00E0ng", "Ng\u00E0y sinh kh\u00E1ch h\u00E0ng", "Gi\u1EDBi t\u00EDnh kh\u00E1ch h\u00E0ng", "\u0110\u1ECBa ch\u1EC9 kh\u00E1ch h\u00E0ng", "H\u1ECD t\u00EAn nh\u00E2n vi\u00EAn", "T\u00EAn thu\u1ED1c", "\u0110\u01A1n v\u1ECB t\u00EDnh", "S\u1ED1 l\u01B0\u1EE3ng", "Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "Th\u00E0nh ti\u1EC1n"
			}
		));
		tableDSHD.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableDSHD.getColumnModel().getColumn(1).setPreferredWidth(138);
		tableDSHD.getColumnModel().getColumn(2).setPreferredWidth(125);
		tableDSHD.getColumnModel().getColumn(3).setPreferredWidth(116);
		tableDSHD.getColumnModel().getColumn(4).setPreferredWidth(175);
		tableDSHD.getColumnModel().getColumn(5).setPreferredWidth(138);
		tableDSHD.getColumnModel().getColumn(6).setPreferredWidth(138);
		tableDSHD.getColumnModel().getColumn(8).setPreferredWidth(60);
		tableDSHD.getColumnModel().getColumn(9).setPreferredWidth(120);
		
		DocDuLieuVaoBang();
		scrollPane.setViewportView(tableDSHD);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GDLapHoaDon lhd = new GDLapHoaDon();
				lhd.setVisible(true);
				dispose();
			}
		});
		btnQuayLai.setForeground(Color.BLACK);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnQuayLai.setBackground(UIManager.getColor("Button.darkShadow"));
		btnQuayLai.setBounds(10, 12, 159, 33);
		btnQuayLai.setMnemonic(KeyEvent.VK_Q);
		btnQuayLai.setToolTipText("Bấm ALT + Q");
		pnChinh.add(btnQuayLai);
		Image img_QuayLai = new ImageIcon(this.getClass().getResource("/img/quaylai.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		btnQuayLai.setIcon(new ImageIcon(img_QuayLai));
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnXoa)) {
					int row = tableDSHD.getSelectedRow();
					if(row == -1)
						JOptionPane.showMessageDialog(pnChinh, "Bạn chưa chọn dòng để xóa");
					else {
						int xoa;
						xoa = JOptionPane.showConfirmDialog(pnChinh, "Bạn có muốn xóa dòng đã chọn?", "Nhắc nhở", JOptionPane.YES_NO_OPTION);
						if(xoa == JOptionPane.YES_OPTION) {
							String ma = modelDSHD.getValueAt(row, 0).toString();
							hdbt_dao.delete(ma);
							modelDSHD.removeRow(row);
							JOptionPane.showMessageDialog(pnChinh, "Xóa thành công");
							cboTim.removeItem(cboTim.getSelectedItem());
						}
					}
				}
			}
		});
		Image img_Xoa = new ImageIcon(this.getClass().getResource("/img/xoa.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		btnXoa.setIcon(new ImageIcon(img_Xoa));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnXoa.setBackground(UIManager.getColor("Button.background"));
		btnXoa.setBounds(179, 12, 159, 33);
		btnXoa.setMnemonic(KeyEvent.VK_X);
		btnXoa.setToolTipText("Bấm ALT + X");
		pnChinh.add(btnXoa);
		
		JButton btnLamMoi = new JButton("Làm mới danh sách");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnLamMoi)) {
					XoaHetDuLieuTable();
					DocDuLieuVaoBang();
				}
			}
		});
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnLamMoi.setBackground(UIManager.getColor("Button.background"));
		btnLamMoi.setBounds(350, 12, 268, 33);
		btnLamMoi.setMnemonic(KeyEvent.VK_L);
		btnLamMoi.setToolTipText("Bấm ALT + L");
		pnChinh.add(btnLamMoi);
		Image h_LamMoi = new ImageIcon(this.getClass().getResource("/img/lammoids.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		btnLamMoi.setIcon(new ImageIcon(h_LamMoi));
	}

	private void DocDuLieuVaoBang() {
		List<HoaDonBanThuoc> list = hdbt_dao.getAllDSHD();
		for(HoaDonBanThuoc hdbt : list) {
			modelDSHD.addRow(new Object[] {
					hdbt.getMaHoaDon(), hdbt.getHoTenKH().getHoTenKH(),
					hdbt.getNgaySinhKH().getNgaySinhKH(), hdbt.getGioiTinhKH().isGioiTinh() == false ? "Nữ" : "Nam",
					hdbt.getDiaChiKH().getDiaChi(), hdbt.getTenNV().getHoTenNV(),
					hdbt.getTenThuoc().getTenThuoc(), hdbt.getDonViTinh().getDonViTinh(),
					hdbt.getSoLuong(), hdbt.getNgayLap(), hdbt.getThanhTien()
			});
		}
	}
	private void XoaHetDuLieuTable() {
		DefaultTableModel dtm = (DefaultTableModel) tableDSHD.getModel();
		dtm.setRowCount(0);
	}
}
