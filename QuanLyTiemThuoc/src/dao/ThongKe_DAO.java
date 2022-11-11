package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDonBanThuoc;
import entity.Thuoc;

public class ThongKe_DAO {
	public ArrayList<Thuoc> getThuoc(){
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select tenThuoc, nhaCungCap, donViTinh, ngaySanXuat, ngayHetHan, soLuong from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tenThuoc = rs.getString("tenThuoc");
				String nhaCungCap = rs.getString("nhaCungCap");
				String donViTinh = rs.getString("donViTinh");
				Date ngaySanXuat = rs.getDate("ngaySanXuat");
				Date ngayHetHan = rs.getDate("ngayHetHan");
				int soLuong = rs.getInt("soLuong");
				Thuoc t = new Thuoc(tenThuoc, nhaCungCap, soLuong, donViTinh, ngaySanXuat, ngayHetHan);
				dsThuoc.add(t);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsThuoc;
	}
	public ArrayList<HoaDonBanThuoc> getTongDoanhThu(){
		ArrayList<HoaDonBanThuoc> ds = new ArrayList<HoaDonBanThuoc>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select thanhTien from HoaDonBanThuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Double tien = rs.getDouble("thanhTien");
				HoaDonBanThuoc hdbt = new HoaDonBanThuoc(tien);
				ds.add(hdbt);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ds;
	}
}
