package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Thuoc;

public class Thuoc_DAO {
	
	public ArrayList<Thuoc> getThuocs(){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maThuoc = rs.getString("maThuoc");
				String tenThuoc = rs.getString("tenThuoc");
				String nhaCungCap = rs.getString("nhaCungCap");
				Double giaThuoc = rs.getDouble("giaThuoc");
				String congDung = rs.getString("congDung");
				int soLuong = rs.getInt("soLuong");
				String donViTinh = rs.getString("donViTinh");
				Date ngaySanXuat = rs.getDate("ngaySanXuat");
				Date ngayHetHan = rs.getDate("ngayHetHan");
				Thuoc t = new Thuoc(maThuoc, tenThuoc, nhaCungCap, giaThuoc, congDung, soLuong, donViTinh, ngaySanXuat, ngayHetHan);
				dsThuoc.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsThuoc;
	}
	
	public ArrayList<Thuoc> getTenThuoc(){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select distinct tenThuoc from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ten = rs.getString("tenThuoc");
				Thuoc t = new Thuoc(ten, "", "", "");
				dsThuoc.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsThuoc;
	}

	public ArrayList<Thuoc> getDVT(){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select distinct donViTinh from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String dvt = rs.getString("donViTinh");
				Thuoc t = new Thuoc(dvt, "", "", "", "");
				dsThuoc.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsThuoc;
	}
	
