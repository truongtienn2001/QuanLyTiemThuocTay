package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDonBanThuoc;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;

public class HoaDonBanThuoc_DAO {
	
	public ArrayList<NhanVien> getTenNV(){
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select Distinct hoTenNV from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ten = rs.getString("hoTenNV");
				
				NhanVien nv = new NhanVien(ten);
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}	
	
	public ArrayList<HoaDonBanThuoc> getAllDSHD(){
		ArrayList<HoaDonBanThuoc> dsHDBT = new ArrayList<HoaDonBanThuoc>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDonBanThuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				String maKH = rs.getString("maKH");
				String hoTenKH = rs.getString("hoTenKH");
				Date ngaySinhKH = rs.getDate("ngaySinhKH");
				Boolean gioiTinhKH = rs.getBoolean("gioiTinhKH");
				String diaChiKH = rs.getString("diaChiKH");
				String maNV = rs.getString("maNV");
				String tenNV = rs.getString("hoTenNV");
				String maThuoc = rs.getString("maThuoc");
				String tenThuoc = rs.getString("tenThuoc");
				String donViTinh = rs.getString("donViTinh");
				int soLuong = rs.getInt("soLuong");
				Date ngayLap = rs.getDate("ngayLap");
				double thanhTien = rs.getDouble("thanhTien");
				HoaDonBanThuoc hdbt = new HoaDonBanThuoc(maHoaDon, new KhachHang(maKH, "", ""), new KhachHang(hoTenKH), new KhachHang(ngaySinhKH), new KhachHang(gioiTinhKH), new KhachHang(diaChiKH, ""), new NhanVien(maNV, ""), new NhanVien(tenNV), new Thuoc(maThuoc, "", "", "", "", ""), new Thuoc(tenThuoc, "", "", ""), new Thuoc(donViTinh), soLuong, ngayLap, thanhTien);
				dsHDBT.add(hdbt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHDBT;
	}
	
	public ArrayList<HoaDonBanThuoc> getDSHDTheoNgayLap(String nl){
		ArrayList<HoaDonBanThuoc> dsHDBT = new ArrayList<HoaDonBanThuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = null;
		String sql = "Select * from HoaDonBanThuoc where ngayLap = '" + nl + "'";
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				String maKH = rs.getString("maKH");
				String hoTenKH = rs.getString("hoTenKH");
				Date ngaySinhKH = rs.getDate("ngaySinhKH");
				Boolean gioiTinhKH = rs.getBoolean("gioiTinhKH");
				String diaChiKH = rs.getString("diaChiKH");
				String maNV = rs.getString("maNV");
				String tenNV = rs.getString("hoTenNV");
				String maThuoc = rs.getString("maThuoc");
				String tenThuoc = rs.getString("tenThuoc");
				String donViTinh = rs.getString("donViTinh");
				int soLuong = rs.getInt("soLuong");
				Date ngayLap = rs.getDate("ngayLap");
				double thanhTien = rs.getDouble("thanhTien");
				HoaDonBanThuoc hdbt = new HoaDonBanThuoc(maHoaDon, new KhachHang(maKH, "", ""), new KhachHang(hoTenKH), new KhachHang(ngaySinhKH), new KhachHang(gioiTinhKH), new KhachHang(diaChiKH, ""), new NhanVien(maNV, ""), new NhanVien(tenNV), new Thuoc(maThuoc, "", "", "", "", ""), new Thuoc(tenThuoc, "", "", ""), new Thuoc(donViTinh), soLuong, ngayLap, thanhTien);
				dsHDBT.add(hdbt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsHDBT;
	}
	
	public ArrayList<HoaDonBanThuoc> getNgayLap(){
		ArrayList<HoaDonBanThuoc> dsHDBT = new ArrayList<HoaDonBanThuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select distinct ngayLap from HoaDonBanThuoc";
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Date nl = rs.getDate("ngayLap");
				HoaDonBanThuoc hdbt = new HoaDonBanThuoc(nl);
				dsHDBT.add(hdbt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsHDBT;
	}
	
	public ArrayList<NhanVien> getMaTuTenNV(String ten){
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select maNV from NhanVien where hoTenNV LIKE N'%" + ten +"%'";
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maNV");
				NhanVien nv = new NhanVien(ma, "");
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsNV;
	}
	
	public boolean create(HoaDonBanThuoc h) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into HoaDonBanThuoc values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, h.getMaHoaDon());
			stmt.setString(2, h.getMaKH().getMaKH());
			stmt.setString(3, h.getHoTenKH().getHoTenKH());
			stmt.setDate(4, h.getNgaySinhKH().getNgaySinhKH());
			stmt.setBoolean(5, h.getGioiTinhKH().isGioiTinh());
			stmt.setString(6, h.getDiaChiKH().getDiaChi());
			stmt.setString(7, h.getMaNV().getMaNV());
			stmt.setString(8, h.getTenNV().getHoTenNV());
			stmt.setString(9, h.getMaThuoc().getMaThuoc());
			stmt.setString(10, h.getTenThuoc().getTenThuoc());
			stmt.setString(11, h.getDonViTinh().getDonViTinh());
			stmt.setInt(12, h.getSoLuong());
			stmt.setDate(13, h.getNgayLap());
			stmt.setDouble(14, h.getThanhTien());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean delete(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "DELETE FROM HoaDonBanThuoc WHERE maHoaDon = '" + ma + "'";
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return n > 0;
	}
}
