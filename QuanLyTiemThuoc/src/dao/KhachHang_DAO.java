package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getTatCaKH(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maKH");
				String ten = rs.getString("hoTenKH");
				Date ns = rs.getDate("ngaySinhKH");
				boolean gt = rs.getBoolean("gioiTinhKH");
				String dc = rs.getString("diaChiKH");
				KhachHang kh = new KhachHang(ma, ten, ns, gt, dc);
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	
	public ArrayList<KhachHang> getCboThongTinKH(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select hoTenKH, ngaySinhKH, diaChiKH from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ten = rs.getString("hoTenKH");
				Date ns = rs.getDate("ngaySinhKH");
				String dc = rs.getString("diaChiKH");
				KhachHang kh = new KhachHang(ten, ns, dc);
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}

	public ArrayList<KhachHang> getGioiTinhTuTenKH(String ten){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select gioiTinhKH from KhachHang where hoTenKH LIKE N'%" + ten +"%'";
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Boolean gt = rs.getBoolean("gioiTinhKH");
				KhachHang kh = new KhachHang(gt);
				dsKH.add(kh);
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
		return dsKH;
	}

	public ArrayList<KhachHang> getMaTuTenKH(String ten){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select maKH from KhachHang where hoTenKH LIKE N'%" + ten +"%'";
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maKH");
				KhachHang kh = new KhachHang(ma, "", "");
				dsKH.add(kh);
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
		return dsKH;
	}
	
	public ArrayList<KhachHang> getNgaySinhTuTenKH(String ten){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select ngaySinhKH from KhachHang where hoTenKH LIKE N'%" + ten +"%'";
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Date ns = rs.getDate("ngaySinhKH");
				KhachHang kh = new KhachHang(ns);
				dsKH.add(kh);
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
		return dsKH;
	}
	
	public ArrayList<KhachHang> getDiaChiTuTenKH(String ten){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select diaChiKH from KhachHang where hoTenKH LIKE N'%" + ten +"%'";
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String dc = rs.getString("diaChiKH");
				KhachHang kh = new KhachHang(dc, "");
				dsKH.add(kh);
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
		return dsKH;
	}
	
	public boolean create(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into KhachHang values(?, ?, ?, ?, ?)";
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getHoTenKH());
			stmt.setDate(3, kh.getNgaySinhKH());
			stmt.setBoolean(4, kh.isGioiTinh());
			stmt.setString(5, kh.getDiaChi());
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
		String sql = "DELETE FROM KhachHang WHERE maKH = '" + ma + "'";
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

	public boolean update(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhachHang set maKH = ?, hoTenKH = ?, ngaySinhKH = ?, gioiTinhKH = ?, diaChiKH = ? WHERE maKH = ?");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getHoTenKH());
			stmt.setDate(3, kh.getNgaySinhKH());
			stmt.setBoolean(4, kh.isGioiTinh());
			stmt.setString(5, kh.getDiaChi());
			stmt.setString(6, kh.getMaKH());
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