	public ArrayList<Thuoc> getTimKiemTheoMa(String ma){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select * from Thuoc where maThuoc = '" + ma +"'";
		try {
			stm = con.createStatement();
			ResultSet rsTimKiem = stm.executeQuery(sql);
			while(rsTimKiem.next()) {
				String maThuoc = rsTimKiem.getString("maThuoc");
				String tenThuoc = rsTimKiem.getString("tenThuoc");
				String nhaCungCap = rsTimKiem.getString("nhaCungCap");
				Double giaThuoc = rsTimKiem.getDouble("giaThuoc");
				String congDung = rsTimKiem.getString("congDung");
				int soLuong = rsTimKiem.getInt("soLuong");
				String donViTinh = rsTimKiem.getString("donViTinh");
				Date ngaySanXuat = rsTimKiem.getDate("ngaySanXuat");
				Date ngayHetHan = rsTimKiem.getDate("ngayHetHan");
				Thuoc t = new Thuoc(maThuoc, tenThuoc, nhaCungCap, giaThuoc, congDung, soLuong, donViTinh, ngaySanXuat, ngayHetHan);
				dsThuoc.add(t);
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
		return dsThuoc;
	}

	public ArrayList<Thuoc> getTimKiemTheoTen(String ten){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select * from Thuoc where tenThuoc = '" + ten +"'";
		try {
			stm = con.createStatement();
			ResultSet rsTimKiem = stm.executeQuery(sql);
			while(rsTimKiem.next()) {
				String maThuoc = rsTimKiem.getString("maThuoc");
				String tenThuoc = rsTimKiem.getString("tenThuoc");
				String nhaCungCap = rsTimKiem.getString("nhaCungCap");
				Double giaThuoc = rsTimKiem.getDouble("giaThuoc");
				String congDung = rsTimKiem.getString("congDung");
				int soLuong = rsTimKiem.getInt("soLuong");
				String donViTinh = rsTimKiem.getString("donViTinh");
				Date ngaySanXuat = rsTimKiem.getDate("ngaySanXuat");
				Date ngayHetHan = rsTimKiem.getDate("ngayHetHan");
				Thuoc t = new Thuoc(maThuoc, tenThuoc, nhaCungCap, giaThuoc, congDung, soLuong, donViTinh, ngaySanXuat, ngayHetHan);
				dsThuoc.add(t);
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
		return dsThuoc;
	}

	public ArrayList<Thuoc> getTimKiemTheoNCC(String ncc){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select * from Thuoc where nhaCungCap = '" + ncc +"'";
		try {
			stm = con.createStatement();
			ResultSet rsTimKiem = stm.executeQuery(sql);
			while(rsTimKiem.next()) {
				String maThuoc = rsTimKiem.getString("maThuoc");
				String tenThuoc = rsTimKiem.getString("tenThuoc");
				String nhaCungCap = rsTimKiem.getString("nhaCungCap");
				Double giaThuoc = rsTimKiem.getDouble("giaThuoc");
				String congDung = rsTimKiem.getString("congDung");
				int soLuong = rsTimKiem.getInt("soLuong");
				String donViTinh = rsTimKiem.getString("donViTinh");
				Date ngaySanXuat = rsTimKiem.getDate("ngaySanXuat");
				Date ngayHetHan = rsTimKiem.getDate("ngayHetHan");
				Thuoc t = new Thuoc(maThuoc, tenThuoc, nhaCungCap, giaThuoc, congDung, soLuong, donViTinh, ngaySanXuat, ngayHetHan);
				dsThuoc.add(t);
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
		return dsThuoc;
	}

	public ArrayList<Thuoc> getTimKiemTheoDonVi(String donVi){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select * from Thuoc where donViTinh LIKE N'%" + donVi + "%'";
		try {
			stm = con.createStatement();
			ResultSet rsTimKiem = stm.executeQuery(sql);
			while(rsTimKiem.next()) {
				String maThuoc = rsTimKiem.getString("maThuoc");
				String tenThuoc = rsTimKiem.getString("tenThuoc");
				String nhaCungCap = rsTimKiem.getString("nhaCungCap");
				Double giaThuoc = rsTimKiem.getDouble("giaThuoc");
				String congDung = rsTimKiem.getString("congDung");
				int soLuong = rsTimKiem.getInt("soLuong");
				String donViTinh = rsTimKiem.getString("donViTinh");
				Date ngaySanXuat = rsTimKiem.getDate("ngaySanXuat");
				Date ngayHetHan = rsTimKiem.getDate("ngayHetHan");
				Thuoc t = new Thuoc(maThuoc, tenThuoc, nhaCungCap, giaThuoc, congDung, soLuong, donViTinh, ngaySanXuat, ngayHetHan);
				dsThuoc.add(t);
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
		return dsThuoc;
	}

	public ArrayList<Thuoc> getTimKiemTheoCongDung(String cDung){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select * from Thuoc where congDung LIKE N'%" + cDung +"%'";
		try {
			stm = con.createStatement();
			ResultSet rsTimKiem = stm.executeQuery(sql);
			while(rsTimKiem.next()) {
				String maThuoc = rsTimKiem.getString("maThuoc");
				String tenThuoc = rsTimKiem.getString("tenThuoc");
				String nhaCungCap = rsTimKiem.getString("nhaCungCap");
				Double giaThuoc = rsTimKiem.getDouble("giaThuoc");
				String congDung = rsTimKiem.getString("congDung");
				int soLuong = rsTimKiem.getInt("soLuong");
				String donViTinh = rsTimKiem.getString("donViTinh");
				Date ngaySanXuat = rsTimKiem.getDate("ngaySanXuat");
				Date ngayHetHan = rsTimKiem.getDate("ngayHetHan");
				Thuoc t = new Thuoc(maThuoc, tenThuoc, nhaCungCap, giaThuoc, congDung, soLuong, donViTinh, ngaySanXuat, ngayHetHan);
				dsThuoc.add(t);
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
		return dsThuoc;
	}

	public ArrayList<Thuoc> getCboDonVi(){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select DISTINCT donViTinh from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String donViTinh = rs.getString("donViTinh");
				Thuoc t = new Thuoc(donViTinh);
				dsThuoc.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsThuoc;
	}
	
	public ArrayList<Thuoc> getCboCongDung(){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select DISTINCT congDung from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String cd = rs.getString("congDung");
				Thuoc t = new Thuoc(cd, "", "");
				dsThuoc.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsThuoc;
	}
	
	public ArrayList<Thuoc> getCboNCC(){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select DISTINCT nhaCungCap from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ncc = rs.getString("nhaCungCap");
				Thuoc t = new Thuoc(ncc, "");
				dsThuoc.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsThuoc;
	}
	
	public ArrayList<Thuoc> getMaTuTenThuoc(String ten){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select maThuoc from Thuoc where tenThuoc LIKE N'%" + ten +"%'";
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maThuoc");
				Thuoc t = new Thuoc(ma, "", "", "", "", "");
				dsThuoc.add(t);
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
		return dsThuoc;
	}
	
	public ArrayList<Thuoc> getGiaTuTenThuoc(String ten){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement stm = null;
		String sql = "Select giaThuoc from Thuoc where tenThuoc LIKE N'%" + ten +"%'";
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				double gia = rs.getDouble("giaThuoc");
				Thuoc t = new Thuoc(gia);
				dsThuoc.add(t);
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
		return dsThuoc;
	}
	
	public boolean create(Thuoc t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into Thuoc values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMaThuoc());
			stmt.setString(2, t.getTenThuoc());
			stmt.setString(3, t.getNhaCungCap());
			stmt.setDouble(4, t.getGiaThuoc());
			stmt.setString(5, t.getCongDung());
			stmt.setInt(6, t.getSoLuong());
			stmt.setString(7, t.getDonViTinh());
			stmt.setDate(8, t.getNgaySanXuat());
			stmt.setDate(9, t.getNgayHetHan());
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
		String sql = "DELETE FROM Thuoc WHERE maThuoc = '" + ma + "'";
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

	public boolean update(Thuoc t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Thuoc set maThuoc = ?, tenThuoc = ?, nhaCungCap = ?, giaThuoc = ?, congDung = ?, soLuong = ?, donViTinh = ?, ngaySanXuat = ?, ngayHetHan = ? WHERE maThuoc = ?");
			stmt.setString(1, t.getMaThuoc());
			stmt.setString(2, t.getTenThuoc());
			stmt.setString(3, t.getNhaCungCap());
			stmt.setDouble(4, t.getGiaThuoc());
			stmt.setString(5, t.getCongDung());
			stmt.setInt(6, t.getSoLuong());
			stmt.setString(7, t.getDonViTinh());
			stmt.setDate(8, t.getNgaySanXuat());
			stmt.setDate(9, t.getNgayHetHan());
			stmt.setString(10,  t.getMaThuoc());
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
